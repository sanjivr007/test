package com.example.demo.call;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



public class SE implements CallReceiver {

	final int maxDuration = 10;
	EType etype;

	public SE(EType etype) {
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
