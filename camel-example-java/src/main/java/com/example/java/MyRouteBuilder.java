package com.example.java;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import com.example.beans.CamelProcessor;

/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

        // here is a sample which processes the input files
        // (leaving them in place - see the 'noop' flag)
        // then performs content based routing on the message using XPath
        from("file:src/data?noop=true")
            .choice()
                .when(xpath("/person/city = 'London'"))
                    .log("UK message")
                    .to("file:target/messages/uk")
                .otherwise()
                    .log("Other message")
                    .to("file:target/messages/others");
        
        from("cxfrs:http://0.0.0.0:9090?resourceClasses=com.example.java.CompanyService&bindingStyle=SimpleConsumer")
        .choice()
            .when(header("operationName").isEqualTo("getCompany")).process(new CamelProcessor());
              
      //  .end()
      //  .marshal().json(JsonLibrary.Jackson);
    }

}
