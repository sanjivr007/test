package com.example.demo.call;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class JEReporter extends ExecutiveReporter {

	public JEReporter() {
		this.timeTakenInMinutes = 0;
		this.callAttended = 0;
		this.escalated = 0;
		this.resolved = 0;

	}

}
