package com.startcoding0to1.understand_spring_DI;

import com.startcoding0to1.autowiring.config.AWConfig;
import com.startcoding0to1.autowiring.service.AWConstructorService;
import com.startcoding0to1.autowiring.service.AWFieldService;
import com.startcoding0to1.autowiring.service.AWSetterService;
import com.startcoding0to1.circulardependencyissue.config.CDIConfig;
import com.startcoding0to1.circulardependencyissue.service.CDIConstructorService;
import com.startcoding0to1.circulardependencyissue.service.CDIFieldService;
import com.startcoding0to1.circulardependencyissue.service.CDISetterService;
import com.startcoding0to1.constructorinjection.config.CIConfig;
import com.startcoding0to1.constructorinjection.service.CIService;
import com.startcoding0to1.setterinjection.config.SIConfig;
import com.startcoding0to1.setterinjection.service.SIService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class UnderstandSpringDiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnderstandSpringDiApplication.class, args);

        System.out.println("=========Setter Injection===========");
        AbstractApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(SIConfig.class);
        applicationContext1.getBean(SIService.class).test();

        System.out.println("=========Constructor Injection===========");
        AbstractApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(CIConfig.class);
        applicationContext2.getBean(CIService.class).test();

        System.out.println("==============Autowiring================");
        AbstractApplicationContext applicationContext3 = new AnnotationConfigApplicationContext(AWConfig.class);
        System.out.println("========Setter Autowiring===========");
        applicationContext3.getBean(AWSetterService.class).test();
        System.out.println("========Constructor Autowiring===========");
        applicationContext3.getBean(AWConstructorService.class).test();
        System.out.println("========Field Autowiring===========");
        applicationContext3.getBean(AWFieldService.class).test();


        System.out.println("==============Circular dependency issue================");
        AbstractApplicationContext applicationContext4 = new AnnotationConfigApplicationContext(CDIConfig.class);
        System.out.println("==============Testing Circular dependency issue with Field autowiring================");
        applicationContext4.getBean(CDIFieldService.class).test();
        System.out.println("==============Testing Circular dependency issue with Setter autowiring================");
        applicationContext4.getBean(CDISetterService.class).test();
        System.out.println("==============Testing Circular dependency issue with Constructor autowiring================");
        applicationContext4.getBean(CDIConstructorService.class).test();

    }

}
