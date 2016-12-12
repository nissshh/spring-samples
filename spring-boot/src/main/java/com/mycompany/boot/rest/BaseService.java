package com.mycompany.boot.rest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class BaseService {

	static Logger logger = LoggerFactory.getLogger(BaseService.class);

	public BaseService() {
		super();
	}

	SERVICE_STATUS status = SERVICE_STATUS.NONE;

	private String status() {
		return status.getStatus();
	}

	@PostConstruct
	public void init() {
		this.status = SERVICE_STATUS.STARTED;
		logServiceStatus();
	}

	private void logServiceStatus() {
		logger.info("Service Status " + this.status.getStatus());
	}

	@PreDestroy
	public void destroy() {
		this.status = SERVICE_STATUS.STOPPED;
		logServiceStatus();
	}

	
}