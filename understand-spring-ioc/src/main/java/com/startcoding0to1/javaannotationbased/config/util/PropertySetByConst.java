package com.startcoding0to1.javaannotationbased.config.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertySetByConst {

    private final String name;

    private JavaAnnotationBased_HelloWorld helloworld5;

    public PropertySetByConst(@Value("${spring.application.name}") String name, JavaAnnotationBased_HelloWorld helloworld5) {
        this.name = name;
        System.out.println("Inside PropertySetByConst constructor, Project name is " + name);
        System.out.println("helloworld5 "+ helloworld5.toString());
    }
}
