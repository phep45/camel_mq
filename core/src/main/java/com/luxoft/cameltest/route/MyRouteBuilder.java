package com.luxoft.cameltest.route;


import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("activemq:queue:SLIS")
                .to("log:com.luxoft.cameltest.route.MyRouteBuilder?level=DEBUG")
                .bean(Handler.class);
    }
}
