package com.hugoye.example.sortalgorithm;

/**
 * 选择排序 : 选择排序的思想其实和冒泡排序有点类似，都是在一次排序后把最小的元素放到最前面。但是过程不同，冒泡排序是通过相邻的比较和交换。
 * 而选择排序是通过对整体的选择 。举个例子，对5,3,8,6,4这个无序序列进行简单选择排序，首先要选择5以外的最小数来和5交换，
 * 也就是选择3和5交换，一次排序后就变成了3 ,5,8,6,4.对剩下的序列依次进行选择和交换，最终就会得到一个有序序列。其实选择排序
 * 可以看成冒泡排序的优化，因为其目的相同， 只是选择排序只有在确定了最小数的前提下才进行交换，大大减少了交换的次数。选择排序的时间复杂度为O(n^2)
 */

public class SelectSort {

	public static void selectSort(int[] array) {

		if (array == null || array.length <= 0) {
			return;
		}

		int minIndex = 0;

		// 只需要比较n-1次
		for (int i = 0; i < array.length - 1; i++) {
			minIndex = i;

			// 从i+1开始比较，因为minIndex默认为i了，i就没必要比了。
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}

			if (minIndex != i) {
				swap(array, minIndex, i);
			}
		}

	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 5, 7, 9, 2, 4, 6, 8, 1, 3 };
		for (int i = 0; i < arr.length; i++)
			System.out.printf(arr[i] + "");

		selectSort(arr);

		System.out.printf("\n");
		for (int i = 0; i < arr.length; i++)
			System.out.printf(arr[i] + "");
	}

}
