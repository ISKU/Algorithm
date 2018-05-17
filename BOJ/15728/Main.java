/*
 * Author: Minho Kim (ISKU)
 * Date: May 18, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15728
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] share = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			share[i] = Integer.parseInt(st.nextToken());

		int[] team = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			team[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(share);
		Arrays.sort(team);

		int i = 0;
		int j = N - 1;
		while (K-- > 0) {
			int first = share[0] * team[i];
			int second = share[0] * team[j];
			int third = share[N - 1] * team[i];
			int forth = share[N - 1] * team[j];

			if (first >= second && first >= third && first >= forth)
				i++;
			else if (second >= first && second >= third && second >= forth)
				j--;
			else if (third >= first && third >= second && third >= forth)
				i++;
			else
				j--;
		}

		int answer = Math.max(share[0] * team[i], share[0] * team[j]);
		answer = Math.max(answer, Math.max(share[N - 1] * team[i], share[N - 1] * team[j]));
		System.out.print(answer);
	}
}