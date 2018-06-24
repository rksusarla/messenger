package com.artilekt.messenger.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// @Repository, @Service, @RestController
public class ConsoleAuditService implements AuditService {
	private EchoService echoService;

	public ConsoleAuditService(EchoService echoService) {
		this.echoService = echoService;
	}
	
	public ConsoleAuditService() {}

	public void createLogEntry(String logEntry) {
		System.out.println("CONSOLE LOG: "+new Date()+": "+logEntry);
		
	}

}
