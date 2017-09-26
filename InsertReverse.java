package com.test.one;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * 这是一个先进行插入，然后进行逆置的代码
 */
public class InsertReverse {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int len = sc.nextInt();
		if(len<2|len>2*Math.pow(10, 5))
			return;
		int count=0;
		ArrayList<Integer> al=new ArrayList<Integer>();;
//		ArrayList<Integer> t1=new ArrayList<Integer>();//存放前一次的逆置之前的结果
//		ArrayList<Integer> t2=new ArrayList<Integer>();//存放前一次的逆置之后的结果
		while(count<=len && sc.hasNextInt()) {
			int num = sc.nextInt();
			if(num<1|| num>Math.pow(10, 9))
				return;
			count++;
			al.add(num);
			reverse(al,0,al.size()-1);
			System.out.println("+++++++++++++++++++++++++++++");
			System.out.println("第"+count+"次");
			for(int a:al) {
				System.out.println(a);
			}
			
//			if(count==0) {
//				al=new ArrayList<Integer>();
//				al.add(num);
//				count++;
//				System.out.println("+++++++++++++++++++++++++++++");
//				System.out.println("第"+count+"次");
//				t1=al;
//				System.out.println("t1");
//				for(int a:t1) {
//					System.out.println(a);
//				}
//				t2=al;
//				System.out.println("t2");
//				for(int a:t2) {
//					System.out.println(a);
//				}
//				System.out.println("al");
//				for(int a:al) {
//					System.out.println(a);
//				}
//				System.out.println("+++++++++++++++++++++++++++++");
//				al=null;
//			}else {
//				t2.add(num);
//				ArrayList<Integer> temp=new ArrayList<Integer>();
//				temp=t2;
//				ArrayList<Integer> al1 =new ArrayList<Integer>();
//				System.out.println("t1");
//				for(int a:t1) {
//					System.out.println(a);
//				}
//				
//				al1=reverse(t1,num);
//				System.out.println("t1");
//				for(int a:t1) {
//					System.out.println(a);
//				}
//				
//				count++;
//				System.out.println("+++++++++++++++++++++++++++++");
//				System.out.println("第"+count+"次");
//				t2=al1;
//				t1=temp;
//				System.out.println("t1");
//				for(int a:t1) {
//					System.out.println(a);
//				}
//				System.out.println("t2");
//				for(int a:t2) {
//					System.out.println(a);
//				}
//				temp=null;
//				
//				System.out.println("al");
//				for(int a:al1) {
//					System.out.println(a);
//				}
//				System.out.println("+++++++++++++++++++++++++++++");
//				al1=null;
//			}
				
			
		}
		sc.close();
	}
	
	public static void reverse(ArrayList<Integer> al,int left,int right) {
		int len=right-left+1;
		if(len%2==1) {//奇数个
			int mid = (len-1)/2;
			reverse(al,left,mid-1);
			reverse(al,mid+1,right);
			substitution(al,left,mid,right);
		}else {//偶数个
			int mid=len/2;
			reverse(al,left,mid-1);
			reverse(al,mid,right);
			substitution(al,left,mid,right);
		}
	}
	
	
	public static void substitution(ArrayList<Integer> al,int left,int mid,int right) {
		int i=left,j=right;
		while(i<j) {
			swap(al,i,j);
			i++;j--;
		}
	}
	
	public static void swap(ArrayList<Integer> al,int i,int j) {
		int temp=al.get(i);
		al.add(i,al.get(j));
		al.add(j,temp);
	}
	
//	public static ArrayList<Integer> reverse(ArrayList<Integer> t1,int num) {
//		ArrayList<Integer> al=new ArrayList<Integer>();
//		al.add(num);
//		for(int i=0;i<t1.size();i++)
//		{
//			al.add(t1.get(i));
//		}
//		return al;
//	}

}
