package com.startcoding0to1.constructorinjection.config;

import com.startcoding0to1.constructorinjection.repository.CIRepo;
import com.startcoding0to1.constructorinjection.service.CIService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CIConfig {

   @Bean
    public CIService ciService(){
       return new CIService(ciRepo());
   }

   @Bean
    public CIRepo ciRepo(){
       return new CIRepo();
   }
}
