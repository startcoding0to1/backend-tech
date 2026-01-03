package com.startcoding0to1.circulardependencyissue.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.startcoding0to1.circulardependencyissue.service", "com.startcoding0to1.circulardependencyissue.repository"})
public class CDIConfig {
}
