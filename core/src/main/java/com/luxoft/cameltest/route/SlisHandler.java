package com.luxoft.cameltest.route;

import org.springframework.stereotype.Component;

import javax.inject.Named;

@Component
@Named("slisHandler")
public class SlisHandler {

    public void handle(String str) {
        System.out.println("Now I'm handling this SLIS msg: " + str);
    }

}
