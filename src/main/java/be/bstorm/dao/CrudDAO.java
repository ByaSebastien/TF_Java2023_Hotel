package be.bstorm.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDAO<T,ID> {

    void insert(T entity);

    List<T> getAll();

    Optional<T> getOne(Long id);

    void update(ID id,T entity);

    void delete(ID id);
}
