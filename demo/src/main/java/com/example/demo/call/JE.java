package com.example.demo.call;

import org.springframework.stereotype.Component;


public class JE implements CallReceiver {

	final int maxDuration = 7;
	EType etype;

	public JE(EType etype) {
		this.etype = etype;

	}

	@Override
	public void processCall() {
		// TODO Auto-generated method stub

	}

	public EType getEtype() {
		return etype;
	}

	public void setEtype(EType etype) {
		this.etype = etype;
	}

	@Override
	public int getMaxDuration() {
		return maxDuration;
	}

}
