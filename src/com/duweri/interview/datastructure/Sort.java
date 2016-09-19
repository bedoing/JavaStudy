package com.duweri.interview.datastructure;

import javax.management.Descriptor;

public class Sort {

	public static void main(String[] args) {
		int[] testArr = {12,27,19,39,16,49,61,40,20,94,63,13,27,31,38,43,11,44,81,29,33,88,60,80,51,4,0,1,22,9,8};
		Sort.insertSort(testArr);
//		Sort.bubbleSort(testArr);
//		Sort.quickSort(testArr, 0, testArr.length-1);
//		Sort.selectSort(testArr);
		Sort.display(testArr);
	}
	
 public static void display(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+",");
		}
	}
	
	/**
	 * ��������
	 * �ؼ���1����ʱ������������������
	 * 		2���߱Ƚϱߺ���
	 * ������������л��������ʱ��
	 */
	public static void insertSort(int[] arr){
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];//��ʱ�������������
			int j;//�����ȱ�֤J����0��ȥ����arr[j]!!!!
			for (j = i-1;j >= 0 && temp > arr[j]; j--) {//���������д��ڵ�ǰ���о�ǰ��--���Ӵ�С����
				arr[j+1] = arr[j];
			}
			arr[j+1]=temp;
		}
	}
	/**
	 * ϣ������
	 */
	public static void shellSort(int[] arr){
		
		for (int i = arr.length/2; i >= 1; i=i/2) {//�����еĻ���
			
		}
		
	}
	/**
	 * ð������
	 * �ؼ���1����ѭ����ʶ��������������
	 * 		2����ѭ��ÿ�ν�һ���������ģ���������ŵ���ǰ��
	 */
	public static void bubbleSort(int[] arr){
		for (int i = 0; i <arr.length-1; i++) {//�Ӻ���ǰ��С��
			for (int j = arr.length-1; j>i; j--) {//�����һ����ʼ����
				if (arr[j]>arr[j-1]) {
					int temp = arr[j];//swap
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
	}
	
	/**
	 * ��������
	 * �ؼ�: 1��ѡ��ֵ
	 * 		2��һ�λ���
	 * 		3���ݹ����
	 */
	public static void quickSort(int[] arr,int start,int end){
		if(start<end){
			int middle = partition(arr, start, end);
			quickSort(arr, start, middle-1);
			quickSort(arr, middle+1, end);
		}
	}
	/**
	 * ��arr[0]Ϊ��׼����һ�λ����㷨����߶�С��arr[0]���ұ߶�����arr[0]
	 */
	private static int partition(int[] arr,int first,int end){
		while(first < end){
			//��ɨ���Ҷ�
			while(first < end && arr[first]<arr[end]){
				end--;
			}
			if(first < end){
				int temp = arr[end];
				arr[end] = arr[first];
				arr[first] = temp;
				first++;
			}
			//ɨ�����
			while(first < end && arr[first]<arr[end]){
				first++;
			}
			if(first<end){
				int temp = arr[end];
				arr[end] = arr[first];
				arr[first] = temp;
				end--; 
			}
		}
		return first;
	}
	
	private static int partition2(int[] arr,int left,int right){
		int pivotKey = arr[left];
		int pivotePointer = left;
		
		while(left < right){
			while(left<right&&arr[right]>=pivotKey){
				right--;
			}
			while(left<right && arr[left]<=pivotKey){
				left++;
			}
//			swap(arr,left,right);
		}
//		swap(arr,pivotePointer,left);
		return left;
	}
	
	
	/**
	 * ѡ������			O��n^2��
	 * ÿ�α���������ѡ����С��
	 */
	public static void selectSort(int[] arr){
		int minIndex = 0;
		for (int i = 0; i < arr.length-1; i++) {
			minIndex = i;//ָ����С��ֵ�ĽǱ�
			for (int j = i+1; j < arr.length; j++) {//����������
				if(arr[j] < arr[minIndex]){
					minIndex = j;
				}
			}
			if (minIndex != i) {		//�������������ˣ��ҵ���С�ĽǱ��ˣ�����
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
		}
	}
	
}
















