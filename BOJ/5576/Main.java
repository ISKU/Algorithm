/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.10
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5576
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int[] universityW = new int[10];
		int[] universityK = new int[10];

		for (int index = 0; index < 10; index++)
			universityW[index] = input.nextInt();
		for (int index = 0; index < 10; index++)
			universityK[index] = input.nextInt();

		Arrays.sort(universityW);
		Arrays.sort(universityK);

		System.out.print((universityW[7] + universityW[8] + universityW[9]) + " ");
		System.out.println(universityK[7] + universityK[8] + universityK[9]);
	}
}