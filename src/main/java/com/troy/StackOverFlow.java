package com.troy;

public class StackOverFlow {
	
	public void methodA() {
		methodB();
	}
	
	public void methodB() {
		methodA();
	}

}
