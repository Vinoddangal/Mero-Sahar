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
import entity.LocationTabl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import service.exceptions.IllegalOrphanException;
import service.exceptions.NonexistentEntityException;

/**
 *
 * @author Rukesh
 */
public class LocationTablJpaController1 implements Serializable {

    public LocationTablJpaController1(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LocationTabl locationTabl) {
        if (locationTabl.getArticalTblCollection() == null) {
            locationTabl.setArticalTblCollection(new ArrayList<ArticalTbl>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<ArticalTbl> attachedArticalTblCollection = new ArrayList<ArticalTbl>();
            for (ArticalTbl articalTblCollectionArticalTblToAttach : locationTabl.getArticalTblCollection()) {
                articalTblCollectionArticalTblToAttach = em.getReference(articalTblCollectionArticalTblToAttach.getClass(), articalTblCollectionArticalTblToAttach.getId());
                attachedArticalTblCollection.add(articalTblCollectionArticalTblToAttach);
            }
            locationTabl.setArticalTblCollection(attachedArticalTblCollection);
            em.persist(locationTabl);
            for (ArticalTbl articalTblCollectionArticalTbl : locationTabl.getArticalTblCollection()) {
                LocationTabl oldLocationidOfArticalTblCollectionArticalTbl = articalTblCollectionArticalTbl.getLocationid();
                articalTblCollectionArticalTbl.setLocationid(locationTabl);
                articalTblCollectionArticalTbl = em.merge(articalTblCollectionArticalTbl);
                if (oldLocationidOfArticalTblCollectionArticalTbl != null) {
                    oldLocationidOfArticalTblCollectionArticalTbl.getArticalTblCollection().remove(articalTblCollectionArticalTbl);
                    oldLocationidOfArticalTblCollectionArticalTbl = em.merge(oldLocationidOfArticalTblCollectionArticalTbl);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LocationTabl locationTabl) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LocationTabl persistentLocationTabl = em.find(LocationTabl.class, locationTabl.getId());
            Collection<ArticalTbl> articalTblCollectionOld = persistentLocationTabl.getArticalTblCollection();
            Collection<ArticalTbl> articalTblCollectionNew = locationTabl.getArticalTblCollection();
            List<String> illegalOrphanMessages = null;
            for (ArticalTbl articalTblCollectionOldArticalTbl : articalTblCollectionOld) {
                if (!articalTblCollectionNew.contains(articalTblCollectionOldArticalTbl)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ArticalTbl " + articalTblCollectionOldArticalTbl + " since its locationid field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<ArticalTbl> attachedArticalTblCollectionNew = new ArrayList<ArticalTbl>();
            for (ArticalTbl articalTblCollectionNewArticalTblToAttach : articalTblCollectionNew) {
                articalTblCollectionNewArticalTblToAttach = em.getReference(articalTblCollectionNewArticalTblToAttach.getClass(), articalTblCollectionNewArticalTblToAttach.getId());
                attachedArticalTblCollectionNew.add(articalTblCollectionNewArticalTblToAttach);
            }
            articalTblCollectionNew = attachedArticalTblCollectionNew;
            locationTabl.setArticalTblCollection(articalTblCollectionNew);
            locationTabl = em.merge(locationTabl);
            for (ArticalTbl articalTblCollectionNewArticalTbl : articalTblCollectionNew) {
                if (!articalTblCollectionOld.contains(articalTblCollectionNewArticalTbl)) {
                    LocationTabl oldLocationidOfArticalTblCollectionNewArticalTbl = articalTblCollectionNewArticalTbl.getLocationid();
                    articalTblCollectionNewArticalTbl.setLocationid(locationTabl);
                    articalTblCollectionNewArticalTbl = em.merge(articalTblCollectionNewArticalTbl);
                    if (oldLocationidOfArticalTblCollectionNewArticalTbl != null && !oldLocationidOfArticalTblCollectionNewArticalTbl.equals(locationTabl)) {
                        oldLocationidOfArticalTblCollectionNewArticalTbl.getArticalTblCollection().remove(articalTblCollectionNewArticalTbl);
                        oldLocationidOfArticalTblCollectionNewArticalTbl = em.merge(oldLocationidOfArticalTblCollectionNewArticalTbl);
                    }
                }
            }
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

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            Collection<ArticalTbl> articalTblCollectionOrphanCheck = locationTabl.getArticalTblCollection();
            for (ArticalTbl articalTblCollectionOrphanCheckArticalTbl : articalTblCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This LocationTabl (" + locationTabl + ") cannot be destroyed since the ArticalTbl " + articalTblCollectionOrphanCheckArticalTbl + " in its articalTblCollection field has a non-nullable locationid field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
