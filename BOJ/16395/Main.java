/*
 * Author: Minho Kim (ISKU)
 * Date: November 11, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16395
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] tri = new int[31][31];
		tri[1][1] = 1;
		for (int i = 2; i <= 30; i++)
			for (int j = 1; j <= 30; j++)
				tri[i][j] = tri[i - 1][j - 1] + tri[i - 1][j];

		System.out.print(tri[sc.nextInt()][sc.nextInt()]);
	}
}