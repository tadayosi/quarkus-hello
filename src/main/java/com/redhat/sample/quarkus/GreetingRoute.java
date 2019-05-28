package com.redhat.sample.quarkus;

import io.quarkus.runtime.annotations.RegisterForReflection;
import org.apache.camel.builder.RouteBuilder;

@RegisterForReflection
public class GreetingRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:greeting?period={{camel.timer.period}}").routeId("greeting-route")
                .setBody().constant("Hello Camel!")
                .log("${body}");
    }

}
