package com.test.one;

import java.util.Arrays;
/**
 * 这是一个求组合数的代码
 * @author lgqin
 *
 */
import java.util.Scanner;

public class Zhuheshu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			// if(m>n) {
			// System.out.println("输入数据不合法！要求n必须大于等于m");
			// return;
			// }
	//		long pai = pailie(n, m);
	//		long zhu = zhuhe(n, m);
			String s=sc.nextLine();
			int pai=(int )fac(n);
			String[] dataList=new String[pai];
			for(int i=0;i<pai;++i) {
				dataList[i]=s;
			}
			arrangementSelect(dataList, n) ;//列出所有全排列
		
		}

	}

	// 求n个数中取m的数的全排列个数（有序）
	public static long pailie(int n, int m) {
		long f1 = fac(n, m);
		long f2 = fullarrange(n, m);
		System.out.println("全排列个数：" + f1);
//		System.out.println("全排列个数：" + f2);
		return f1;
	}

	/**
	 * 计算组合数，即C(n, m) = n!/((n-m)! * m!) 
	 * @param n
	 * @param m
	 */
	// 求n个数中取m个数（无序）,n! / m! /(n-m)！
	public static long zhuhe(int n, int m) {
		long z = n >= m ? fac(n) / fac(m) / fac(n - m) : 0;
		System.out.println("组合数：" + z);
		return z;
		
	}
/**
 * 计算阶乘数，即n! = n * (n-1) * ... * 2 * 1 
 * @param n
 * @return
 */
	public static long fac(int n) {
		return n > 1 ? n * fac(n - 1) : 1;
	}

	// 求全排列，方法一：n*(n-1)*,...,*(n-m+1),
	public static long fac(int n, int m) {
		return m > 0 ? n * fac(n - 1, m - 1) : 1;
	}

	// 求全排列，方法二:n! / (n-m)!,计算排列数，即A(n, m) = n!/(n-m)! 
	public static long fullarrange(int n, int m) {
		return n >= m ? fac(n) / fac(n - m) : 0;
	}
	
	
    /** 
     * 排列选择（从列表中选择n个排列） 
     * @param dataList 待选列表 
     * @param n 选择个数 
     */  
    public static void arrangementSelect(String[] dataList, int n) {  
        System.out.println(String.format("A(%d, %d) = %d", dataList.length, n, fac(n)));  
        arrangementSelect(dataList, new String[n], 0);  
    }  
      
    /** 
     * 排列选择 
     * @param dataList 待选列表 
     * @param resultList 前面（resultIndex-1）个的排列结果 
     * @param resultIndex 选择索引，从0开始 
     */  
    private static void arrangementSelect(String[] dataList, String[] resultList, int resultIndex) {  
        int resultLen = resultList.length;  
        if (resultIndex >= resultLen) { // 全部选择完时，输出排列结果  
            System.out.println(Arrays.asList(resultList));  
            return;  
        }  
      
        // 递归选择下一个  
        for (int i = 0; i < dataList.length; i++) {  
            // 判断待选项是否存在于排列结果中  
            boolean exists = false;  
            for (int j = 0; j < resultIndex; j++) {  
                if (dataList[i].equals(resultList[j])) {  
                    exists = true;  
                    break;  
                }  
            }  
            if (!exists) { // 排列结果不存在该项，才可选择  
                resultList[resultIndex] = dataList[i];  
                arrangementSelect(dataList, resultList, resultIndex + 1);  
            }  
        }  
    }  
	
	
	
	
	
	
}
