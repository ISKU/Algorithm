/*
 * Author: Minho Kim (ISKU)
 * Date: April 22, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15702
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] score = new int[N + 1];
		for (int i = 1; i <= N; i++)
			score[i] = sc.nextInt();

		User[] users = new User[M + 1];
		for (int i = 1; i <= M; i++) {
			users[i] = new User(sc.nextInt(), 0);

			for (int j = 1; j <= N; j++) {
				if ("O".equals(sc.next()))
					users[i].score += score[j];
			}
		}

		Arrays.sort(users, 1, M + 1);
		System.out.printf("%d %d", users[1].id, users[1].score);
	}

	private static class User implements Comparable<User> {
		public int id;
		public int score;

		public User(int id, int score) {
			this.id = id;
			this.score = score;
		}

		@Override
		public int compareTo(User o) {
			if (this.score != o.score)
				return o.score - this.score;
			else
				return this.id - o.id;
		}
	}
}