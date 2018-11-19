/*
 * Author: Minho Kim (ISKU)
 * Date: November 17, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16505
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		boolean[][] array = new boolean[1025][1025];
		array[1][1] = true;
		for (int size = 1; size <= 512; size *= 2) {
			for (int y = 1; y <= size; y++) {
				for (int x = 1; x <= size; x++) {
					array[y][x + size] = array[y][x];
					array[y + size][x] = array[y][x];
				}
			}
		}

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N == 0) {
			System.out.print("*");
			System.exit(0);
		}

		for (int y = 1; y <= (1 << N); y++) {
			int end = 1 << N;
			for (int x = end; x >= 1; x--) {
				if (array[y][x]) {
					end = x;
					break;
				}
			}

			for (int x = 1; x <= end; x++)
				System.out.print(array[y][x] ? "*" : " ");
			System.out.println();
		}
	}
}