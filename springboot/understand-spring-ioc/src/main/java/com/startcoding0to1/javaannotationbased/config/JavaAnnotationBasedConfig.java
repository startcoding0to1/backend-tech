package com.startcoding0to1.javaannotationbased.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan //I put util inside config so it will scan automatically else we can define class path here
public class JavaAnnotationBasedConfig {
}
