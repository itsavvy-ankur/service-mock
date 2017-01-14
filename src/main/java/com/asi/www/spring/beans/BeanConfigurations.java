package com.asi.www.spring.beans;

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
}

