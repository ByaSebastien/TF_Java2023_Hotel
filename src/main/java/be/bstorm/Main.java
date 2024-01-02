package be.bstorm;


import be.bstorm.dao.HotelDAO;
import be.bstorm.dao.RoomDAO;
import be.bstorm.dao.WorkerDAO;
import be.bstorm.models.entities.Address;
import be.bstorm.models.entities.Worker;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hotel_db");
        WorkerDAO workerDAO = new WorkerDAO(emf);
        HotelDAO hotelDAO = new HotelDAO(emf);
        RoomDAO roomDAO = new RoomDAO(emf);

        Address address = new Address("Rue cerisier","18","Bo","4000");
        Worker worker = new Worker("007","Bond","James",address,"bond@james.com","007");
        System.out.println("Test insert");
        workerDAO.insert(worker);
        System.out.println("________________________________________________________________________");
        System.out.println("List de worker");
        workerDAO.getAll().forEach(System.out::println);
        System.out.println("________________________________________________________________________");
        System.out.println("Worker 1");
        System.out.println(workerDAO.getOne(1L).orElse(null));
        System.out.println("________________________________________________________________________");
        System.out.println("Update du worker 1");
        Worker worker2 = new Worker("007","test","test",address,"bond@james.com","007");
        workerDAO.update(1L,worker2);
        System.out.println(workerDAO.getOne(1L).orElse(null));
        System.out.println("________________________________________________________________________");
        System.out.println("delete du worker 1");
        workerDAO.delete(1L);
        workerDAO.getAll().forEach(System.out::println);
    }
}