package com.startcoding0to1.circulardependencyissue.repository;

import com.startcoding0to1.circulardependencyissue.service.CDIConstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class CDIConstructorRepo {

    CDIConstructorService cdiConstructorService;

    @Autowired
    public CDIConstructorRepo(@Lazy CDIConstructorService cdiConstructorService) { //If we remove @Lazy we will face circular dependency
        System.out.println("CDIConstructorRepo is instantiated");
        this.cdiConstructorService = cdiConstructorService;
    }

    public void test(){
        System.out.println("Inside CDIConstructorRepo test");
    }
}
