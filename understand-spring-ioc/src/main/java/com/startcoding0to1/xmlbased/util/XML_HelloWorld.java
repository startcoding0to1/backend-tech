package com.startcoding0to1.xmlbased.util;

import jakarta.annotation.PostConstruct;

public class XML_HelloWorld {

    String message;

    public XML_HelloWorld(String num) {
        System.out.println("XML_HelloWorld class instantiated, message: "+message+" num : "+num);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void testMeth(){
        System.out.println("XML Based=1 Testing is successfully done inside the XML_HelloWorld class");
    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct: " + message);
    }
}
