/* 
 * Author: Minho Kim (ISKU)
 * Date: January 9, 2018
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1706
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int Y = input.nextInt();
		int X = input.nextInt();
		Cell[][] map = new Cell[Y][X];

		for (int y = 0; y < Y; y++) {
			String[] line = input.next().split("");
			for (int x = 0; x < line.length; x++)
				map[y][x] = new Cell(line[x]);
		}

		TreeSet<String> set = new TreeSet<String>();
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				if (!map[y][x].horizontal && !"#".equals(map[y][x].letter) && x + 1 < X && !"#".equals(map[y][x + 1].letter)) {
					String word = "";
					for (int i = x; i < X && !"#".equals(map[y][i].letter); i++) {
						word += map[y][i].letter;
						map[y][i].horizontal = true;
					}
					set.add(word);
				}
				if (!map[y][x].vertical && !"#".equals(map[y][x].letter) && y + 1 < Y && !"#".equals(map[y + 1][x].letter)) {
					String word = "";
					for (int i = y; i < Y && !"#".equals(map[i][x].letter); i++) {
						word += map[i][x].letter;
						map[i][x].vertical = true;
					}
					set.add(word);
				}
			}
		}

		System.out.print(set.first());
	}

	private static class Cell {
		public String letter;
		public boolean horizontal = false;
		public boolean vertical = false;

		public Cell(String letter) {
			this.letter = letter;
		}
	}
}