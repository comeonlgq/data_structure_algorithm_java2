package com.test.one;

import java.util.Arrays;

/**
 * 这是一个讲解排序算法的例子
 * 
 * @author lgqin
 *
 */
public class PaiXu {

	public static void main(String[] args) {
		int[] arr = { 9, 11, 7, 16, 8, 4, 13, 2, 21 };
		int[] arr1 = { 9, 11, 7, 16, 8, 4, 13, 2, 21 };
		int[] arr2 = { 9, 11, 7, 16, 8, 4, 13, 2, 21 };
		int[] arr3 = { 9, 11, 7, 16, 8, 4, 13, 2, 21 };
		int[] arr4 = { 9, 11, 7, 16, 8, 4, 13, 2, 21 };
		int[] arr5 = { 9, 11, 7, 16, 8, 4, 13, 2, 21 };
		int[] arr6 = { 9, 11, 7, 16, 8, 4, 13, 2, 21 };

		// System.out.println("====选择排序结果====");
		// select(arr, 9);
		// System.out.println(Arrays.toString(arr));
		//
		// System.out.println("====冒泡排序结果====");
		// bubble(arr1, 9);
		// System.out.println(Arrays.toString(arr1));
		//
		// System.out.println("====插入排序结果====");
		// select(arr2, 9);
		// System.out.println(Arrays.toString(arr2));
		//
		// System.out.println("====快速排序结果1====");
		// quicksort1(arr3, 0,8);
		// System.out.println("====快速排序结果2====");
		// quicksort2(arr4,0,8);
		// System.out.println("====快速排序结果3====");
		// quicksort3(arr5,0,8);
		// System.out.println("====快速排序结果4====");
		// quicksort4(arr6,0,8);
		// System.out.println(Arrays.toString(arr3));

		// System.out.println("====合并排序1结果====");
		// merge_sort(arr4);
		// System.out.println(Arrays.toString(arr4));
		//
		// System.out.println("====合并排序2结果====");//合并排序2的方法优越于合并排序1
		// merge_sort2(arr5);
		// System.out.println(Arrays.toString(arr5));
		//
		System.out.println("====堆排序结果====");
		heapsort1(arr6, 0, 8);
		System.out.println(Arrays.toString(arr6));
	}

	// 选择排序
	public static void select(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			if (i != min)
				swap(a, i, min);
		}
	}

	// 交换两个元素
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// 冒泡排序
	public static void bubble(int[] a, int n) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
				}
			}
		}
	}

	// 插入排序
	public static void insert(int[] a, int n) {
		for (int i = 0; i < n - 1; i++) {
			int len = i;
			int j = len + 1;
			while (len >= 0) {
				if (a[j] < a[len])
					len--;
				else {
					swap(a, len, j);
				}
			}
			len = j;
		}
	}

	// 合并排序主程序，方法一：
	public static void merge_sort(int[] arr) {
		int[] temp = new int[arr.length];// 在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
		mergeSort(arr, 0, arr.length - 1, temp);
	}

	// 方法一部分
	public static void merge(int[] a, int left, int mid, int right, int temp[]) {

		int i = left, j = mid + 1, k = left;
		while (i <= mid && j <= right) {
			if (a[i] > a[j]) {
				temp[k] = a[j];
				++k;
				++j;
			} else {
				temp[k] = a[i];
				++k;
				++i;
			}
		}
		while (i <= mid) {
			temp[k++] = a[i++];
		}
		while (j <= right) {
			temp[k++] = a[j++];
		}

		int t = left;
		// 将temp中的元素全部拷贝到原数组中
		while (left <= right) {
			a[left++] = temp[t++];
		}

	}

	public static void mergeSort(int[] a, int left, int right, int[] temp) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(a, left, mid, temp);
			mergeSort(a, mid + 1, right, temp);
			merge(a, left, mid, right, temp);
			System.out.println(Arrays.toString(a));
		}
	}

	// 合并排序主程序，方法二：
	public static void merge_sort2(int[] arr) {
		int[] temp = new int[arr.length];

		for (int gap = 2; gap <= arr.length / 2; gap *= 2) {
			for (int i = 0; i < arr.length - gap; i += gap) {
				merge(arr, i, i + gap / 2 - 1, i + gap - 1, temp);
				System.out.println(Arrays.toString(arr));
			}
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
	
	
	// 堆排序(大根堆)(建堆)
	public static void heap1(int[] a,int left,int right) {
		for (int i = (right-left+1) / 2 - 1; i >= 0; i--) {
			if (2 * i + 2 <= right) {// 拥有左右子树
				if (a[2 * i + 1] < a[2 * i + 2]) {
					if (a[i] < a[2 * i + 2])
						swap(a, i, 2 * i + 2);
				} else {
					if (a[i] < a[2 * i + 1])
						swap(a, i, 2 * i + 1);
				}
			} else {
				if (2 * i + 1 == right) {// 只有左子树
					if (a[i] < a[2 * i + 1])
						swap(a, i, 2 * i + 1);
				}
			}

		}
	}
	//堆排序，正序
	public static void heapsort1(int[] a, int left, int right) {
		if (right > left) {
			heap1(a,left,right);
			swap(a, left, right);
			heapsort1(a, left, right - 1);
		}
	}

	
	//堆排序，倒序
	public static void heapsort(int[] a, int left, int right) {
		if (right > left) {
			heap(a,left,right);
			swap(a, left, right);
			heapsort(a, left, right - 1);
		}
	}

	// 快速排序(两边)
	public static void quicksort1(int[] a, int left, int right) {
		int i = left, j = right;
		int pivot = a[left];
		while (i < j) {
			while (a[j] >= pivot && j > i)
				--j;
			swap(a, i, j);
			while (a[i] <= pivot && i < j)
				i++;
			swap(a, i, j);
		}
		System.out.println(Arrays.toString(a));
		if (i - 1 > left) {
			quicksort1(a, left, i - 1);
		}
		if (j + 1 < right) {
			quicksort1(a, j + 1, right);
		}

	}

	// 快速排序(两边),减少交换次数
	public static void quicksort4(int[] a, int left, int right) {
		int i = left, j = right;
		int pivot = a[left];
		while (i < j) {
			while (a[j] >= pivot && j > i)
				--j;
			if (j > i) {
				a[i] = a[j];
				i++;
			}
			while (a[i] <= pivot && i < j)
				i++;
			if (i < j) {
				a[j] = a[i];
				j--;
			}
		}
		a[i] = pivot;
		System.out.println(Arrays.toString(a));
		if (i - 1 > left) {
			quicksort1(a, left, i - 1);
		}
		if (j + 1 < right) {
			quicksort1(a, j + 1, right);
		}

	}

	// 快速排序（中值）
	public static void quicksort2(int[] a, int left, int right) {
		int mid = a[(right - left + 1) / 2];
		int m = Math.max(mid, Math.max(a[left], a[right]));
		if (m == mid)
			swap(a, (right - left + 1) / 2, right);
		if (m == a[left])
			swap(a, left, right);
		int pivot = a[right];
		int i = left, j = right;
		while (i < j) {
			while (a[i] <= pivot && i < j)
				++i;
			swap(a, i, j);
			while (a[j] >= pivot && j > i)
				--j;
			swap(a, i, j);
		}
		System.out.println(Arrays.toString(a));
		if (i - 1 > left)
			quicksort2(a, left, i - 1);
		if (j + 1 < right)
			quicksort2(a, j + 1, right);

	}

	// 快速排序（洗牌）
	public static void quicksort3(int[] a, int left, int right) {
		for (int i = left; i <= right; i++) {
			int r = (int) Math.random() * (i - 1);
			swap(a, r, i);
		}
		int pivot = a[right];
		int i = left, j = right;
		while (i < j) {
			while (a[i] <= pivot && i < j)
				++i;
			swap(a, i, j);
			while (a[j] >= pivot && j > i)
				--j;
			swap(a, i, j);
		}
		System.out.println(Arrays.toString(a));
		if (i - 1 > left)
			quicksort3(a, left, i - 1);
		if (j + 1 < right)
			quicksort3(a, j + 1, right);

	}

}
