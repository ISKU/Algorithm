/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.10
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11004
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int arraySize = Integer.parseInt(parser.nextToken());
		int[] arrayNumber = new int[arraySize];
		int k_thNumber = Integer.parseInt(parser.nextToken());

		parser = new StringTokenizer(input.readLine());
		for (int index = 0; index < arraySize; index++)
			arrayNumber[index] = Integer.parseInt(parser.nextToken());

		quickSort(arrayNumber, 0, arraySize - 1);
		System.out.print(arrayNumber[k_thNumber - 1]);
	}

	private static void quickSort(int[] array, int low, int high) {
		if (array == null || array.length == 0)
			return;
		if (low >= high)
			return;

		int middle = low + (high - low) / 2;
		int pivot = array[middle];
		int i = low, j = high;

		while (i <= j) {
			while (array[i] < pivot)
				i++;
			while (array[j] > pivot)
				j--;

			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}

		if (low < j)
			quickSort(array, low, j);
		if (high > i)
			quickSort(array, i, high);
	}
}