package com.workflow.demo.user;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class UserRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        rest("/user").description("User      rest service")
                .consumes("application/json").produces("application/json")

                .get("/").description("Find all users").outTypeList(User.class)
                .to("bean:userService?method=getUsers");

    }

}