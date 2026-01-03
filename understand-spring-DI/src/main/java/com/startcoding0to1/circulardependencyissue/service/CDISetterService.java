package com.startcoding0to1.circulardependencyissue.service;

import com.startcoding0to1.circulardependencyissue.repository.CDISetterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CDISetterService {

    CDISetterRepo cdiSetterRepo;

    public CDISetterService() {
        System.out.println("CDISetterService is instantiated");
    }

    @Autowired
    public void setCdiSetterService(CDISetterRepo cdiSetterRepo) {
        System.out.println("setCdiSetterService of CDISetterService");
        this.cdiSetterRepo = cdiSetterRepo;
    }

    public void test(){
        System.out.println("Inside CDISetterService test");
        this.cdiSetterRepo.test();
    }
}
