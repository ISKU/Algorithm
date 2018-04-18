/*
 * Author: Minho Kim (ISKU)
 * Date: April 18, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15686
 */

import java.util.*;

public class Main {

	private static int N, M, answer;
	private static ArrayList<House> homes;
	private static ArrayList<House> chicks;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		homes = new ArrayList<House>();
		chicks = new ArrayList<House>();
		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= N; x++) {
				int info = sc.nextInt();
				if (info == 1)
					homes.add(new House(y, x));
				if (info == 2)
					chicks.add(new House(y, x));
			}
		}

		answer = Integer.MAX_VALUE;
		dfs(0, 1, 0, 0);

		System.out.print(answer);
		sc.close();
	}

	private static void dfs(int n, long d, int s, long select) {
		if (n >= chicks.size()) {
			if (s != M)
				return;

			ArrayList<House> candidate = new ArrayList<>();
			for (int i = 0; select > 0; i++, select /= 10)
				if (select % 2 == 1)
					candidate.add(chicks.get(i));

			int sum = 0;
			for (House home : homes) {
				int dist = Integer.MAX_VALUE;
				for (House chick : candidate)
					dist = Math.min(dist, Math.abs(chick.y - home.y) + Math.abs(chick.x - home.x));

				sum += dist;
			}

			answer = Math.min(answer, sum);
			return;
		}

		dfs(n + 1, d * 10, s + 1, select + d * 1);
		dfs(n + 1, d * 10, s, select);
	}

	private static class House {
		public int y, x;

		public House(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}