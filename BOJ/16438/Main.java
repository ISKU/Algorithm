/*
 * Author: Minho Kim (ISKU)
 * Date: November 16, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16438
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		char[][] table = new char[7][N];
		for (int x = 0, i = 1; x < N; x++, i++)
			for (int y = 0, d = 1; y < 7; y++, d <<= 1)
				table[y][x] = ((i & d) == d) ? 'A' : 'B';

		for (int y = 0; y < 7; y++) {
			boolean check = true;
			for (int x = 0; x < N; x++)
				if (table[y][0] != table[y][x])
					check = false;
			if (check)
				table[y][0] = 'A';

			for (int x = 0; x < N; x++)
				System.out.print(table[y][x]);
			System.out.println();
		}
	}
}