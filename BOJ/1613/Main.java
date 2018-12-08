/*
 * Author: Minho Kim (ISKU)
 * Date: December 8, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1613
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] floyd = new int[N + 1][N + 1];
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			floyd[u][v] = -1;
			floyd[v][u] = 1;
		}

		for (int k = 1; k <= N; k++)
			for (int u = 1; u <= N; u++)
				for (int v = 1; v <= N; v++)
					if (floyd[u][k] == -1 && floyd[k][v] == -1) {
						floyd[u][v] = -1;
						floyd[v][u] = 1;
					}

		int S = Integer.parseInt(br.readLine());
		while (S-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			bw.write(String.valueOf(floyd[u][v]));
			bw.write('\n');
		}

		bw.close();
	}
}
