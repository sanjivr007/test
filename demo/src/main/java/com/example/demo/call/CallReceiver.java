package com.example.demo.call;

import org.springframework.stereotype.Component;


public interface CallReceiver {
	
	void processCall();
	int getMaxDuration();
	EType getEtype();

}
