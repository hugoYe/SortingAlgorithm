package com.hugoye.example.sortalgorithm;

/**
 * 快速排序 : 快速排序一听名字就觉得很高端，在实际应用当中快速排序确实也是表现最好的排序算法。快速排序虽然高端，但其实其思想是来自冒泡排序，
 * 冒泡排序是通过相邻元素的比较和交换把最小的冒泡到最顶端，而快速排序是比较和交换小数和大数，这样一来不仅把小数冒泡到上面同时也把大数沉到下面。
 * 
 * 举个例子：对5,3,8,6,4这个无序序列进行快速排序，思路是右指针找比基准数小的，左指针找比基准数大的，交换之。
 * 
 * 5,3,8,6,4 用5作为比较的基准，最终会把比5小的移动到5的左边，比5大的移动到5的右边。
 * 
 * 5,3,8,6,4 首先设置i,j两个指针分别指向两端，j指针先扫描（思考一下为什么？）4比5小停止。然后i扫描，8比5大停止。交换i,j位置。
 * 
 * 5,3,4,6,8 然后j指针再扫描，这时j扫描4时两指针相遇。停止。然后交换4和基准数。
 * 
 * 4,3,5,6,8 一次划分后达到了左边比5小，右边比5大的目的。之后对左右子序列递归排序，最终得到有序序列。
 * 
 * 上面留下来了一个问题为什么一定要j指针先动呢？首先这也不是绝对的，这取决于基准数的位置，因为在最后两个指针相遇的时候，要交换基准数到相遇的位置。
 * 一般选取第一个数作为基准数，那么就是在左边，所以最后相遇的数要和基准数交换，那么相遇的数一定要比基准数小。所以j指针先移动才能先找到比基准数小的数。
 * 
 * 快速排序是不稳定的，其时间平均时间复杂度是O(nlgn)。
 */

public class QuickSort {

	public static void quickSort(int[] array) {

		if (array == null || array.length <= 0) {
			return;
		}
		quickSort(array, 0, array.length - 1);
	}

	public static void quickSort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivotPos = partition(array, left, right);
		quickSort(array, left, pivotPos - 1);
		quickSort(array, pivotPos + 1, right);
	}

	public static int partition(int[] array, int left, int right) {
		int pivotKey = array[left];
		int pivotPointer = left;

		while (left < right) {
			while (left < right && array[right] >= pivotKey) {
				right--;
			}
			while (left < right && array[left] <= pivotKey) {
				left++;
			}
			swap(array, left, right); // 把大的交换到右边，把小的交换到左边。
		}

		swap(array, pivotPointer, left); // 最后把pivot交换到中间

		return left;
	}

	public static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 5, 7, 9, 2, 4, 6, 8, 1, 3 };
		for (int i = 0; i < arr.length; i++)
			System.out.printf(arr[i] + "");

		quickSort(arr);

		System.out.printf("\n");
		for (int i = 0; i < arr.length; i++)
			System.out.printf(arr[i] + "");
	}

}
