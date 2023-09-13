package de.ait.shop.repositories;

import java.util.List;

// CRUD - Create, Read, Update, Delete (создать, прочитать, обновить, удалить)
public interface CrudRepository<T> {
    T findById(Long id); // поиск по идентификатору

    List<T> findAll(); // получение всех данных

    void save(T model); // сохранение объекта в хранилище

    void deleteById(Long id); // удаление по id

    void update(T model); // обновление данных в хранилище

}
