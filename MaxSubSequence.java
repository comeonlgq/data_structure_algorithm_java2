package com.test.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 这是一个求最长公共子序列的问
 * 
 * @author lgqin
 *
 */
public class MaxSubSequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = new String();
		s = sc.nextLine();
		if (s.length() < 1) {
			return;
		}
		sc.close();
		// System.out.println(s);
		maxLen(s);
	}

	public static void maxLen(String s) {
		int[] a = new int[s.length()];
		int[] d=new int[s.length()];
		// 首先将字符串01转换为相邻之差的形式
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++) {
			String t = s.substring(i, i + 1);
			a[i] = Integer.parseInt(t);
		}

		if (a.length == 1) {
			System.out.println(1);
			return;
		}
		d[0] = Math.abs(a[0] - a[1]);
		d[a.length - 1] = Math.abs(a[a.length - 1] - a[a.length - 2]);
		for (int i = 1; i < a.length - 1; i++) {
			d[i] =Math.abs(a[i] - a[i+1]);
		}
		a=null;
		s=null;
//		for (int i = 1; i < d.length - 1; i++) {
//			System.out.println(d[i]);
//		}
		int[] sum = new int[d.length];// 用于存放和值
		if (d[0] == 1) {
			sum[0] = 1;
		}
		int max = sum[0];
		for (int i = 1; i < d.length; i++) {
			if (d[i] == 1) {
				sum[i] = sum[i - 1] + 1;
			} else {
				sum[i] = 1;
			}
			if (max < sum[i])
				max = sum[i];
		}

		System.out.println(max);
	}
}
