/**
 * @filename Test.java
 * @author lg
 * @date 2017年11月28日 下午2:51:07
 * @version 1.0
 * Copyright (C) 2017 
 */

package com.util;

public class Test {
	int sum=0;
	public  void sum(int i){
		sum=sum+i;
		i++;
		if(i<=100){
			sum(i);
		}
	}
	
	public static void main(String[] args) {
		Test test=new Test();
		test.sum(1);
		System.out.println(test.sum);
	/*	int sum=0;
	     for (int i = 1; i <=100; i++) {
	    	 sum+=i;
		}
	     System.out.println(sum);*/
	
	}

}
