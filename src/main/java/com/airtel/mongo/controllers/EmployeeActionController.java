package com.airtel.mongo.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airtel.mongo.models.Employee;
import com.airtel.mongo.service.EmployeeService;

//Controller for actions taken by Admin : Add, Update and Delete an Employee Details
@RestController
public class EmployeeActionController {

	@Autowired
	EmployeeService emplService;
	
	private Logger logger = Logger.getLogger(EmployeeActionController.class); //For logging

	// View Details of all the Employees in the organisation
	@RequestMapping(value = "/view", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> list() {
		List<String> response = emplService.listEmployee();

		if (response == null) {
			logger.error("Null response generated");
			return new ResponseEntity<String>("{\"message\" : \"Something went wrong!\"}", HttpStatus.NOT_FOUND);
		} else {
			logger.info("Get request executed");
			return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
		}
	}

	// Add Details of a new Employee
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> add(HttpEntity<String> entity) {
		if (entity.getBody() == null) {
			logger.error("Null request received");
			return new ResponseEntity<String>("{\"message\" : \"Something went wrong!\"}", HttpStatus.BAD_REQUEST);
		} else {
			emplService.add(entity.getBody());
			logger.info("Post request executed");
			return new ResponseEntity<String>("{\"message\" : \"Employee added successfully!\"}", HttpStatus.CREATED);
		}
	}

	// Update the Existing Employee Details
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<String> update(@PathVariable("id") String id, HttpEntity<String> entity) {
		Employee empl = emplService.findEmployeeById(id);

		if (empl == null) {
			logger.info("No employee found");
			return new ResponseEntity<String>("{\"message\" : \"Employee not found!\"}", HttpStatus.NOT_FOUND);
		} else {
			emplService.update(entity.getBody());
			logger.info("Update request executed");
			return new ResponseEntity<String>("{\"message\" : \"Employee updated successfully!\"}", HttpStatus.OK);
		}
	}

	// Delete Details of an Employee who has left the organisation
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		Employee empl = emplService.findEmployeeById(id);

		if (empl == null) {
			logger.info("No employee found");
			return new ResponseEntity<String>("{\"message\" : \"Employee not found!\"}", HttpStatus.NOT_FOUND);
		} else {
			emplService.delete(empl);
			logger.info("Delete request executed");
			return new ResponseEntity<String>("{\"message\" : \"Employee deleted successfully!\"}", HttpStatus.OK);
		}
	}
}
