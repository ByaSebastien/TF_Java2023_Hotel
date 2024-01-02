package be.bstorm.dao;

import be.bstorm.models.entities.BaseEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class CrudDAOImpl<T extends BaseEntity<ID>,ID extends Serializable> implements CrudDAO<T,ID>{

    private final EntityManagerFactory emf;

    public CrudDAOImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    protected abstract Class<T> getEntityClass();
    protected abstract String getTableName();

    @Override
    public void insert(T entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<T> getAll(){
        EntityManager em = emf.createEntityManager();
        return em.createQuery("select e from " + getTableName() + " e",getEntityClass()).getResultList();
    }

    @Override
    public Optional<T> getOne(Long id) {
        EntityManager em = emf.createEntityManager();
        return Optional.ofNullable(em.find(getEntityClass(),id));
    }

    @Override
    public void update(ID id, T entity) {
        EntityManager em = emf.createEntityManager();
        T existingEntity = em.find(getEntityClass(),id);
        if(existingEntity != null){
            em.getTransaction().begin();
            entity.setId(id);
            em.merge(entity);
            em.getTransaction().commit();
        }
        em.close();
    }

    @Override
    public void delete(ID id) {
        EntityManager em = emf.createEntityManager();
        T existingEntity = em.find(getEntityClass(),id);
        if(existingEntity != null){
            em.getTransaction().begin();
            em.remove(existingEntity);
            em.getTransaction().commit();
        }
        em.close();
    }
}
