/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.jsfproject.repositories.impl;

import com.fernando.jsfproject.repositories.TestRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fabian.diaz
 */
@Repository
public class TestRepositoryImpl implements TestRepository {

    @Override
    public String test() {
        return "43434343";
    }
    
}
