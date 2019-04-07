/*
 * Author: Minho Kim (ISKU)
 * Date: April 6, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17135
 */

import java.io.*;
import java.util.*;

public class Main {

	private static List<Enemy> origin, enemies;
	private static int Y, X, D;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		origin = new ArrayList<Enemy>();
		for (int y = 0; y < Y; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < X; x++)
				if (Integer.parseInt(st.nextToken()) == 1)
					origin.add(new Enemy(y, x));
		}
		Collections.sort(origin, new Comparator<Enemy>() {
			@Override
			public int compare(Enemy o1, Enemy o2) {
				if (o1.x == o2.x)
					return Integer.compare(o2.y, o1.y);
				return Integer.compare(o1.x, o2.x);
			}
		});

		int answer = 0;
		for (int ax = 0; ax < X; ax++) {
			for (int bx = ax + 1; bx < X; bx++) {
				for (int cx = bx + 1; cx < X; cx++) {
					enemies = new ArrayList<Enemy>();
					for (int x = 0; x < origin.size(); x++) {
						Enemy e = origin.get(x);
						enemies.add(new Enemy(e.y, e.x));
					}

					answer = Math.max(answer, play(ax, bx, cx));
				}
			}
		}

		System.out.println(answer);
	}

	private static int play(int ax, int bx, int cx) {
		int kill = 0;
		int remove = 0;
		int min = Integer.MAX_VALUE;

		while (true) {
			if (enemies.size() == remove)
				break;

			int[] candidate = new int[] { -1, -1, -1 };

			min = Integer.MAX_VALUE;
			for (int i = 0; i < enemies.size(); i++) {
				Enemy e = enemies.get(i);
				if (e == null)
					continue;

				int dist = distance(e, Y, ax);
				if (dist <= D && dist < min) {
					candidate[0] = i;
					min = dist;
				}
			}

			min = Integer.MAX_VALUE;
			for (int i = 0; i < enemies.size(); i++) {
				Enemy e = enemies.get(i);
				if (e == null)
					continue;

				int dist = distance(e, Y, bx);
				if (dist <= D && dist < min) {
					candidate[1] = i;
					min = dist;
				}
			}

			min = Integer.MAX_VALUE;
			for (int i = 0; i < enemies.size(); i++) {
				Enemy e = enemies.get(i);
				if (e == null)
					continue;

				int dist = distance(e, Y, cx);
				if (dist <= D && dist < min) {
					candidate[2] = i;
					min = dist;
				}
			}

			for (int i = 0; i < 3; i++) {
				if (candidate[i] != -1 && enemies.get(candidate[i]) != null) {
					enemies.set(candidate[i], null);
					kill++;
					remove++;
				}
			}

			for (int i = 0; i < enemies.size(); i++) {
				Enemy e = enemies.get(i);
				if (e == null)
					continue;

				e.y++;
				if (e.y == Y) {
					enemies.set(i, null);
					remove++;
				}
			}
		}

		return kill;
	}

	private static int distance(Enemy p, int y, int x) {
		return Math.abs(p.y - y) + Math.abs(p.x - x);
	}

	private static class Enemy {
		public int y, x;

		public Enemy(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}