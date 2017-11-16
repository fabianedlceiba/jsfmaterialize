/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.jsfproject;

import com.fernando.jsfproject.service.TestService;
import com.fernando.jsfproject.service.UserService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author fabian.diaz
 */
@ManagedBean
@ViewScoped
public class TestBean implements Serializable {
    
    private String hello;
    
    @ManagedProperty("#{TestServiceImpl}")
    private TestService testService;
    
    public TestBean() {
        System.out.println("Se creo ...");
    }

    @PostConstruct
    public void init() {
        this.hello = this.testService.test();
        System.out.println("Init ..." + this.hello);
    }
    
    public TestService getTestService(){
        return this.testService;
    }
    
    public void setTestService(TestService testService) {
        this.testService = testService;
    }
    
    public void setHello(String hello) {
        this.hello = hello;
    }
    
    public String getHello() {
        return this.hello;
    }
    
    public String guardar() {
        System.out.println("Guardar ....");
        return null;
    }    
    
}
