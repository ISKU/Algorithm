/*
 * Author: Minho Kim (ISKU)
 * Date: November 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16434
 */

import java.util.*;
import java.io.*;

public class Main {

	private static Stage[] stages;
	private static int N;
	private static long ATK;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		ATK = Long.parseLong(st.nextToken());

		stages = new Stage[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			long atk = Integer.parseInt(st.nextToken());
			long hp = Integer.parseInt(st.nextToken());
			stages[i] = new Stage(t, atk, hp);
		}

		long l = 1;
		long r = Long.MAX_VALUE - 1;
		while (l < r) {
			long mid = (l + r) / 2;

			if (isPossible(mid))
				r = mid;
			else
				l = mid + 1;
		}

		System.out.print(l);
	}

	private static boolean isPossible(long maxhp) {
		long hp = maxhp;
		long atk = ATK;

		for (int i = 0; i < N; i++) {
			Stage T = stages[i];

			if (stages[i].t == 1) {
				long n = (T.hp % atk == 0) ? T.hp / atk - 1 : T.hp / atk;
				long totalAtk = T.atk * n;
				hp -= totalAtk;
				if (hp <= 0)
					return false;
			}
			if (stages[i].t == 2) {
				atk += T.atk;
				hp = hp + T.hp;
				if (hp > maxhp)
					hp = maxhp;
			}
		}

		return true;
	}

	private static class Stage {
		public int t;
		public long atk, hp;

		public Stage(int t, long atk, long hp) {
			this.t = t;
			this.atk = atk;
			this.hp = hp;
		}
	}
}