package com.asi.www.processor;

import org.apache.camel.Attachment;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

/**
 * Created by Ankur on 14-01-2017.
 */

@Component
public class FileProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        System.out.println("Body : " + exchange.getIn().getBody(String.class));
      //  Attachment attachment = exchange.getIn().getAttachmentObject("fname");
      //  exchange.getOut().setBody(attachment.getDataHandler().getContent().toString());
    }
}
