package com.emmakatwebaze.SpringBootpractice.service;

import com.emmakatwebaze.SpringBootpractice.entity.Department;
import com.emmakatwebaze.SpringBootpractice.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    // @BeforeAll executes once and @BeforeEach executes for each test case

    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Kampala")
                .departmentCode("IT-06")
                .departmentId(1L).build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);

    }

    @Test
    @DisplayName("Get Data based on Valid Department Name")
    //@Disabled - if you have many test cases, and you want to disable one of them
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}