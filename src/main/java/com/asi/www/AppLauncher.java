package com.asi.www;

import org.apache.camel.CamelContext;
import org.apache.camel.spi.RestConfiguration;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.apache.camel.spring.boot.FatJarRouter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ankur on 17-12-2016.
 */
@SpringBootApplication
@Configuration
public class AppLauncher extends FatJarRouter{

public static void main(String... args){
    SpringApplication.run(AppLauncher.class,args);

}



    @Bean
    CamelContextConfiguration contextConfiguration() {
        return new CamelContextConfiguration() {

            public void beforeApplicationStart(CamelContext context)  {

                RestConfiguration restConfiguration = new RestConfiguration();
                restConfiguration.setComponent("jetty");
                //restConfiguration.setBindingMode(RestConfiguration.RestBindingMode.json);
                restConfiguration.setPort(9886);
                restConfiguration.setHost("0.0.0.0");
                restConfiguration.setContextPath("/service-mock");

                Map componentProperties = new HashMap();
                componentProperties.put("handlers","#staticResourceHandler");
                componentProperties.put("enablemulti-partFilter",true);
                componentProperties.put("enableCORS",true);
                restConfiguration.setComponentProperties(componentProperties);

                context.setRestConfiguration(restConfiguration);
                context.setStreamCaching(true);

            }

            public void afterApplicationStart(CamelContext camelContext) {

            }
        };
    }
}
