package com.hcl.utils;

public class PinGenerate {

	public static int generatePin(int min,int max) {
		int num=(int )(Math.random()*((max-min)+1))+min;
		
		return num;
	}
}
