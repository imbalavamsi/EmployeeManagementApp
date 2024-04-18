package com.moxieit.employeemanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.moxieit.employeemanagement.controller.EmployeeController;
import com.moxieit.employeemanagement.dao.Employee;
import com.moxieit.employeemanagement.service.KafkaService;

@Service
public class KafkaServiceImpl implements KafkaService {

	@Autowired
	EmployeeController employeeController;
	
	@Autowired
	KafkaTemplate<String , String> kafkaTemplate;

	@KafkaListener(topics="topic1", groupId = "id")
	public void publish(String message) {
		Employee employee = new Employee();
		JsonElement jsonElement = JsonParser.parseString(message);
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		employee.setEmpID(Long.parseLong(jsonObject.get("empID").toString()));
		employee.setFirstname(jsonObject.get("firstname").toString());
		employee.setLastname(jsonObject.get("lastname").toString());
		employee.setAddress(jsonObject.get("address").toString());
		employee.setSalary(Long.parseLong(jsonObject.get("salary").toString()));
		Employee newEmployee = employeeController.insertDynamicEmployee(employee);
		sendMessage(message);
	}

	public void sendMessage(String message)
	{
		kafkaTemplate.send("test-topic",message);
	}
}
