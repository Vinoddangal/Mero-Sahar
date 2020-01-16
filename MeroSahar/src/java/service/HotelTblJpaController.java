/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.HotelTbl;
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
public class HotelTblJpaController implements Serializable {

    public HotelTblJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HotelTbl hotelTbl) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(hotelTbl);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HotelTbl hotelTbl) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            hotelTbl = em.merge(hotelTbl);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = hotelTbl.getId();
                if (findHotelTbl(id) == null) {
                    throw new NonexistentEntityException("The hotelTbl with id " + id + " no longer exists.");
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
            HotelTbl hotelTbl;
            try {
                hotelTbl = em.getReference(HotelTbl.class, id);
                hotelTbl.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The hotelTbl with id " + id + " no longer exists.", enfe);
            }
            em.remove(hotelTbl);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HotelTbl> findHotelTblEntities() {
        return findHotelTblEntities(true, -1, -1);
    }

    public List<HotelTbl> findHotelTblEntities(int maxResults, int firstResult) {
        return findHotelTblEntities(false, maxResults, firstResult);
    }

    private List<HotelTbl> findHotelTblEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HotelTbl.class));
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

    public HotelTbl findHotelTbl(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HotelTbl.class, id);
        } finally {
            em.close();
        }
    }

    public int getHotelTblCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HotelTbl> rt = cq.from(HotelTbl.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
