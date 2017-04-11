/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.12
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14456
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		int[][] table = new int[4][4];
		for (int i = 0; i < N; i++)
			table[input.nextInt()][input.nextInt()]++;

		int max = table[1][2] + table[2][3] + table[3][1];
		if (table[1][3] + table[3][2] + table[2][1] > max)
			max = table[1][3] + table[3][2] + table[2][1];

		System.out.print(max);
	}
}