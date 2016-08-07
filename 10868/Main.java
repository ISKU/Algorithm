/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.08
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10868
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
		StringBuilder output = new StringBuilder(); // output, set of minimum number
		StringTokenizer parser = new StringTokenizer(input.readLine());
		arrayMaxSize = Integer.parseInt(parser.nextToken());
		int numberOfCalls = Integer.parseInt(parser.nextToken());
		mainArray = new Node[arrayMaxSize];

		// input, Node(value, index)
		for (int index = 0; index < arrayMaxSize; index++)
			mainArray[index] = new Node(Integer.parseInt(input.readLine()), index);

		quickSort(mainArray, 0, arrayMaxSize - 1); // quick sort

		// output, minimum number in sorted a[...a...b...]
		for (int count = 0; count < numberOfCalls; count++) {
			parser = new StringTokenizer(input.readLine());
			output.append(
					getArrayValue(
							Integer.parseInt(parser.nextToken()), Integer.parseInt(parser.nextToken()))+ "\n"
			);
		}
		System.out.print(output);
	}

	private static int getArrayValue(int firstIndex, int lastIndex) {
		for (int index = 0; index < arrayMaxSize; index++)
			if ((mainArray[index].index >= firstIndex - 1) && mainArray[index].index <= lastIndex - 1)
				return mainArray[index].value; // find minimum number

		return 0;
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