package com.example.demo.call;

import java.util.ArrayList;
import java.util.List;

public class Request {
	
	String number_of_calls;
	List<String> je= new ArrayList<>();
	List<String> se= new ArrayList<>();
	String mgr;
	public String getNumber_of_calls() {
		return number_of_calls;
	}
	public void setNumber_of_calls(String number_of_calls) {
		this.number_of_calls = number_of_calls;
	}
	public List<String> getJe() {
		return je;
	}
	public void setJe(List<String> je) {
		this.je = je;
	}
	public List<String> getSe() {
		return se;
	}
	public void setSe(List<String> se) {
		this.se = se;
	}
	public String getMgr() {
		return mgr;
	}
	public void setMgr(String mgr) {
		this.mgr = mgr;
	}
	
	

}
