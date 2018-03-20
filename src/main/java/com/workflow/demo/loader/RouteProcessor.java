package com.workflow.demo.loader;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;
import org.apache.camel.model.RoutesDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;


@Component
public class RouteProcessor implements Processor {

    @Autowired
    CamelContext context;

    @Override
    public void process(Exchange exchange) throws Exception {

        File file = extractFile(exchange);
        System.out.println("Processing File: " + (file.getName()));
        loadRouteFrom(file);

    }

    private void loadRouteFrom(File file) throws Exception {
        RoutesDefinition routes = context.loadRoutesDefinition(new FileInputStream(file));
        context.addRouteDefinitions(routes.getRoutes());
    }

    private File extractFile(Exchange exchange) {
        GenericFile genericFile = (GenericFile) exchange.getIn().getBody();
        return (File) genericFile.getFile();
    }
}
