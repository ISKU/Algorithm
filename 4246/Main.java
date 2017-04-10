/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.11
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4246
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			int column = input.nextInt();
			if (column == 0)
				break;

			char[] sets = input.next().toCharArray();
			char[][] answer = new char[sets.length / column][column];
			int point = 0;

			for (int i = 0; i < answer.length; i++) {
				int j = (i % 2 == 0) ? 0 : column - 1;
				while (true) {
					if (i % 2 == 0 && j >= column)
						break;
					if (i % 2 != 0 && j < 0)
						break;

					answer[i][j] = sets[point++];
					j = (i % 2 == 0) ? j + 1 : j - 1;
				}
			}

			for (int i = 0; i < column; i++)
				for (int j = 0; j < answer.length; j++)
					System.out.print(answer[j][i]);
			System.out.println();
		}
	}
}