package com.startcoding0to1.circulardependencyissue.service;

import com.startcoding0to1.circulardependencyissue.repository.CDIConstructorRepo;
import com.startcoding0to1.circulardependencyissue.repository.CDIFieldRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CDIConstructorService {

    CDIConstructorRepo cdiConstructorRepo;

    @Autowired
    public CDIConstructorService(CDIConstructorRepo cdiConstructorRepo) {
        System.out.println("CDIConstructorService is instantiated");
        this.cdiConstructorRepo = cdiConstructorRepo;
    }

    public void test(){
        System.out.println("Inside CDIConstructorService test");
        this.cdiConstructorRepo.test();
    }
}
