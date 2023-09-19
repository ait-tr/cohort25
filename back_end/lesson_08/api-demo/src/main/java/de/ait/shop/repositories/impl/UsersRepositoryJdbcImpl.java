package de.ait.shop.repositories.impl;

import de.ait.shop.models.User;
import de.ait.shop.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from account where id = ?";

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from account";

    //language=SQL
    private static final String SQL_UPDATE_BY_ID = "update account set first_name = ?, last_name = ? where id = ?";

    //language=SQL
    private static final String SQL_DELETE_USER_BY_ID = "delete from account where id = ?";

    private final DataSource dataSource;

    private final JdbcTemplate jdbcTemplate;

    private static final RowMapper<User> USER_ROW_MAPPER = (row, rowNumber) -> {
        Long id = row.getLong("id");
        String firstName = row.getString("first_name");
        String lastName = row.getString("last_name");
        String email = row.getString("email");
        String password = row.getString("password");

        return User.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .build();
    };

    @Override
    public User findById(Long id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, USER_ROW_MAPPER , id);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, USER_ROW_MAPPER);
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
        jdbcTemplate.update(SQL_DELETE_USER_BY_ID, id);
    }

    @Override
    public void update(User model) {
        jdbcTemplate.update(SQL_UPDATE_BY_ID, model.getFirstName(), model.getLastName(), model.getId());
    }

    @Override
    public User findOneByEmail(String email) {
        return null;
    }
}
