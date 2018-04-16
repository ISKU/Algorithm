/*
 * Author: Minho Kim (ISKU)
 * Date: April 14, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2931
 */

import java.util.*;

public class Main {

	private static int Y, X;
	private static Pipe[][] map;
	private static ArrayList<Pipe> pipes;
	private static Pipe M, Z;
	private static int ty, tx;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		Y = sc.nextInt();
		X = sc.nextInt();

		pipes = new ArrayList<Pipe>();
		map = new Pipe[Y + 1][X + 1];
		for (int y = 1; y <= Y; y++) {
			String line = sc.next();
			for (int x = 1; x <= X; x++) {
				map[y][x] = new Pipe(y, x, line.charAt(x - 1));

				if (map[y][x].shape == '.')
					continue;
				else if (map[y][x].shape == 'M')
					M = map[y][x];
				else if (map[y][x].shape == 'Z')
					Z = map[y][x];
				else
					pipes.add(map[y][x]);
			}
		}

		int dm = dfs(M.y, M.x, -1);
		int dy = dfs(Z.y, Z.x, -1);
		map[ty][tx].shape = shape(dm, dy);

		System.out.printf("%d %d %c", ty, tx, decision() ? map[ty][tx].shape : '+');
	}

	private static int dfs(int y, int x, int d) {
		map[y][x].visit = true;

		switch (map[y][x].shape) {
		case '|':
			if (d == 1)
				return dfs(y + 1, x, 1);
			if (d == 3)
				return dfs(y - 1, x, 3);
		case '-':
			if (d == 2)
				return dfs(y, x - 1, 2);
			if (d == 4)
				return dfs(y, x + 1, 4);
		case '+':
			if (d == 1)
				return dfs(y + 1, x, 1);
			if (d == 2)
				return dfs(y, x - 1, 2);
			if (d == 3)
				return dfs(y - 1, x, 3);
			if (d == 4)
				return dfs(y, x + 1, 4);
		case '1':
			if (d == 2)
				return dfs(y + 1, x, 1);
			if (d == 3)
				return dfs(y, x + 1, 4);
		case '2':
			if (d == 1)
				return dfs(y, x + 1, 4);
			if (d == 2)
				return dfs(y - 1, x, 3);
		case '3':
			if (d == 1)
				return dfs(y, x - 1, 2);
			if (d == 4)
				return dfs(y - 1, x, 3);
		case '4':
			if (d == 3)
				return dfs(y, x - 1, 2);
			if (d == 4)
				return dfs(y + 1, x, 1);
		case 'M':
		case 'Z':
			if (d != -1)
				return -1;
			if (y - 1 > 0 && isPipe(y - 1, x))
				return dfs(y - 1, x, 3);
			if (y + 1 <= Y && isPipe(y + 1, x))
				return dfs(y + 1, x, 1);
			if (x - 1 > 0 && isPipe(y, x - 1))
				return dfs(y, x - 1, 2);
			if (x + 1 <= X && isPipe(y, x + 1))
				return dfs(y, x + 1, 4);
		default:
			ty = y;
			tx = x;
			return d;
		}
	}

	private static char shape(int dm, int dz) {
		if (dm > dz) {
			int temp = dm;
			dm = dz;
			dz = temp;
		}

		if (dm == 1 && dz == 3)
			return '|';
		if (dm == 2 && dz == 4)
			return '-';
		if (dm == 2 && dz == 3)
			return '1';
		if (dm == 1 && dz == 2)
			return '2';
		if (dm == 1 && dz == 4)
			return '3';
		if (dm == 3 && dz == 4)
			return '4';
		return '+';
	}

	private static boolean decision() {
		dfs(M.y, M.x, -1);

		for (Pipe p : pipes)
			if (p.visit == false)
				return false;
		return true;
	}

	private static boolean isPipe(int y, int x) {
		return map[y][x].shape != '.' && map[y][x].shape != 'M' && map[y][x].shape != 'Z';
	}

	private static class Pipe {
		public int y, x;
		public char shape;
		public boolean visit;

		public Pipe(int y, int x, char shape) {
			this.y = y;
			this.x = x;
			this.shape = shape;
		}
	}
}