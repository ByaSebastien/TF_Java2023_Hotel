package be.bstorm.dao;

import be.bstorm.models.entities.Hotel;
import jakarta.persistence.EntityManagerFactory;

public class HotelDAO extends CrudDAOImpl<Hotel,Long> {
    public HotelDAO(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    protected Class<Hotel> getEntityClass() {
        return Hotel.class;
    }

    @Override
    protected String getTableName() {
        return "Hotel";
    }
}
