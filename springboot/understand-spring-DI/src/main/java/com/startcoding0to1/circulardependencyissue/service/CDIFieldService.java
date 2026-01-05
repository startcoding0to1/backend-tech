package com.startcoding0to1.circulardependencyissue.service;

import com.startcoding0to1.circulardependencyissue.repository.CDIFieldRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CDIFieldService {

    @Autowired
    CDIFieldRepo cdiFieldRepo;

    public CDIFieldService() {
        System.out.println("CDIFieldService is instantiated");
    }

    public void test(){
        System.out.println("Inside CDIFieldService test");
        this.cdiFieldRepo.test();
    }
}
