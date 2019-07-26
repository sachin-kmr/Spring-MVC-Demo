package com.airtel.mongo.service;

import java.util.List;
import com.airtel.mongo.models.Employee;

public interface EmployeeService {

    public List<String> listEmployee();

    public void add(String empl);

    public void update(String empl);

    public void delete(Employee empl);

    public Employee findEmployeeById(String id);
}