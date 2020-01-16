/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entity.ArticalTbl;
import entity.UserTbl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import service.exceptions.NonexistentEntityException;

/**
 *
 * @author Rukesh
 */
public class UserTblJpaController1 implements Serializable {

    public UserTblJpaController1(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UserTbl userTbl) {
        if (userTbl.getArticalTblCollection() == null) {
            userTbl.setArticalTblCollection(new ArrayList<ArticalTbl>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<ArticalTbl> attachedArticalTblCollection = new ArrayList<ArticalTbl>();
            for (ArticalTbl articalTblCollectionArticalTblToAttach : userTbl.getArticalTblCollection()) {
                articalTblCollectionArticalTblToAttach = em.getReference(articalTblCollectionArticalTblToAttach.getClass(), articalTblCollectionArticalTblToAttach.getId());
                attachedArticalTblCollection.add(articalTblCollectionArticalTblToAttach);
            }
            userTbl.setArticalTblCollection(attachedArticalTblCollection);
            em.persist(userTbl);
            for (ArticalTbl articalTblCollectionArticalTbl : userTbl.getArticalTblCollection()) {
                UserTbl oldUseridOfArticalTblCollectionArticalTbl = articalTblCollectionArticalTbl.getUserid();
                articalTblCollectionArticalTbl.setUserid(userTbl);
                articalTblCollectionArticalTbl = em.merge(articalTblCollectionArticalTbl);
                if (oldUseridOfArticalTblCollectionArticalTbl != null) {
                    oldUseridOfArticalTblCollectionArticalTbl.getArticalTblCollection().remove(articalTblCollectionArticalTbl);
                    oldUseridOfArticalTblCollectionArticalTbl = em.merge(oldUseridOfArticalTblCollectionArticalTbl);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UserTbl userTbl) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UserTbl persistentUserTbl = em.find(UserTbl.class, userTbl.getId());
            Collection<ArticalTbl> articalTblCollectionOld = persistentUserTbl.getArticalTblCollection();
            Collection<ArticalTbl> articalTblCollectionNew = userTbl.getArticalTblCollection();
            Collection<ArticalTbl> attachedArticalTblCollectionNew = new ArrayList<ArticalTbl>();
            for (ArticalTbl articalTblCollectionNewArticalTblToAttach : articalTblCollectionNew) {
                articalTblCollectionNewArticalTblToAttach = em.getReference(articalTblCollectionNewArticalTblToAttach.getClass(), articalTblCollectionNewArticalTblToAttach.getId());
                attachedArticalTblCollectionNew.add(articalTblCollectionNewArticalTblToAttach);
            }
            articalTblCollectionNew = attachedArticalTblCollectionNew;
            userTbl.setArticalTblCollection(articalTblCollectionNew);
            userTbl = em.merge(userTbl);
            for (ArticalTbl articalTblCollectionOldArticalTbl : articalTblCollectionOld) {
                if (!articalTblCollectionNew.contains(articalTblCollectionOldArticalTbl)) {
                    articalTblCollectionOldArticalTbl.setUserid(null);
                    articalTblCollectionOldArticalTbl = em.merge(articalTblCollectionOldArticalTbl);
                }
            }
            for (ArticalTbl articalTblCollectionNewArticalTbl : articalTblCollectionNew) {
                if (!articalTblCollectionOld.contains(articalTblCollectionNewArticalTbl)) {
                    UserTbl oldUseridOfArticalTblCollectionNewArticalTbl = articalTblCollectionNewArticalTbl.getUserid();
                    articalTblCollectionNewArticalTbl.setUserid(userTbl);
                    articalTblCollectionNewArticalTbl = em.merge(articalTblCollectionNewArticalTbl);
                    if (oldUseridOfArticalTblCollectionNewArticalTbl != null && !oldUseridOfArticalTblCollectionNewArticalTbl.equals(userTbl)) {
                        oldUseridOfArticalTblCollectionNewArticalTbl.getArticalTblCollection().remove(articalTblCollectionNewArticalTbl);
                        oldUseridOfArticalTblCollectionNewArticalTbl = em.merge(oldUseridOfArticalTblCollectionNewArticalTbl);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = userTbl.getId();
                if (findUserTbl(id) == null) {
                    throw new NonexistentEntityException("The userTbl with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UserTbl userTbl;
            try {
                userTbl = em.getReference(UserTbl.class, id);
                userTbl.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The userTbl with id " + id + " no longer exists.", enfe);
            }
            Collection<ArticalTbl> articalTblCollection = userTbl.getArticalTblCollection();
            for (ArticalTbl articalTblCollectionArticalTbl : articalTblCollection) {
                articalTblCollectionArticalTbl.setUserid(null);
                articalTblCollectionArticalTbl = em.merge(articalTblCollectionArticalTbl);
            }
            em.remove(userTbl);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UserTbl> findUserTblEntities() {
        return findUserTblEntities(true, -1, -1);
    }

    public List<UserTbl> findUserTblEntities(int maxResults, int firstResult) {
        return findUserTblEntities(false, maxResults, firstResult);
    }

    private List<UserTbl> findUserTblEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UserTbl.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public UserTbl findUserTbl(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UserTbl.class, id);
        } finally {
            em.close();
        }
    }

    public int getUserTblCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UserTbl> rt = cq.from(UserTbl.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
