package com.example.demo.call;

import org.springframework.stereotype.Component;

@Component
public class ExecutiveReporter {
	int timeTakenInMinutes;
	int callAttended;
	int resolved;
	int escalated;
	public int getTimeTakenInMinutes() {
		return timeTakenInMinutes;
	}
	public void setTimeTakenInMinutes(int timeTakenInMinutes) {
		this.timeTakenInMinutes = timeTakenInMinutes;
	}
	public int getCallAttended() {
		return callAttended;
	}
	public void setCallAttended(int callAttended) {
		this.callAttended = callAttended;
	}
	public int getResolved() {
		return resolved;
	}
	public void setResolved(int resolved) {
		this.resolved = resolved;
	}
	public int getEscalated() {
		return escalated;
	}
	public void setEscalated(int escalated) {
		this.escalated = escalated;
	}

	
	
}
