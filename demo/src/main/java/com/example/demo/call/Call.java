package com.example.demo.call;

public class Call implements Comparable<Call> {
	int priority;
	int timeSpent;
	String executiveno;
	
	CallReceiver callReceiver;

	public Call(int priority, int timeSpent, String i,CallReceiver callReceiver) {
		this.priority = priority;
		this.timeSpent = timeSpent;
		this.executiveno = i;
		this.callReceiver=callReceiver;
		
	}

	public int compareTo(Call b) {
		if ((priority >= b.priority)) {
			return 1;
		} else if (priority < b.priority) {
			return -1;
		} else {
			return 0;
		}

	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(int timeSpent) {
		this.timeSpent = timeSpent;
	}

	public String getExecutiveno() {
		return executiveno;
	}

	public void setExecutiveno(String executiveno) {
		this.executiveno = executiveno;
	}

	public CallReceiver getCallReceiver() {
		return callReceiver;
	}

	public void setCallReceiver(CallReceiver callReceiver) {
		this.callReceiver = callReceiver;
	}

	
	

}
