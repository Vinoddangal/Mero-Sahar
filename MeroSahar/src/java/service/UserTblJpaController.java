/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.UserTbl;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import service.exceptions.NonexistentEntityException;

/**
 *
 * @author Rukesh
 */
public class UserTblJpaController implements Serializable {

    public UserTblJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UserTbl userTbl) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(userTbl);
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
            userTbl = em.merge(userTbl);
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
    
    public UserTbl checkLogin(String email) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        UserTbl results = null;
        try {
            results = (UserTbl) em.createNamedQuery("UserTbl.findByEmail")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch(NullPointerException | NoResultException e){
            throw new NonexistentEntityException("The users with email:"+email+"no longer exsits");
            
        }
        return results;
    }
    
}
