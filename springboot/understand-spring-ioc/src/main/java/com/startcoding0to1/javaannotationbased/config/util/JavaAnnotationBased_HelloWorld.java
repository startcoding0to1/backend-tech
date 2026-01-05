package com.startcoding0to1.javaannotationbased.config.util;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JavaAnnotationBased_HelloWorld {

    @Value("${spring.application.name}")
    String projectName;

    public JavaAnnotationBased_HelloWorld() {
        System.out.println("JavaAnnotationBased_HelloWorld class instantiated, Project Name: " + projectName);
    }

    public void testMeth(){
        System.out.println("Java annotation based Testing is successfully done inside the JavaAnnotationBased_HelloWorld class, Project Name: " + projectName);
    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct: " + projectName);
    }

}
