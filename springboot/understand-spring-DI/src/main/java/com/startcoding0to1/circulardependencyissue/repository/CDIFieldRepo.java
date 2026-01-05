package com.startcoding0to1.circulardependencyissue.repository;

import com.startcoding0to1.circulardependencyissue.service.CDIFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CDIFieldRepo {

    @Autowired
    CDIFieldService cdiFieldService;

    public CDIFieldRepo() {
        System.out.println("CDIFieldRepo is instantiated");
    }

    public void test(){
        System.out.println("Inside CDIFieldRepo test");
    }
}
