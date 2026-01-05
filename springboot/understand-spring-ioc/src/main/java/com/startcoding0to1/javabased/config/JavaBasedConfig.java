package com.startcoding0to1.javabased.config;

import com.startcoding0to1.javabased.util.JavaBased_HelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaBasedConfig {

    @Bean
    public JavaBased_HelloWorld helloWorld(){
        return new JavaBased_HelloWorld();
    }
}
