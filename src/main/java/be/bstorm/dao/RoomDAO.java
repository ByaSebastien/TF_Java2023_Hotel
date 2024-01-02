package be.bstorm.dao;

import be.bstorm.models.entities.Room;
import jakarta.persistence.EntityManagerFactory;

public class RoomDAO extends CrudDAOImpl<Room,Long> {

    public RoomDAO(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    protected Class<Room> getEntityClass() {
        return Room.class;
    }

    @Override
    protected String getTableName() {
        return "Room";
    }
}
