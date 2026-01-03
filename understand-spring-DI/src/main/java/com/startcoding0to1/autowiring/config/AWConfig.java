package com.startcoding0to1.autowiring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.startcoding0to1.autowiring.service", "com.startcoding0to1.autowiring.repository"})
public class AWConfig {
}
