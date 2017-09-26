package com.test.one;
/**
 * 这是一个求素数（质数）的代码，素数是指该数只能被１和自身整除
 * @author lgqin
 *
 */
import java.util.Scanner;
public class Prime {

	public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       while(true) {
    	   int n=sc.nextInt();
    	   boolean flag = isPrime(n);
    	   if(flag) {
    		   System.out.println(n+"是素数！");
    	   }else {
    		   System.out.println(n+"不是素数！");
    	   }
       }
     
	}
	
	public static boolean isPrime(int n) {
		boolean flag=true;
		for(int i=2;i<=Math.sqrt(n);++i) {
			if(n%i==0) {
				flag=false;
				break;
			}
		}
		return flag;
	}

}
