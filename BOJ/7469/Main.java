/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.07
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/7469
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static Node[] mainArray;
	private static int arrayMaxSize;

	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		StringBuilder output = new StringBuilder(); // output, k-th number
		arrayMaxSize = Integer.parseInt(parser.nextToken());
		int numberOfCalls = Integer.parseInt(parser.nextToken());
		mainArray = new Node[arrayMaxSize];

		// input, Node(value, index)
		parser = new StringTokenizer(input.readLine());
		for (int index = 0; index < arrayMaxSize; index++)
			mainArray[index] = new Node(Integer.parseInt(parser.nextToken()), index);

		quickSort(mainArray, 0, arrayMaxSize - 1); // quick sort 

		// output, it — the k-th number in sorted a[i...j] segment
		for (int count = 0; count < numberOfCalls; count++) {
			parser = new StringTokenizer(input.readLine());
			output.append(
					getArrayValue(
							Integer.parseInt(parser.nextToken()), 
							Integer.parseInt(parser.nextToken()), 
							Integer.parseInt(parser.nextToken())) + "\n"
			);
		}
		System.out.print(output);
	}

	private static int getArrayValue(int first, int last, int returnIndex) {
		int returnIndexCount = 0;
		int returnValue = 0; // k-th number

		for (int index = 0; index < arrayMaxSize; index++) {
			if ((mainArray[index].index >= first - 1) && (mainArray[index].index <= last - 1)) {
				returnIndexCount++; // find k-th number
				if (returnIndexCount == returnIndex) {
					returnValue = mainArray[index].value;
					break;
				}
			}
		}

		return returnValue;
	}

	// quick sort array
	private static void quickSort(Node[] array, int low, int high) {
		if (array == null || array.length == 0)
			return;
		if (low >= high)
			return;

		int middle = low + (high - low) / 2;
		int pivot = array[middle].value;
		int i = low, j = high;

		while (i <= j) {
			while (array[i].value < pivot)
				i++;
			while (array[j].value > pivot)
				j--;

			if (i <= j) {
				Node temp = array[i];
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

	// save index
	private static class Node {
		public int value;
		public int index;

		public Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
}