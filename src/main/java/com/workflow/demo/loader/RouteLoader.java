package com.workflow.demo.loader;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteLoader extends RouteBuilder {

    @Autowired
    private RouteProcessor routeProcessor;

    private String inputDir = "data/in";

    private String outputDir = "data/processed";

    @Override
    public void configure() throws Exception {

        from("file:" + inputDir).to("direct:fileProcessing").id("Route Loader");

        from("direct:fileProcessing").id("Internal Route Loader")
                .to("file:" + outputDir)
                .process(routeProcessor);

    }
}
