/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.BlogTbl;
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
public class BlogTblJpaController implements Serializable {

    public BlogTblJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BlogTbl blogTbl) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(blogTbl);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BlogTbl blogTbl) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            blogTbl = em.merge(blogTbl);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = blogTbl.getId();
                if (findBlogTbl(id) == null) {
                    throw new NonexistentEntityException("The blogTbl with id " + id + " no longer exists.");
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
            BlogTbl blogTbl;
            try {
                blogTbl = em.getReference(BlogTbl.class, id);
                blogTbl.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The blogTbl with id " + id + " no longer exists.", enfe);
            }
            em.remove(blogTbl);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BlogTbl> findBlogTblEntities() {
        return findBlogTblEntities(true, -1, -1);
    }

    public List<BlogTbl> findBlogTblEntities(int maxResults, int firstResult) {
        return findBlogTblEntities(false, maxResults, firstResult);
    }

    private List<BlogTbl> findBlogTblEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BlogTbl.class));
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

    public BlogTbl findBlogTbl(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BlogTbl.class, id);
        } finally {
            em.close();
        }
    }

    public int getBlogTblCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BlogTbl> rt = cq.from(BlogTbl.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
