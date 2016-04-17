package com.luxoft.cameltest.route;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


//spring config
//spring jms component
//move this aproche to main application
//it test (awaitility java)
//out mq sending message (trn/-id) to outmq

@Component
public class MyRouteBuilder extends RouteBuilder {

    public static final String ACTIVEMQ_QUEUE_SLIS_XLIS = "activemq:queue:%s";
    public static final String XLIS = "XLIS";
    public static final String SLIS = "SLIS";

    private static  final List<String> mqs = Arrays.asList(SLIS,XLIS);

    @Override
    public void configure() throws Exception {
        mqs.forEach(val -> {
            from(String.format(ACTIVEMQ_QUEUE_SLIS_XLIS, val))
                    .id(val)
                    .to("log:com.luxoft.cameltest.route.MyRouteBuilder?level=DEBUG")
                    .choice()
                        .when(v -> SLIS.equals(v.getFromRouteId())).bean(SlisHandler.class)
                        .when(v -> XLIS.equals(v.getFromRouteId())).bean(XlisHandler.class)
                    // trans
//                    .endChoice()
                    .end()
                    //persist
                    //send other // out_mq transaction id

//                    .bean(SlisHandler.class)
                    .to("activemq:queue:TEST");
        });

    }
}
