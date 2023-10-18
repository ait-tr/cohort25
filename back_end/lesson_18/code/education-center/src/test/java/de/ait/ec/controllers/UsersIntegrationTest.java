package de.ait.ec.controllers;

import de.ait.ec.security.config.TestSecurityConfig;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 9/27/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@SpringBootTest(classes = TestSecurityConfig.class)
@AutoConfigureMockMvc
@DisplayName("Endpoint /users is works:")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@ActiveProfiles("test")
public class UsersIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Nested
    @DisplayName("GET /users:")
    public class GetUsers {

        @Test
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        public void return_401_for_unauthorized() throws Exception {
            mockMvc.perform(get("/api/users"))
                    .andExpect(status().isUnauthorized());
        }

        @WithUserDetails(value = "user")
        @Test
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        public void return_403_for_not_admin() throws Exception {
            mockMvc.perform(get("/api/users"))
                    .andExpect(status().isForbidden());
        }

        @WithUserDetails(value = "admin")
        @Test
        @Sql(scripts = "/sql/data.sql")
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        public void return_list_of_users() throws Exception {
            mockMvc.perform(get("/api/users"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.size()", is(1)));
        }
    }

    @Nested
    @DisplayName("POST /users/register:")
    public class RegisterUser {

        @Test
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        public void return_created_user() throws Exception {
            mockMvc.perform(post("/api/users/register")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\n" +
                            "  \"email\": \"sidikov.marsel@gmail.com\",\n" +
                            "  \"password\": \"Qwerty007!\"\n" +
                            "}"))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.id", is(1)))
                    .andExpect(jsonPath("$.role", is("USER")));
        }

        @Test
        public void return_400_for_bad_format_email() throws Exception {
            mockMvc.perform(post("/api/users/register")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\n" +
                                    "  \"email\": \"sidikov.marselgmail.com\",\n" +
                                    "  \"password\": \"Qwerty007!\"\n" +
                                    "}"))
                    .andExpect(status().isBadRequest());
        }

        @Test
        @Sql(scripts = "/sql/data.sql")
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        public void return_409_for_existed_email() throws Exception {
            mockMvc.perform(post("/api/users/register")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\n" +
                                    "  \"email\": \"sidikov.marsel@gmail.com\",\n" +
                                    "  \"password\": \"Qwerty007!\"\n" +
                                    "}"))
                    .andExpect(status().isConflict());
        }
    }
}
