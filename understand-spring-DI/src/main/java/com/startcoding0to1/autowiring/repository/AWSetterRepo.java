package com.startcoding0to1.autowiring.repository;

import org.springframework.stereotype.Repository;

@Repository
public class AWSetterRepo {

    public AWSetterRepo() {
        System.out.println("AWsetterRepo is instantiated");
    }

    public void test() {
        System.out.println("Inside test method of AWsetterRepo");
    }
}
