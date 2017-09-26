package com.test.one;
import java.util.Scanner;
/**
 * 最多可以多活几天
 * @author lgqin
 *
 */
public class MaxAliveDay {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		int f=sc.nextInt();
		int d=sc.nextInt();
		int p=sc.nextInt();
		if(x<1 || x>2*Math.pow(10, 9))
			return;
		if(f<1 || f>2*Math.pow(10, 9))
			return;
		if(d<1 || d>2*Math.pow(10, 9))
			return;
		if(p<1 || p>2*Math.pow(10, 9))
			return;
		
		sc.close();
		int maxDay;
		if(f*p>Math.pow(2, 32)-1 || f*p<0) {
			int t=d/x;
			if(t>f) {
				maxDay=f+(d-x*f)/(p+x);
			}else {
				maxDay=t;
			}
			
		}else {
			if(d+f*p>Math.pow(2, 32)-1 || d+f*p<0) {
				int t=d/x;
				if(t>f) {
					maxDay=f+(d-x*f)/(p+x);
				}else {
					maxDay=t;
				}
			}else {
			   maxDay=Math.min((d+f*p)/(p+x),d/x);
			}
		}
		
		System.out.println(maxDay);

	}

}
