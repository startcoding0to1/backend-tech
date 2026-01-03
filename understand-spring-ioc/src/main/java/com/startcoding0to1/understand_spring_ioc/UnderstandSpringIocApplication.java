package com.startcoding0to1.understand_spring_ioc;

import com.startcoding0to1.javaannotationbased.config.JavaAnnotationBasedConfig;
import com.startcoding0to1.javaannotationbased.config.util.JavaAnnotationBased_HelloWorld;
import com.startcoding0to1.javabased.config.JavaBasedConfig;
import com.startcoding0to1.javabased.util.JavaBased_HelloWorld;
import com.startcoding0to1.xmlbased.util.XML_HelloWorld;
import com.startcoding0to1.xmlbased.utilwithautoscan.XML_withAutoScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class UnderstandSpringIocApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnderstandSpringIocApplication.class, args);

        //Java based
        ApplicationContext context1 = new AnnotationConfigApplicationContext(JavaBasedConfig.class);
        JavaBased_HelloWorld helloworld1 = context1.getBean(JavaBased_HelloWorld.class);
        helloworld1.testMeth();

        ApplicationContext context2 = new AnnotationConfigApplicationContext(JavaAnnotationBasedConfig.class);
        JavaAnnotationBased_HelloWorld helloworld2 = context2.getBean(JavaAnnotationBased_HelloWorld.class);
        helloworld2.testMeth();

        ApplicationContext context3 = new ClassPathXmlApplicationContext("applicationContext.xml");
        XML_HelloWorld helloworld3 = context3.getBean(XML_HelloWorld.class);
        helloworld3.testMeth();
        XML_withAutoScan helloworld4 = context3.getBean(XML_withAutoScan.class);
        helloworld4.testMeth();
	}

}
