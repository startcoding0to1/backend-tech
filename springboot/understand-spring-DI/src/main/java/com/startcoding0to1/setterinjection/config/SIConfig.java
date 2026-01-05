package com.startcoding0to1.setterinjection.config;

import com.startcoding0to1.setterinjection.repository.SIRepo;
import com.startcoding0to1.setterinjection.service.SIService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SIConfig {

    @Bean
    public SIService siService(){
        SIService siService = new SIService();
        siService.setSIRepo(siRepo());
        return siService;
    }


    @Bean
    public SIRepo siRepo(){
        return new SIRepo();
    }
}
