package com.cognizant.springlearn;

import com.cognizant.springlearn.controller.EmployeeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() {
        assertNotNull(employeeController);
    }

    @Test
    void testGetAllEmployees() throws Exception {
        ResultActions actions = mvc.perform(get("/employees"));
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$").isArray());
        actions.andExpect(jsonPath("$[0].name").value("John"));
        actions.andExpect(jsonPath("$[0].id").value(1));
    }

    @Test
    void testGetEmployee() throws Exception {
        ResultActions actions = mvc.perform(get("/employees/1"));
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$.name").value("John"));
        actions.andExpect(jsonPath("$.department.name").value("IT"));
    }

    @Test
    void testGetEmployeeNotFound() throws Exception {
        ResultActions actions = mvc.perform(get("/employees/999"));
        actions.andExpect(status().isNotFound());
    }

    @Test
    void testAddEmployee() throws Exception {
        String employee = "{\"id\":5,\"name\":\"Test\",\"salary\":40000,"
                + "\"permanent\":true,\"dateOfBirth\":\"01/01/2000\"}";

        ResultActions actions = mvc.perform(
                post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employee)
        );
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$.name").value("Test"));
    }

    @Test
    void testUpdateEmployeeInvalidFormat() throws Exception {
        String invalidEmployee = "{\"id\":\"abc\",\"name\":\"John\"}";

        ResultActions actions = mvc.perform(
                put("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidEmployee)
        );

        actions.andExpect(status().isBadRequest());
    }

    @Test
    void testDeleteEmployee() throws Exception {
        ResultActions actions = mvc.perform(delete("/employees/4"));
        actions.andExpect(status().isOk());
    }

    @Test
    void testGetDepartments() throws Exception {
        ResultActions actions = mvc.perform(get("/departments"));
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$").isArray());
        actions.andExpect(jsonPath("$[0].name").value("IT"));
    }
}
