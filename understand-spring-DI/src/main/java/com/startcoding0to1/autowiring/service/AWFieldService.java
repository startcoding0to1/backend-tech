package com.startcoding0to1.autowiring.service;


import com.startcoding0to1.autowiring.repository.AWFieldRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AWFieldService {

    @Autowired
    AWFieldRepo awFieldRepo;

    public AWFieldService() {
        System.out.println("AWFieldService is instantiated");
    }


    public void test(){
        System.out.println("Inside test method of AWFieldService");
        this.awFieldRepo.test();
    }
}
