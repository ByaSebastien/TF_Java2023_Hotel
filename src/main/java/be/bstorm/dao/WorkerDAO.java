package be.bstorm.dao;

import be.bstorm.models.entities.Worker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.Optional;

public class WorkerDAO extends CrudDAOImpl<Worker,Long> {

    public WorkerDAO(EntityManagerFactory emf) {
        super(emf);;
    }

    @Override
    protected Class<Worker> getEntityClass() {
        return Worker.class;
    }

    @Override
    protected String getTableName() {
        return "Worker";
    }
}
