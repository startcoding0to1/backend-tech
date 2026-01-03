package com.startcoding0to1.constructorinjection.service;


import com.startcoding0to1.constructorinjection.repository.CIRepo;

public class CIService {

    private CIRepo ciRepo;

    public CIService(CIRepo ciRepo){
        this.ciRepo=ciRepo;
        System.out.println("CIService class instantiated");
    }


    public void test(){
        System.out.println("I am inside CIService");
        this.ciRepo.test();
    }
}
