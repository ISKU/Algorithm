/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.08
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2751
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int arraySize = Integer.parseInt(input.readLine());
		int[] arrayNumber = new int[arraySize];

		for (int index = 0; index < arraySize; index++)
			arrayNumber[index] = Integer.parseInt(input.readLine());

		Arrays.sort(arrayNumber);

		for (int index = 0; index < arraySize; index++)
			output.append(arrayNumber[index] + "\n");
		System.out.println(output);
	}
}