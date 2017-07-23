/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.24
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14647
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[][] bingo = new int[input.nextInt()][input.nextInt()];

		int total = 0;
		for (int y = 0; y < bingo.length; y++) {
			for (int x = 0; x < bingo[y].length; x++) {
				char[] number = input.next().toCharArray();
				for (int i = 0; i < number.length; i++)
					if (number[i] == '9') {
						bingo[y][x]++;
						total++;
					}
			}
		}

		int maxY = 0, maxX = 0;
		for (int y = 0; y < bingo.length; y++) {
			int max = 0;
			for (int x = 0; x < bingo[y].length; x++)
				max += bingo[y][x];
			maxX = Math.max(maxX, max);
		}

		for (int x = 0; x < bingo[0].length; x++) {
			int max = 0;
			for (int y = 0; y < bingo.length; y++)
				max += bingo[y][x];
			maxY = Math.max(maxY, max);
		}

		System.out.print(total - Math.max(maxY, maxX));
	}
}