/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.15
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1932
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int lines = input.nextInt();
		int[][] array = new int[lines][lines];
		int[][] table = new int[lines][lines];

		for (int i = 0; i < lines; i++)
			for (int j = 0; j < (i + 1); j++)
				array[i][j] = input.nextInt();

		table[0][0] = array[0][0];
		for (int i = 1; i < lines; i++) {
			for (int j = 0; j < (i + 1); j++) {
				if (j - 1 >= 0)
					table[i][j] = Math.max(table[i - 1][j], table[i - 1][j - 1]) + array[i][j];
				else
					table[i][j] = table[i - 1][j] + array[i][j];
			}
		}

		int max = table[lines - 1][0];
		for (int j = 0; j < lines; j++)
			max = Math.max(max, table[lines - 1][j]);

		System.out.println(max);
	}
}