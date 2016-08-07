/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.07
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11931
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int arrayMaxSize = Integer.parseInt(input.readLine());
		int[] arrayNumber = new int[arrayMaxSize];

		for (int index = 0; index < arrayMaxSize; index++)
			arrayNumber[index] = Integer.parseInt(input.readLine());
		Arrays.sort(arrayNumber);

		StringBuilder output = new StringBuilder();
		while (--arrayMaxSize >= 0)
			output.append(arrayNumber[arrayMaxSize] + "\n");
		System.out.print(output);
	}
}