/*
 * Author: Minho Kim (ISKU)
 * Date: November 17, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16509
 */

import java.util.*;

public class Main {

	private static final int[] dy = new int[] { -3, -3, -2, 2, 3, 3, 2, -2 };
	private static final int[] dx = new int[] { -2, 2, 3, 3, 2, -2, -3, -3 };
	private static final int[] cy = new int[] { -2, -2, -1, 1, 2, 2, 1, -1 };
	private static final int[] cx = new int[] { -1, 1, 2, 2, 1, -1, -2, -2 };
	private static final int[] ay = new int[] { -1, -1, 0, 0, 1, 1, 0, 0 };
	private static final int[] ax = new int[] { 0, 0, 1, 1, 0, 0, -1, -1 };
	private static final int Y = 10;
	private static final int X = 9;

	private static Piece sang, king;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sang = new Piece(sc.nextInt(), sc.nextInt(), 0);
		king = new Piece(sc.nextInt(), sc.nextInt(), 0);
		System.out.print(bfs());
	}

	private static int bfs() {
		Queue<Piece> q = new LinkedList<Piece>();
		boolean[][] visited = new boolean[Y][X];
		q.add(sang);
		visited[sang.y][sang.x] = true;

		while (!q.isEmpty()) {
			Piece u = q.poll();
			if (u.y == king.y && u.x == king.x)
				return u.count;

			for (int i = 0; i < 8; i++) {
				int y = u.y + ay[i];
				int x = u.x + ax[i];
				if (y < 0 || y >= Y || x < 0 || x >= X || (y == king.y && x == king.x))
					continue;

				y = u.y + cy[i];
				x = u.x + cx[i];
				if (y < 0 || y >= Y || x < 0 || x >= X || (y == king.y && x == king.x))
					continue;

				y = u.y + dy[i];
				x = u.x + dx[i];
				if (y < 0 || y >= Y || x < 0 || x >= X || visited[y][x])
					continue;

				q.add(new Piece(y, x, u.count + 1));
				visited[y][x] = true;
			}
		}

		return -1;
	}

	private static class Piece {
		public int y, x, count;

		public Piece(int y, int x, int count) {
			this.y = y;
			this.x = x;
			this.count = count;
		}
	}
}