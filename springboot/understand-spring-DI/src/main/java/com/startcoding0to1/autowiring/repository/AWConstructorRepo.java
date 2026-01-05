package com.startcoding0to1.autowiring.repository;

import org.springframework.stereotype.Repository;

@Repository
public class AWConstructorRepo {

    public AWConstructorRepo() {
        System.out.println("AWConstructorRepo is instantiated");
    }

    public void test() {
        System.out.println("Inside test method of AWConstructorRepo");
    }
}
