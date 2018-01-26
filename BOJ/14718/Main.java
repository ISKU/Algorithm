/*
 * Author: Minho Kim (ISKU)
 * Date: January 26, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14718
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		Soldier[] sol = new Soldier[N];
		for (int i = 0; i < N; i++)
			sol[i] = new Soldier(sc.nextInt(), sc.nextInt(), sc.nextInt());

		Arrays.sort(sol);
		int min = Integer.MAX_VALUE;

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				int count = 0;

				for (int z = 0; z < N; z++) {
					if (sol[z].str <= sol[x].str && sol[z].dex <= sol[y].dex)
						count++;
					if (count == K) {
						min = Math.min(min, sol[x].str + sol[y].dex + sol[z].luk);
						break;
					}
				}
			}
		}

		System.out.print(min);
	}

	private static class Soldier implements Comparable<Soldier> {
		public int str, dex, luk;

		public Soldier(int str, int dex, int luk) {
			this.str = str;
			this.dex = dex;
			this.luk = luk;
		}

		@Override
		public int compareTo(Soldier o) {
			return this.luk - o.luk;
		}
	}
}