package com.startcoding0to1.autowiring.service;


import com.startcoding0to1.autowiring.repository.AWConstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AWConstructorService {

    AWConstructorRepo awConstructorRepo;

    @Autowired
    public AWConstructorService(AWConstructorRepo awConstructorRepo) {
        System.out.println("AWConstructorService is instantiated");
        this.awConstructorRepo = awConstructorRepo;
    }


    public void test(){
        System.out.println("Inside test method of AWConstructorService");
        this.awConstructorRepo.test();
    }
}
