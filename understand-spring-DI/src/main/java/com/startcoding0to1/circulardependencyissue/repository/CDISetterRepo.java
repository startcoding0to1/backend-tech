package com.startcoding0to1.circulardependencyissue.repository;

import com.startcoding0to1.circulardependencyissue.service.CDISetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CDISetterRepo {

    CDISetterService cdiSetterService;

    public CDISetterRepo() {
        System.out.println("CDISetterRepo is instantiated");
    }

    @Autowired
    public void setCdiSetterService(CDISetterService cdiSetterService) {
        System.out.println("setCdiSetterService of CDISetterRepo");
        this.cdiSetterService = cdiSetterService;
    }

    public void test(){
        System.out.println("Inside CDISetterRepo test");
    }
}
