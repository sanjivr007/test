package com.example.demo.call;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public class LocalConfiguration {
	 
	private JEReporter jeReporter;

    @Bean
    public JE JEBean() {
		return new JE(EType.JE);
        // instantiate, configure and return bean ...
    }
    
    @Bean
    public SE SEBean() {
		return new SE(EType.SE);
        // instantiate, configure and return bean ...
    }
    
    @Bean
    public MGR MGRBean() {
		return new MGR(EType.MGR);
        // instantiate, configure and return bean ...
    }
    
    @Bean
    public JEReporter JERseporter() {
    	jeReporter=new JEReporter();
		return jeReporter;
        // instantiate, configure and return bean ...
    }
    
    @Bean
    public SEReporter SEReporter() {
		return new SEReporter();
        // instantiate, configure and return bean ...
    }
    
    @Bean
    public MgrReporter MgrReporter() {
		return new MgrReporter();
        // instantiate, configure and return bean ...
    }

}
