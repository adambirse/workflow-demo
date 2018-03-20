package com.workflow.demo.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class SayHello extends RouteBuilder {

    @Override
    public void configure() throws Exception {


        restConfiguration()
                .contextPath("/camel-rest-jpa").apiContextPath("/api-doc")
                .apiProperty("api.title", "Camel REST API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true")
                .apiContextRouteId("doc-api")
                .bindingMode(RestBindingMode.json);

        rest("/say")
                .get("/").to("direct:hello");

        from("direct:hello")
                .log("Processed")
                .transform().constant("Hello World from REST");

    }

}