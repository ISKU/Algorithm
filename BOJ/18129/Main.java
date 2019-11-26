/*
 * Author: Minho Kim (ISKU)
 * Date: November 25, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/18129
 */

import java.io.*;
import java.util.*;

public class Main {

	private static char[] S;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = st.nextToken().toLowerCase().toCharArray();
		int K = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[26];
		for (int i = 0; i < S.length; i++) {
			if (visited[S[i] - 'a'])
				continue;

			int next = dfs(i, S[i]);
			bw.write((next - i + 1 >= K) ? '1' : '0');
			i = next;
			visited[S[i] - 'a'] = true;
		}

		bw.close();
	}

	private static int dfs(int i, char c) {
		if (i >= S.length || S[i] != c)
			return i - 1;
		return dfs(i + 1, c);
	}
}
