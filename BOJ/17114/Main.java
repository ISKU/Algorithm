/*
 * Author: Minho Kim (ISKU)
 * Date: April 4, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17114
 */

import java.io.*;
import java.util.*;

public class Main {

	public static final int[] dw = new int[] { -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	public static final int[] dv = new int[] { 0, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	public static final int[] du = new int[] { 0, 0, 0, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	public static final int[] dt = new int[] { 0, 0, 0, 0, 0, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	public static final int[] dr = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	public static final int[] ds = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	public static final int[] dq = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0 };
	public static final int[] dp = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, 0, 0, 0, 0, 0 };
	public static final int[] dO = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, 0, 0, 0 };
	public static final int[] dn = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, 0 };
	public static final int[] dm = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1 };

	private static Queue<Tomato> queue;
	private static int[][][][][][][][][][][] hyper;
	private static boolean[][][][][][][][][][][] visited;
	private static int W, V, U, T, S, R, Q, P, O, N, M;
	private static int count, empty, size;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		O = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		hyper = new int[W][V][U][T][S][R][Q][P][O][N][M];
		visited = new boolean[W][V][U][T][S][R][Q][P][O][N][M];
		queue = new LinkedList<Tomato>();
		for (int w = 0; w < W; w++) {
			for (int v = 0; v < V; v++) {
				for (int u = 0; u < U; u++) {
					for (int t = 0; t < T; t++) {
						for (int s = 0; s < S; s++) {
							for (int r = 0; r < R; r++) {
								for (int q = 0; q < Q; q++) {
									for (int p = 0; p < P; p++) {
										for (int o = 0; o < O; o++) {
											for (int n = 0; n < N; n++) {
												st = new StringTokenizer(br.readLine());

												for (int m = 0; m < M; m++) {
													hyper[w][v][u][t][s][r][q][p][o][n][m] = Integer.parseInt(st.nextToken());

													if (hyper[w][v][u][t][s][r][q][p][o][n][m] == -1)
														empty++;
													if (hyper[w][v][u][t][s][r][q][p][o][n][m] == 1) {
														visited[w][v][u][t][s][r][q][p][o][n][m] = true;
														queue.add(new Tomato(w, v, u, t, s, r, q, p, o, n, m, 0));
														count++;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		size = W * V * U * T * S * R * Q * P * O * N * M;
		if (count + empty == size) {
			System.out.println(0);
			System.exit(0);
		}

		while (!queue.isEmpty()) {
			Tomato tomato = queue.poll();

			for (int i = 0; i < 22; i++) {
				int w = tomato.w + dw[i];
				int v = tomato.v + dv[i];
				int u = tomato.u + du[i];
				int t = tomato.t + dt[i];
				int s = tomato.s + ds[i];
				int r = tomato.r + dr[i];
				int q = tomato.q + dq[i];
				int p = tomato.p + dp[i];
				int o = tomato.o + dO[i];
				int n = tomato.n + dn[i];
				int m = tomato.m + dm[i];

				if (w < 0 || w >= W || v < 0 || v >= V || u < 0 || u >= U || t < 0 || t >= T || s < 0 || s >= S || r < 0 || r >= R || q < 0 || q >= Q || p < 0 || p >= P || o < 0 || o >= O || n < 0 || n >= N || m < 0 || m >= M)
					continue;
				if (visited[w][v][u][t][s][r][q][p][o][n][m] || hyper[w][v][u][t][s][r][q][p][o][n][m] != 0)
					continue;

				hyper[w][v][u][t][s][r][q][p][o][n][m] = 1;
				visited[w][v][u][t][s][r][q][p][o][n][m] = true;
				queue.add(new Tomato(w, v, u, t, s, r, q, p, o, n, m, tomato.day + 1));

				count++;
				if (count + empty == size) {
					System.out.println(tomato.day + 1);
					System.exit(0);
				}
			}
		}

		System.out.println(-1);
	}

	private static class Tomato {
		public int w, v, u, t, s, r, q, p, o, n, m, day;

		public Tomato(int w, int v, int u, int t, int s, int r, int q, int p, int o, int n, int m, int day) {
			this.w = w;
			this.v = v;
			this.u = u;
			this.t = t;
			this.s = s;
			this.r = r;
			this.q = q;
			this.p = p;
			this.o = o;
			this.n = n;
			this.m = m;
			this.day = day;
		}
	}
}