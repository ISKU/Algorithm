/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.11
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10870
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		long[] fibonacciSequence = new long[21];
		fibonacciSequence[0] = 0;
		fibonacciSequence[1] = 1;
		fibonacciSequence[2] = 1;

		for (int index = 3; index < fibonacciSequence.length; index++)
			fibonacciSequence[index] = fibonacciSequence[index - 1] + fibonacciSequence[index - 2];

		System.out.println(fibonacciSequence[new Scanner(System.in).nextInt()]);
	}
}