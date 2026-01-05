package com.startcoding0to1.javaannotationbased.config.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertySetBySetterMeth {

    private String name;
    private JavaAnnotationBased_HelloWorld helloworld5;

    @Autowired
    public void setHelloworld5(JavaAnnotationBased_HelloWorld helloworld5) {
        this.helloworld5 = helloworld5;
        System.out.println("setHelloworld5: "+helloworld5);
    }

    @Value("${spring.application.name}")
    public void setName(String name) {
        this.name = name;
        System.out.println("setName: "+name);
    }
}
