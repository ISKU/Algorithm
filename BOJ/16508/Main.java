/*
 * Author: Minho Kim (ISKU)
 * Date: November 17, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16508
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] letter = new int[26];
		String T = sc.next();
		for (int i = 0; i < T.length(); i++)
			letter[T.charAt(i) - 'A']++;

		int N = sc.nextInt();
		Book[] books = new Book[N];
		for (int i = 0; i < N; i++)
			books[i] = new Book(sc.nextInt(), sc.next());

		int answer = Integer.MAX_VALUE;
		int size = 1 << N;
		for (int n = 1; n < size; n++) {
			int[] count = new int[26];
			int cost = 0;

			for (int d = 1, idx = 0; d <= n; d <<= 1, idx++) {
				if ((n & d) != d)
					continue;

				cost += books[idx].C;
				for (int i = 0; i < 26; i++)
					count[i] += books[idx].letter[i];
			}

			boolean check = true;
			for (int i = 0; i < 26; i++) {
				if (count[i] < letter[i]) {
					check = false;
					break;
				}
			}

			if (check)
				answer = Math.min(answer, cost);
		}

		System.out.print((answer == Integer.MAX_VALUE) ? -1 : answer);
	}

	private static class Book {
		public int C;
		public String W;
		public int[] letter;

		public Book(int C, String W) {
			this.C = C;
			this.W = W;

			this.letter = new int[26];
			for (int i = 0; i < W.length(); i++)
				this.letter[W.charAt(i) - 'A']++;
		}
	}
}