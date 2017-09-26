package com.test.one;
/*
 * This code write on 2017-09-01 by lgqin
 * 这是一个网易上的一个面试题，关于砖块排色的问题
 */
import java.util.Scanner;
public class WY_zhuankuai {

	public static void zhuankuaipaise(String s) {
		int num = 0;
		num = typeColor(s);
		System.out.println(num);
	}

	public static boolean isAllCapNumber(String s) {
		boolean flag = true;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) < 'A' || s.charAt(i) > 'Z') {
				flag = false;
			}
		}
		return flag;
	}

	public static int typeColor(String s) {
		int number = 0;
		int[] a = new int[26];
		for (int i = 0; i < s.length(); ++i) {
			int num = s.charAt(i) - 'A';
			a[num] = a[num] + 1;
		}
		int b = findone(a);
		if(b>2) {
			return 0;
		}else {
			return b;
		}
	}

	public static int findone(int[] a) {
		int c = 0;
		for (int i = 0; i < 26; i++) {
			if (a[i] > 0) {
				c++;
			}
		}
		return c;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = new String();
		s=sc.nextLine();
		sc.close();
		// 输入字母的检查
		if (!isAllCapNumber(s)) {
			return;
		}
		if (s.length() < 0 || s.length() > 50) {
			return;
		}
		// 字母的判断
		zhuankuaipaise(s);

	}

}
