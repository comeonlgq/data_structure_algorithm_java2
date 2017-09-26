package com.test.one;

/**
 * 这是一个临时函数，用于计算的
 * @author lgqin
 *
 */
public class Temp {

	public static void main(String[] args) {
		int[] a= {143,199,203,489,528,583,585,606,608,661};
		int []b= {489, 583, 606, 199, 661, 143, 608, 203, 585, 528};
		int []c= {489, 606,583, 199, 661, 143, 608,  585, 203,528};//交换一次
		int []d={489, 606,199,583, 661, 143,  585,608, 203,528};//交换两次
		
	    count(b);
	    count(c);
	    count(d);


	}
	
	public static void count(int []a) {
		int sum=0;
		for(int i=1;i<a.length;i++) {
			sum+=Math.abs(a[i]-a[i-1]);
		}
		System.out.println(sum);
	}

}
