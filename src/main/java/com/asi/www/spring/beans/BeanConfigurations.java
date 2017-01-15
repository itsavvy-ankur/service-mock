package com.asi.www.spring.beans;

import com.mongodb.MongoClient;
import org.apache.camel.spi.DataFormat;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ankur on 14-01-2017.
 */
@Configuration
public class BeanConfigurations {

@Bean
public ResourceHandler staticResourceHandler(){
    ResourceHandler resourceHandler = new ResourceHandler();
    resourceHandler.setDirectoriesListed(true);
    resourceHandler.setResourceBase(".");
    return resourceHandler;
}

@Bean
public MongoClient mongoBean(){
    MongoClient mongoClient = new MongoClient("localhost",27017);
    return mongoClient;
}

@Bean
public DataFormat customFormat(){

    return new org.apache.camel.component.jackson.ListJacksonDataFormat();
}
}

