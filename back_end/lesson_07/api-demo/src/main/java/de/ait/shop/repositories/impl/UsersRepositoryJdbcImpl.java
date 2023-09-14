package de.ait.shop.repositories.impl;

import de.ait.shop.models.User;
import de.ait.shop.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 9/13/2023
 * api-demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@Repository
public class UsersRepositoryJdbcImpl implements UsersRepository {

    private final DataSource dataSource;

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void save(User model) {
        // создаем объект для отправки INSERT-запроса в базу данных на основе DataSource
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(dataSource)
                .usingGeneratedKeyColumns("id"); // какая колонка используется для автогенерируемого первичного ключа

        jdbcInsert.withTableName("account"); // с какой таблицей будем работать

        Map<String, Object> parameters = new HashMap<>(); // создаем словарь с параметрами для добавления данных

        parameters.put("first_name", model.getFirstName()); // говорим, что в колонку first_name нужно добавить значение firstName из модели
        parameters.put("last_name", model.getLastName());  // говорим, что в колонку last_name нужно добавить значение lastName из модели
        parameters.put("email", model.getEmail());  // говорим, что в колонку email нужно добавить значение email из модели
        parameters.put("password", model.getPassword());  // говорим, что в колонку password нужно добавить значение password из модели

        long generatedId = jdbcInsert.executeAndReturnKey(parameters).longValue(); // выполняем запрос и получаем сгенерированный ключ

        model.setId(generatedId); // проставили id сохраняемой модели
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public User findOneByEmail(String email) {
        return null;
    }
}
