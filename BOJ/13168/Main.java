/*
 * Author: Minho Kim (ISKU)
 * Date: June 27, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13168
 */

import java.util.*;
import java.io.*;

public class Main {

	public static final int INF = 100000000;

	private static HashMap<String, Integer> vertices;
	private static int[][] firstDist, secondDist;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		vertices = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++)
			vertices.put(st.nextToken(), i);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] path = new int[M];
		for (int i = 0; i < M; i++)
			path[i] = vertices.get(st.nextToken());

		firstDist = new int[N][N];
		secondDist = new int[N][N];
		for (int u = 0; u < N; u++) {
			Arrays.fill(firstDist[u], INF);
			Arrays.fill(secondDist[u], INF);
			firstDist[u][u] = 0;
			secondDist[u][u] = 0;
		}

		int K = Integer.parseInt(br.readLine());
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			String type = st.nextToken();
			int u = vertices.get(st.nextToken());
			int v = vertices.get(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			firstDist[u][v] = Math.min(firstDist[u][v], w);
			firstDist[v][u] = Math.min(firstDist[v][u], w);
			secondDist[u][v] = Math.min(secondDist[u][v], getCost(type, w));
			secondDist[v][u] = Math.min(secondDist[v][u], getCost(type, w));
		}

		for (int k = 0; k < N; k++) {
			for (int u = 0; u < N; u++) {
				for (int v = 0; v < N; v++) {
					firstDist[u][v] = Math.min(firstDist[u][v], firstDist[u][k] + firstDist[k][v]);
					secondDist[u][v] = Math.min(secondDist[u][v], secondDist[u][k] + secondDist[k][v]);
				}
			}
		}

		int first = 0;
		int second = R;
		for (int i = 1; i < M; i++) {
			int firstCost = firstDist[path[i - 1]][path[i]];
			int secondCost = secondDist[path[i - 1]][path[i]];
			first += (firstCost == INF) ? 0 : firstCost;
			second += (secondCost == INF) ? 0 : secondCost;
		}

		System.out.print((second < first) ? "Yes" : "No");
	}

	private static int getCost(String type, int w) {
		switch (type) {
		case "Mugunghwa":
			return 0;
		case "ITX-Saemaeul":
			return 0;
		case "ITX-Cheongchun":
			return 0;
		case "S-Train":
			return w / 2;
		case "V-Train":
			return w / 2;
		default:
			return w;
		}
	}
}