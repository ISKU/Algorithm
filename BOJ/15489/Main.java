/*
 * Author: Minho Kim (ISKU)
 * Date: February 13, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15489
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int W = sc.nextInt();

		int[][] pascal = new int[R + W][R + W];
		pascal[1][1] = 1;

		for (int i = 2; i < pascal.length; i++)
			for (int j = 1; j <= i; j++)
				pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];

		int sum = 0;
		for (int i = R, k = 1; i < R + W; i++, k++)
			for (int j = C, z = 1; z <= k; j++, z++)
				sum += pascal[i][j];

		System.out.print(sum);
	}
}