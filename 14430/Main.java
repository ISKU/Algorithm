/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.10
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14430
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[][] area = new int[input.nextInt() + 1][input.nextInt() + 1];
		int[][] table = new int[area.length][area[0].length];

		for (int i = 1; i < area.length; i++)
			for (int j = 1; j < area[i].length; j++)
				area[i][j] = input.nextInt();

		for (int i = 1; i < area.length; i++)
			for (int j = 1; j < area[i].length; j++)
				table[i][j] = area[i][j] + Math.max(table[i][j - 1], table[i - 1][j]);

		System.out.println(table[area.length - 1][area[0].length - 1]);
	}
}