package be.bstorm.dao;

import be.bstorm.models.entities.Worker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.Optional;

public class WorkerDAO implements CrudDAO<Worker,Long> {

    private final EntityManagerFactory emf;

    public WorkerDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void insert(Worker worker) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(worker);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Worker> getAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT W FROM Worker W", Worker.class).getResultList();
    }

    @Override
    public Optional<Worker> getOne(Long id) {
        EntityManager em = emf.createEntityManager();
        return Optional.ofNullable(em.find(Worker.class,id));
    }

    @Override
    public void update(Long id, Worker worker) {
        EntityManager em = emf.createEntityManager();
        worker.setId(id);
        em.getTransaction().begin();
        em.merge(worker);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        Worker worker = em.find(Worker.class,id);
        if(worker != null){
            em.getTransaction().begin();
            em.remove(worker);
            em.getTransaction().commit();
        }
        em.close();
    }
}
