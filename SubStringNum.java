package com.test.one;

/**
 * 这是一个求子串个数的代码
 * 
 * @author Administrator
 *
 */
public class SubStringNum {

	public static void main(String[] args) {
		String string = "javajava_eclipse_class_jajavavajavajdjdj";
		String str = "java";
		method_1(string, str); // 方法一
	}

	public static void method_1(String string, String a) {
		int i = string.length() - string.replace(a, "").length();//方法的思路是，从母串中去掉包含子串的内容，计算减少了多少个字符，用减少的字符数除以子串长度就为母串中包含有子串的个数
		System.out.println("方法一 ---> 个数" +string.length() +"  "+ i +"  "+a.length());
		System.out.println("方法一 ---> 个数" + i / a.length());
	}
}
