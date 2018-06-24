package com.artilekt.messenger.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.artilekt.messenger.services.AuditService;
import com.artilekt.messenger.services.ConsoleAuditService;

@Configuration
public class AppConfig {
    @Autowired
    private ApplicationContext ctx;
    
    @Value("${auditService}")
    private String auditServiceName;
    
    
	@Bean
	public AuditService defaultAuditService() {
		return ctx.getBean(auditServiceName, AuditService.class);
	}

}
