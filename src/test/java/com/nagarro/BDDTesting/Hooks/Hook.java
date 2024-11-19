package com.nagarro.BDDTesting.Hooks;


import com.nagarro.BDDTesting.utilities.BaseTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hook extends BaseTest{

    
    @Before
    public void BeforeScenario() {
        setUp();
        
    }
    
    @After
    public void AfterScenario(){
    	
    	tearDown();
    }
}
