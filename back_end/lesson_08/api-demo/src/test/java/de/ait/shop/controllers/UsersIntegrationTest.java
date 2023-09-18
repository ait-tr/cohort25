package de.ait.shop.controllers;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayName("Endpoint /users is works:")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UsersIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Nested
    @DisplayName("GET /users")
    public class GetUsers {

        @Test
        @Sql(scripts = {"/sql/schema.sql", "/sql/data.sql"})
        public void return_list_of_users() throws Exception {
            mockMvc.perform(get("/api/users"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.size()", is(4)))
                    .andExpect(jsonPath("$.[0].id", is(1)))
                    .andExpect(jsonPath("$.[0].firstName", is("User1FN")))
                    .andExpect(jsonPath("$.[1].id", is(2)))
                    .andExpect(jsonPath("$.[2].id", is(3)))
                    .andExpect(jsonPath("$.[3].id", is(4)));
        }
    }

    @Nested
    @DisplayName("POST /users")
    public class PostUsers {

        @Test
        @Sql(scripts = {"/sql/schema.sql", "/sql/data.sql"})
        public void return_created_user() throws Exception {
            mockMvc.perform(post("/api/users")
                            .contentType("application/json")
                            .content("{\n" +
                                    "  \"firstName\": \"Marsel\",\n" +
                                    "  \"lastName\": \"Sidikov\",\n" +
                                    "  \"email\": \"sidikov.marsel@gmail.com\",\n" +
                                    "  \"password\": \"qwerty007\"\n" +
                                    "}"))
                    .andExpect(jsonPath("$.id", is(5)))
                    .andExpect(status().isCreated());
        }
    }
}