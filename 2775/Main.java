/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.22
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2775
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[][] array = new int[15][15];

		for (int i = 1; i < array[0].length; i++)
			array[0][i] = i;

		for (int i = 1; i < array.length; i++) {
			int sum = array[i - 1][0];

			for (int j = 1; j < array.length; j++) {
				sum += array[i - 1][j];
				array[i][j] = sum;
			}
		}

		int testCase = input.nextInt();
		while (testCase-- > 0)
			System.out.println(array[input.nextInt()][input.nextInt()]);
	}
}