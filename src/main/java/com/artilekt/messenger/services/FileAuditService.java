package com.artilekt.messenger.services;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class FileAuditService implements AuditService {

	@Override
	public void createLogEntry(String logEntry) {
		System.out.println("FILE LOG: "+new Date()+": "+logEntry);
		
	}

}
