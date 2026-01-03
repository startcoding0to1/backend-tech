package com.startcoding0to1.setterinjection.service;

import com.startcoding0to1.setterinjection.repository.SIRepo;

public class SIService {

    private SIRepo siRepo;

    public SIService(){
        System.out.println("SIService class instantiated");
    }

    public void setSIRepo(SIRepo siRepo) {
        this.siRepo = siRepo;
    }

    public void test(){
        System.out.println("I am inside SIService");
        this.siRepo.test();
    }
}
