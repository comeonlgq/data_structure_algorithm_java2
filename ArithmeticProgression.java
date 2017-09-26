package com.test.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 这是一个关于等差数列的代码
 * 
 * @author lgqin
 *
 */

public class ArithmeticProgression {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
//		System.out.println("请输入数列的长度：");
		int len = sc.nextInt();
		// 数列长度判断
		if (len < 2 || len > 50) {
//			System.out.println("输入的数列的长度不符合要求");
			return;
		}
		
		ArrayList<Integer> al = new ArrayList<Integer>();
//		System.out.println("请输入数列：");
		int count = 0;
		while (count <= len && sc.hasNextInt()) {
			int num = sc.nextInt();
			if (num < 0 | num > 1000) {
//				System.out.println("输入的数字超过范围！");
				return;
			}
			al.add(num);
			count++;
		}
		sc.close();
		int[] a = new int[len];
		int i = 0;
		for (int l : al) {
			a[i] = l;
			++i;
		}
		al = null;
		isAP(a, len);

	}

	public static void isAP(int[] a, int n) {
		boolean flag=false;
		heapsort(a,0,n-1);//堆排序
	//	System.out.println(Arrays.toString(a));
		int diff=a[0]-a[1],i;//用于存放两值之差
	//	System.out.println(diff);
		for(i=1;i<n-1;i++) {
	//		System.out.println(a[i]-a[i+1]);
			if(diff!=(a[i]-a[i+1])) {
				flag=true;
				break;
			}
		}
		if(flag) {
		   System.out.println("Impossible");
		}else {
		    System.out.println("Possible");
		}
		
	}


	// 堆排序(小根堆)(建堆)
	public static void heap(int[] a,int left,int right) {
		for (int i = (right-left+1) / 2 - 1; i >= 0; i--) {
			if (2 * i + 2 <= right) {// 拥有左右子树
				if (a[2 * i + 1] < a[2 * i + 2]) {
					if (a[i] > a[2 * i + 1])
						swap(a, i, 2 * i + 1);
				} else {
					if (a[i] > a[2 * i + 2])
						swap(a, i, 2 * i + 2);
				}
			} else {
				if (2 * i + 1 == right) {// 只有左子树
					if (a[i] > a[2 * i + 1])
						swap(a, i, 2 * i + 1);
				}
			}

		}
	}
	
	public static void heapsort(int[] a, int left, int right) {
		if (right > left) {
			heap(a,left,right);
			swap(a, left, right);
			heapsort(a, left, right - 1);
		}
	}
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
}
