package com.test.one;
import java.util.Scanner;
/**
 * 这是一个计算喜欢数列的个数的代码
 * @author lgqin
 *
 */

public class LoveSequenceNum {
	public static final int MAXNUM =1000000007;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(1>n||10<n) {
        	return;
        }
        int k=sc.nextInt();
        if(1>k||Math.pow(10, 5)<k) {
        	return;
        }
        
        sc.close();
        int number=countLike(n,k);
        System.out.println(number);
	}

	public static int countLike(int n,int k) {
		int number=k;//当所有数字都相同时候，是小易喜欢的类型
		if(n==1) {
			number=k;
		}else {
			for(int i=2;i<=Math.min(n, k);i++) {//i表示从1到k中取的数的个数
				number+=k*(k-1)/2;
			}
		}
		
		return number%MAXNUM;
	}
	
	public static void count(int []a,int n) {
		
	}
	
}
