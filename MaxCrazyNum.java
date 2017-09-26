package com.test.one;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 这是一个求一个组数据相邻之差绝对值的最大值：即疯狂值
 * 
 * @author lgqin
 *
 */
public class MaxCrazyNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 判断输入的整数是否满足在1至50之间
		if (n < 1 || 50 < n) {
			return;
		}
		int count = 0;// 用于记录输入数据的个数
		int[] h = new int[n];
		while (count < n && sc.hasNextInt()) {
			int num = sc.nextInt();
			// 判断输入的整数是否在范围内
			if (1 > num || 1000 < num) {
				return;
			}
			h[count++] = num;
		}
		sc.close();// 关闭输入流

		findMaxCrazyNum(h, n);

	}

	public static void findMaxCrazyNum(int[] h, int n) {

		// 找出距离均值最近的两个数
		int[] minDis = new int[2];
		int[] after = new int[n];// 用于存放排序好的数
		findMinDis(h, minDis, 0, n - 1);

		minDis = null;
		int i = 0;
		int j = n - 1;
		int ki = 0;
		int kj = n - 1;
		boolean flag = true;

		while (ki <= kj & j >= 0) {
			if (flag) {
				after[ki++] = h[j];
				j--;
				if (j >= 0) {
					after[kj--] = h[j];
					j--;
				}
				flag=false;
			}else {
				j--;
				after[ki++] = h[j];
				if (j >= 0) {
					after[kj--] = h[j+1];
					j--;
				}
				flag=true;
			}
		}
		for (i = 1; i < n - 1; i++) {
			if (after[i] == after[i - 1]) {
				swap(after, i, i + 1);
				++i;
			}
		}

		h = null;
		int sum = 0;
		for (int k = 0; k < n - 1; k++) {
			sum += Math.abs(after[k] - after[k + 1]);
		}

		System.out.println("排序后的数列为：");
		System.out.println(Arrays.toString(after));

		System.out.println(sum);

	}

	public static void findMinDis(int[] h, int[] minDis, int left, int right) {

		if (right > 0) {
			int[] temp = new int[right - left + 1];

			int sum = 0;
			for (int i = left; i <= right; i++) {
				sum += h[i];
			}
			sum = sum / (right - left + 1);// 求平均值
			System.out.println("平均值为：" + sum);
			for (int i = left; i <= right; i++) {
				temp[i] = Math.abs(h[i] - sum);
			}
			System.out.println("原来值的差");
			System.out.println(Arrays.toString(temp));
			heap(temp, minDis, sum);
			// System.out.println("经过排序后temp");
			// System.out.println(Arrays.toString(temp));
			System.out.println("最小值差为：");
			System.out.println(Arrays.toString(minDis));
			// 找出差值为minDis中存放差值对应的两数
			int a = minNum(temp, minDis[0], h, right);
			minDis[0] = h[a];
			right--;
			System.out.println("第一次right的值" + right + "\t a的值" + a);
			if (right >= 0) {
				int b = minNum(temp, minDis[1], h, right, a);
				minDis[1] = h[b];

				if (a != right + 1 && a != right && b != right + 1 && b != right) {
					swap(h, a, right + 1);
					swap(h, b, right);
				} else {
					int min = Math.min(a, b);
					int max = Math.max(a, b);

					// 两个均与right和right+1相等
					if (min == right && max == right + 1) {
						// 此时不用交换
					} else {// 只有一个与right+1或right相等
						if (max == right + 1) {
							swap(h, min, right);
						}
						if (max == right) {
							swap(h, right, right + 1);
							swap(h, min, right);
						}
					}
				}

				right--;
				System.out.println("第二次right的值" + right + "\t b的值" + b);
			} else {
				swap(h, a, right + 1);
				System.out.println("只有一个数" + right);
			}
			System.out.println("经过交换后h的值：");
			System.out.println(Arrays.toString(h));

			System.out.println("最小值为：");
			System.out.println(Arrays.toString(minDis));
			findMinDis(h, minDis, left, right);
		} else {
			return;
		}
	}

	public static int minNum(int[] t, int num, int[] h, int right, int pp) {
		int a = 0;
		for (int i = 0; i < t.length; i++) {
			if (t[i] == num && i != pp) {
				a = i;
				break;
			}
		}
		return a;
	}

	public static int minNum(int[] t, int num, int[] h, int right) {
		int a = 0;
		for (int i = 0; i < t.length; i++) {
			if (t[i] == num) {
				a = i;
				break;
			}
		}
		return a;
	}

	// 使用堆排序找出差值最小的两个数
	public static void heap(int[] temp, int[] minDis, int sum) {
		int[] a = new int[temp.length];
		int i = 0;
		for (int b : temp) {
			a[i++] = b;
		}
		createHeap(a, 0, a.length - 1);
		minDis[0] = a[0];
		swap(a, 0, a.length - 1);
		createHeap(a, 0, a.length - 2);
		minDis[1] = a[0];
		System.out.println("排序后temp");
		System.out.println(Arrays.toString(a));
		a = null;
	}

	// 使用堆排序，小根堆找出最小值
	public static void createHeap(int[] temp, int left, int right) {
		int len = right - left + 1;
		int i = len / 2 - 1;
		// System.out.println("中间值为："+i);
		while (i >= left) {
			if (2 * i + 2 <= len - 1) {// 拥有左右子树
				if (temp[2 * i + 1] >= temp[2 * i + 2]) {
					if (temp[i] > temp[2 * i + 2])
						swap(temp, i, 2 * i + 2);
				} else {
					if (temp[i] > temp[2 * i + 1])
						swap(temp, i, 2 * i + 1);
				}
			} else {
				// int t=2*i+1;
				// System.out.println("left="+left);
				// System.out.println("right="+right);
				// System.out.println("2*i+1="+t);
				// System.out.println(len-1);

				if (2 * i + 1 == len - 1) {// 只有左子树
					if (temp[i] > temp[2 * i + 1])
						swap(temp, i, 2 * i + 1);
				} else {// 叶子节点
				}
			}
			--i;
		}
	}

	public static void swap(int[] h, int i, int j) {
		int temp = h[i];
		h[i] = h[j];
		h[j] = temp;
	}
}
