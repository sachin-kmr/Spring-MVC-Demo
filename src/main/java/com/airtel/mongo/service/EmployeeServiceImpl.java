package com.airtel.mongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airtel.mongo.dao.EmployeeDao;
import com.airtel.mongo.models.Employee;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// Bean
	@Autowired
	EmployeeDao emplDao;

	public List<String> listEmployee() {
		
		List<Employee> empList = emplDao.listEmployee();
		Iterator<Employee> iter = empList.iterator();
		List<String> res = new ArrayList<String>();

		Gson gson = new Gson();
		while (iter.hasNext()) {
			res.add(gson.toJson(iter.next())); //Conversion of all the employees object to json string
		}
		return res;
	}

	public void add(String empl) {
		Gson g = new Gson();
		Employee employee = g.fromJson(empl, Employee.class);
		emplDao.add(employee);
	}

	public void update(String empl) {
		Gson g = new Gson();
		Employee employee = g.fromJson(empl, Employee.class);
		emplDao.update(employee);
	}

	public void delete(Employee empl) {
		emplDao.delete(empl);
	}

	public Employee findEmployeeById(String id) {
		return emplDao.findEmployeeById(id);
	}
}