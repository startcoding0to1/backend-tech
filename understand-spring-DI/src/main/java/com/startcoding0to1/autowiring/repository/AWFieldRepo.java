package com.startcoding0to1.autowiring.repository;

import org.springframework.stereotype.Repository;

@Repository
public class AWFieldRepo {

    public AWFieldRepo() {
        System.out.println("AWFieldRepo is instantiated");
    }
    public void test() {
        System.out.println("Inside test method of AWFieldRepo");
    }
}
