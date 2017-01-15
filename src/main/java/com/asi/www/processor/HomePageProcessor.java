package com.asi.www.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

/**
 * Created by Ankur on 14-01-2017.
 */
@Component
public class HomePageProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getOut().setBody("<html><h1>Hello World</h1>" +
                "<form name=\"upload_form\" enctype=\"multipart/form-data\" method=\"post\" action=\"/test\">" +
                "<input type=\"file\" name=\"fname\">" +
                "<input type=\"submit\" value=\"Upload\" />" +
                "</form>" +
                "</html>");
        exchange.getOut().setHeader(Exchange.CONTENT_TYPE,"text/html");
    }
}
