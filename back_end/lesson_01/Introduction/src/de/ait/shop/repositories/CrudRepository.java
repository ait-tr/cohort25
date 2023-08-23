package de.ait.shop.repositories;

import java.util.List;

// CRUD - Create, Read, Update, Delete (создать, прочитать, обновить, удалить)
public interface CrudRepository<T> {
    T findById(Long id);

    List<T> findAll();

    void save(T model);

    void deleteById(Long id);

    void update(T model);

}
