package com.moxieit.employeemanagement.service;

public interface KafkaService {

	public void publish(String message);

	public void sendMessage(String message);
}
