/*
 * Author: Minho Kim (ISKU)
 * Date: August 8, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2495
 */

import java.util.*;

public class Main {

	private static char[] number;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			number = sc.next().toCharArray();

			int count = 0;
			for (int i = 0; i < 8; i++)
				count = Math.max(count, dfs(i, number[i], 0));

			System.out.println(count);
		}
	}

	private static int dfs(int i, char c, int count) {
		if (i >= 8 || number[i] != c)
			return count;
		return dfs(i + 1, c, count + 1);
	}
}