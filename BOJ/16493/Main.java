/*
 * Author: Minho Kim (ISKU)
 * Date: November 17, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16493
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		Info[] infos = new Info[M];
		for (int i = 0; i < M; i++)
			infos[i] = new Info(sc.nextInt(), sc.nextInt());

		int size = 1 << M;
		int answer = 0;
		for (int i = 1; i < size; i++) {
			int day = 0;
			int page = 0;
			boolean check = true;

			for (int j = 0, d = 1; d <= i; j++, d <<= 1) {
				if ((i & d) == d) {
					day += infos[j].day;
					page += infos[j].page;
				}
				if (day > N) {
					check = false;
					break;
				}
			}

			if (check)
				answer = Math.max(answer, page);
		}

		System.out.print(answer);
	}

	private static class Info {
		public int day;
		public int page;

		public Info(int day, int page) {
			this.day = day;
			this.page = page;
		}
	}
}