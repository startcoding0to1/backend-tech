package com.startcoding0to1.springboot_jwt_auth.service;

import com.startcoding0to1.springboot_jwt_auth.entity.UserRegisterEntity;
import com.startcoding0to1.springboot_jwt_auth.repository.UserRegisterEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterEntityService implements UserDetailsService {


    @Autowired
    private UserRegisterEntityRepository userRegisterEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRegisterEntityRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username + " user not found"));
    }

    public UserDetails save(UserRegisterEntity userRegisterEntity){
        return userRegisterEntityRepository.save(userRegisterEntity);
    }
}
