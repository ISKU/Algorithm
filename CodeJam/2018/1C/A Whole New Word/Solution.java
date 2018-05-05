/*
 * Author: Minho Kim (ISKU)
 * Date: May 5, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://codejam.withgoogle.com/2018/challenges/0000000000007765/dashboard
 */

import java.util.*;
import java.io.*;

public class Solution {

	private static char[][] table;
	private static HashSet<String> set;
	private static int N, L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			table = new char[N][L];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < L; j++)
					table[i][j] = line.charAt(j);
			}

			set = new HashSet<String>();
			for (int i = 0; i < N; i++)
				set.add(new String(table[i]));

			boolean check = true;
			OUT:
			for (int k = 0; k < L; k++) {
				for (int i = 0; i < N; i++) {
					char temp = table[i][k];

					for (int j = 0; j < N; j++) {
						if (i != j) {
							table[i][k] = table[j][k];
							String word = new String(table[i]);
							if (!set.contains(word)) {
								bw.write(String.format("Case #%d: %s\n", t, word));
								check = false;
								break OUT;
							}
						}
					}

					table[i][k] = temp;
				}
			}

			if (check)
				bw.write(String.format("Case #%d: -\n", t));
		}

		bw.close();
	}
}