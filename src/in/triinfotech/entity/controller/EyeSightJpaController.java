/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.triinfotech.entity.controller;

import in.triinfotech.entity.EyeSight;
import in.triinfotech.entity.controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ajay
 */
public class EyeSightJpaController implements Serializable {

    public EyeSightJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EyeSight eyeSight) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(eyeSight);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EyeSight eyeSight) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            eyeSight = em.merge(eyeSight);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = eyeSight.getId();
                if (findEyeSight(id) == null) {
                    throw new NonexistentEntityException("The eyeSight with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EyeSight eyeSight;
            try {
                eyeSight = em.getReference(EyeSight.class, id);
                eyeSight.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The eyeSight with id " + id + " no longer exists.", enfe);
            }
            em.remove(eyeSight);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EyeSight> findEyeSightEntities() {
        return findEyeSightEntities(true, -1, -1);
    }

    public List<EyeSight> findEyeSightEntities(int maxResults, int firstResult) {
        return findEyeSightEntities(false, maxResults, firstResult);
    }

    private List<EyeSight> findEyeSightEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EyeSight.class));
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

    public EyeSight findEyeSight(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EyeSight.class, id);
        } finally {
            em.close();
        }
    }

    public int getEyeSightCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EyeSight> rt = cq.from(EyeSight.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
