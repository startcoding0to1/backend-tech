package com.startcoding0to1.autowiring.service;

import com.startcoding0to1.autowiring.repository.AWSetterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AWSetterService {

    AWSetterRepo awSetterRepo;

    public AWSetterService() {
        System.out.println("AWSetterService is instantiated");
    }

    @Autowired
    public void setAWSetterRepo(AWSetterRepo awSetterRepo) {
        this.awSetterRepo = awSetterRepo;
    }

    public void test(){
        System.out.println("Inside test method of AWSetterService");
        this.awSetterRepo.test();
    }
}
