package com.asi.www.processor;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankur on 16-01-2017.
 */

@Component
public class MongodbProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Exchange : " + exchange.getIn().getBody());

        ArrayList list = (ArrayList) exchange.getIn().getBody();

        List<DBObject> dblist = new ArrayList<DBObject>();
        for(Object obj : list ){
            BasicDBObject doc =  new BasicDBObject();
            doc.append("key"+obj.hashCode(),obj);

            dblist.add(doc);
        }

        exchange.getIn().setBody(dblist);
    }
}
