package com.luxoft.cameltest.route;


import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file://tmp/in?noop=true")
                .to("log:com.luxoft.cameltest.route.MyRouteBuilder?level=DEBUG")
                .to("file://tmp/out");

        
    }
}
