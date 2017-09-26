package com.test.one;


import java.util.Scanner;

public class Main {

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

		// 是否只要一种类型的字母
		int b = findone(a);
		if (b==1) {
			number = 1;
			return number;
		}

		int type_odd1 = 0;
		int type_even = 0;
		boolean flag = true;
		for (int i = 0; i < 26; ++i) {
			if (a[i] % 2 == 1) {

				if (a[i] == 1) {
					++type_odd1;
					if (type_odd1 > 1) {
						flag = false;
						break;
					}
				} else {
					a[i]=a[i]-1;
				}
			}
		}

		if (flag) {
			int repet = 0;
			for (int i = 0; i < 26; ++i) {
				if (a[i] % 2 == 0) {

					if (a[i] > 0) {
						if (a[i] / 2 > 1) {
							repet += a[i] / 2;
						}
						a[i] = a[i] / 2;
						type_even += a[i];
					}
				}
			}
			if (repet > 0) {
				number = jiecheng(type_even) / repet;
			} else {
				number = jiecheng(type_even);
			}
		}

		return number;
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

	public static int jiecheng(int n) {
		if (n > 1) {
			return n * jiecheng(n - 1);
		} else {
			if (n == 1) {
				return n;
			} else {
				return 0;
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = new String();
		s = sc.nextLine();
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
