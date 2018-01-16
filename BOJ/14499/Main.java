/*
 * Author: Minho Kim (ISKU)
 * Date: January 16, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14499
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int Y = sc.nextInt();
		int X = sc.nextInt();
		Dice dice = new Dice(0, 0, 0, 0, 0, 0, sc.nextInt(), sc.nextInt());
		int K = sc.nextInt();

		int[][] map = new int[Y][X];
		for (int y = 0; y < Y; y++)
			for (int x = 0; x < X; x++)
				map[y][x] = sc.nextInt();

		while (K-- > 0) {
			int k = sc.nextInt();

			if (k == 1 && dice.x + 1 < X)
				dice.east();
			else if (k == 2 && dice.x - 1 >= 0)
				dice.west();
			else if (k == 3 && dice.y - 1 >= 0)
				dice.north();
			else if (k == 4 && dice.y + 1 < Y)
				dice.south();
			else
				continue;

			if (map[dice.y][dice.x] == 0)
				map[dice.y][dice.x] = dice.bottom;
			else {
				dice.bottom = map[dice.y][dice.x];
				map[dice.y][dice.x] = 0;
			}

			System.out.println(dice.top);
		}
	}

	private static class Dice {
		public int top, bottom, front, rear, left, right;
		public int y, x;

		public Dice(int top, int bottom, int front, int rear, int left, int right, int y, int x) {
			this.top = top;
			this.bottom = bottom;
			this.front = front;
			this.rear = rear;
			this.left = left;
			this.right = right;
			this.y = y;
			this.x = x;
		}

		public void east() {
			int temp = this.top;
			this.top = this.left;
			this.left = this.bottom;
			this.bottom = this.right;
			this.right = temp;
			this.x++;
		}

		public void west() {
			int temp = this.top;
			this.top = this.right;
			this.right = this.bottom;
			this.bottom = this.left;
			this.left = temp;
			this.x--;
		}

		public void south() {
			int temp = this.top;
			this.top = this.rear;
			this.rear = this.bottom;
			this.bottom = this.front;
			this.front = temp;
			this.y++;
		}

		public void north() {
			int temp = this.top;
			this.top = this.front;
			this.front = this.bottom;
			this.bottom = this.rear;
			this.rear = temp;
			this.y--;
		}
	}
}