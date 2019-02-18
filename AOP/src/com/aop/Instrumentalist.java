package com.aop;

public class Instrumentalist implements Performer {

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("Playing Guitar");
		//throw new RuntimeException();
	}

}
