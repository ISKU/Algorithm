/*
 * Author: Minho Kim (ISKU)
 * Date: March 2, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16987
 */

import java.io.*;
import java.util.*;

public class Main {

	private static Egg[] eggs;
	private static int N, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		eggs = new Egg[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		answer = 0;
		dfs(0);
		System.out.println(answer);
	}

	private static void dfs(int n) {
		if (n == N) {
			int count = 0;
			for (int i = 0; i < N; i++)
				if (eggs[i].durability <= 0)
					count++;

			answer = Math.max(answer, count);
			return;
		}
		if (eggs[n].durability <= 0) {
			dfs(n + 1);
			return;
		}

		boolean check = true;
		for (int i = 0; i < N; i++) {
			if (n == i || eggs[i].durability <= 0)
				continue;

			eggs[n].durability -= eggs[i].weight;
			eggs[i].durability -= eggs[n].weight;
			dfs(n + 1);
			check = false;
			eggs[n].durability += eggs[i].weight;
			eggs[i].durability += eggs[n].weight;
		}
		if (check)
			dfs(n + 1);
	}

	private static class Egg {
		public int durability, weight;

		public Egg(int durability, int weight) {
			this.durability = durability;
			this.weight = weight;
		}
	}
}