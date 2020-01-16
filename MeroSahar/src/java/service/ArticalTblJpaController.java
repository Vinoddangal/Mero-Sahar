/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.ArticalTbl;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entity.LocationTabl;
import entity.UserTbl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import service.exceptions.NonexistentEntityException;

/**
 *
 * @author Rukesh
 */
public class ArticalTblJpaController implements Serializable {

    public ArticalTblJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ArticalTbl articalTbl) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LocationTabl locationid = articalTbl.getLocationid();
            if (locationid != null) {
                locationid = em.getReference(locationid.getClass(), locationid.getId());
                articalTbl.setLocationid(locationid);
            }
            UserTbl userid = articalTbl.getUserid();
            if (userid != null) {
                userid = em.getReference(userid.getClass(), userid.getId());
                articalTbl.setUserid(userid);
            }
            em.persist(articalTbl);
            if (locationid != null) {
                locationid.getArticalTblCollection().add(articalTbl);
                locationid = em.merge(locationid);
            }
            if (userid != null) {
                userid.getArticalTblCollection().add(articalTbl);
                userid = em.merge(userid);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ArticalTbl articalTbl) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArticalTbl persistentArticalTbl = em.find(ArticalTbl.class, articalTbl.getId());
            LocationTabl locationidOld = persistentArticalTbl.getLocationid();
            LocationTabl locationidNew = articalTbl.getLocationid();
            UserTbl useridOld = persistentArticalTbl.getUserid();
            UserTbl useridNew = articalTbl.getUserid();
            if (locationidNew != null) {
                locationidNew = em.getReference(locationidNew.getClass(), locationidNew.getId());
                articalTbl.setLocationid(locationidNew);
            }
            if (useridNew != null) {
                useridNew = em.getReference(useridNew.getClass(), useridNew.getId());
                articalTbl.setUserid(useridNew);
            }
            articalTbl = em.merge(articalTbl);
            if (locationidOld != null && !locationidOld.equals(locationidNew)) {
                locationidOld.getArticalTblCollection().remove(articalTbl);
                locationidOld = em.merge(locationidOld);
            }
            if (locationidNew != null && !locationidNew.equals(locationidOld)) {
                locationidNew.getArticalTblCollection().add(articalTbl);
                locationidNew = em.merge(locationidNew);
            }
            if (useridOld != null && !useridOld.equals(useridNew)) {
                useridOld.getArticalTblCollection().remove(articalTbl);
                useridOld = em.merge(useridOld);
            }
            if (useridNew != null && !useridNew.equals(useridOld)) {
                useridNew.getArticalTblCollection().add(articalTbl);
                useridNew = em.merge(useridNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = articalTbl.getId();
                if (findArticalTbl(id) == null) {
                    throw new NonexistentEntityException("The articalTbl with id " + id + " no longer exists.");
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
            ArticalTbl articalTbl;
            try {
                articalTbl = em.getReference(ArticalTbl.class, id);
                articalTbl.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The articalTbl with id " + id + " no longer exists.", enfe);
            }
            LocationTabl locationid = articalTbl.getLocationid();
            if (locationid != null) {
                locationid.getArticalTblCollection().remove(articalTbl);
                locationid = em.merge(locationid);
            }
            UserTbl userid = articalTbl.getUserid();
            if (userid != null) {
                userid.getArticalTblCollection().remove(articalTbl);
                userid = em.merge(userid);
            }
            em.remove(articalTbl);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ArticalTbl> findArticalTblEntities() {
        return findArticalTblEntities(true, -1, -1);
    }

    public List<ArticalTbl> findArticalTblEntities(int maxResults, int firstResult) {
        return findArticalTblEntities(false, maxResults, firstResult);
    }

    private List<ArticalTbl> findArticalTblEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ArticalTbl.class));
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

    public ArticalTbl findArticalTbl(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ArticalTbl.class, id);
        } finally {
            em.close();
        }
    }

    public int getArticalTblCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ArticalTbl> rt = cq.from(ArticalTbl.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
