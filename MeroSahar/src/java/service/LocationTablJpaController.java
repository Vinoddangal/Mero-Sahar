/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.LocationTabl;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import service.exceptions.NonexistentEntityException;

/**
 *
 * @author Rukesh
 */
public class LocationTablJpaController implements Serializable {

    public LocationTablJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LocationTabl locationTabl) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(locationTabl);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LocationTabl locationTabl) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            locationTabl = em.merge(locationTabl);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = locationTabl.getId();
                if (findLocationTabl(id) == null) {
                    throw new NonexistentEntityException("The locationTabl with id " + id + " no longer exists.");
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
            LocationTabl locationTabl;
            try {
                locationTabl = em.getReference(LocationTabl.class, id);
                locationTabl.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The locationTabl with id " + id + " no longer exists.", enfe);
            }
            em.remove(locationTabl);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<LocationTabl> findLocationTablEntities() {
        return findLocationTablEntities(true, -1, -1);
    }

    public List<LocationTabl> findLocationTablEntities(int maxResults, int firstResult) {
        return findLocationTablEntities(false, maxResults, firstResult);
    }

    private List<LocationTabl> findLocationTablEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LocationTabl.class));
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

    public LocationTabl findLocationTabl(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LocationTabl.class, id);
        } finally {
            em.close();
        }
    }

    public int getLocationTablCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LocationTabl> rt = cq.from(LocationTabl.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
