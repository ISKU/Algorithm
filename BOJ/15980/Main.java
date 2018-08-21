/*
 * Author: Minho Kim (ISKU)
 * Date: August 21, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15980
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Bird[] birds = new Bird[N];
		int[] psum = new int[M + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char location = st.nextToken().charAt(0);
			char[] query = st.nextToken().toCharArray();
			birds[i] = new Bird(location, query);

			for (int j = 0; j < M; j++) {
				if (query[j] == '0')
					continue;

				if (location == 'L')
					psum[j + 1]++;
				else
					psum[j + 1]--;
			}
		}
		for (int i = 1; i <= M; i++)
			psum[i] = psum[i - 1] - psum[i];

		int index = 0;
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int p = 0;
			int max = 0;

			for (int j = 0; j < M; j++) {
				if (birds[i].query[j] == '1') {
					if (birds[i].location == 'L')
						p++;
					else
						p--;
				}

				max = Math.max(max, Math.abs(psum[j + 1] + p));
			}

			if (answer > max) {
				answer = max;
				index = i;
			}
		}

		System.out.printf("%d\n%d", index + 1, answer);
	}

	private static class Bird {
		public char location;
		public char[] query;

		public Bird(char location, char[] query) {
			this.location = location;
			this.query = query;
		}
	}
}