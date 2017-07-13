/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.10.20
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10090
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	private static long numberOfInversions = 0;

	public static void main(String... args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int data[] = new int[Integer.parseInt(parser.nextToken())];

		parser = new StringTokenizer(input.readLine());
		for (int index = 0; index < data.length; index++)
			data[index] = Integer.parseInt(parser.nextToken());

		sortAndCount(data, new int[data.length], 0, data.length - 1);
		System.out.println(numberOfInversions);
	}

	private static void sortAndCount(int[] array, int[] tempArray, int leftSide, int rightSide) {
		if (leftSide < rightSide) {
			int indexOfMid = (leftSide + rightSide) / 2;
			sortAndCount(array, tempArray, leftSide, indexOfMid);
			sortAndCount(array, tempArray, indexOfMid + 1, rightSide);
			merge(array, tempArray, leftSide, indexOfMid + 1, rightSide);
		}
	}

	private static void merge(int[] array, int[] tempArray, int indexOfLeft, int indexOfRight, int indexOfMaxRight) {
		int indexOfMaxLeft = indexOfRight - 1;
		int currentArraySize = indexOfMaxRight - indexOfLeft + 1;
		int tempArrayIndex = indexOfLeft;
		int indexOfInversion = indexOfRight;

		while (indexOfLeft <= indexOfMaxLeft && indexOfRight <= indexOfMaxRight) {
			if (array[indexOfLeft] <= array[indexOfRight])
				tempArray[tempArrayIndex++] = array[indexOfLeft++];
			else {
				numberOfInversions += indexOfInversion - indexOfLeft;
				tempArray[tempArrayIndex++] = array[indexOfRight++];
			}
		}

		while (indexOfLeft <= indexOfMaxLeft)
			tempArray[tempArrayIndex++] = array[indexOfLeft++];
		while (indexOfRight <= indexOfMaxRight)
			tempArray[tempArrayIndex++] = array[indexOfRight++];

		for (int count = 0; count < currentArraySize; count++)
			array[indexOfMaxRight] = tempArray[indexOfMaxRight--];
	}
}