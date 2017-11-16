/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.jsfproject.service.impl;

import com.fernando.jsfproject.repositories.TestRepository;
import com.fernando.jsfproject.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author
 */
@Service("TestServiceImpl")
public class TestServiceImpl implements TestService {
    
    @Autowired
    private TestRepository testRepository;

    @Override
    public String test() {
        return testRepository.test();
    }
    
}
