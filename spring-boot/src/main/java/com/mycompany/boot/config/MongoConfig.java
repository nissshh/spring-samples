package com.mycompany.boot.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {
	
	@Value("#{systemProperties['databaseName']}")
	private String databaseName;
	
	@Value("#{systemProperties['hostName']}")
	private String hostName;
		
	@Value("#{systemProperties['port']}")
	private int port;
	
	@Override
	protected String getDatabaseName() {
		return databaseName;
	}

	@PostConstruct
	public void init(){
		assert databaseName != null;
		assert hostName != null;
		assert port != 0;
		
	}
	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient(hostName);
	}

	@Override
	protected String getMappingBasePackage() {
		return "com.mycompany.boot.data.modal";
	}
}
