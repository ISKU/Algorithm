/*
 * Author: Minho Kim (ISKU)
 * Date: July 14, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9525
 */

import java.util.*;
import java.io.*;

public class Main {

	private static Cell[][] chess;
	private static ArrayList<Integer>[] network;
	private static int[] source, sink;
	private static boolean[] visited;
	private static int N, Y, X;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		chess = new Cell[N][N];
		for (int y = 0; y < N; y++) {
			String line = br.readLine();
			for (int x = 0; x < N; x++)
				chess[y][x] = new Cell(line.charAt(x) == 'X', 0, 0);
		}

		Y = 1;
		X = 1;
		for (int x = 0; x < N; x++)
			for (int y = 0; y < N; y++)
				if (!chess[y][x].pawn && chess[y][x].source == 0)
					dfsY(y, x, Y++);
		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++)
				if (!chess[y][x].pawn && chess[y][x].sink == 0)
					dfsX(y, x, X++);

		network = new ArrayList[Y];
		for (int i = 1; i < Y; i++)
			network[i] = new ArrayList<Integer>();

		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++)
				if (chess[y][x].source != 0 && chess[y][x].sink != 0)
					network[chess[y][x].source].add(chess[y][x].sink);

		int match = 0;
		source = new int[Y];
		sink = new int[X];
		for (int u = 1; u < Y; u++) {
			if (source[u] == 0) {
				visited = new boolean[Y];
				if (matching(u))
					match++;
			}
		}

		System.out.print(match);
	}

	private static boolean matching(int u) {
		visited[u] = true;

		for (int v : network[u]) {
			if (sink[v] == 0 || (!visited[sink[v]] && matching(sink[v]))) {
				source[u] = v;
				sink[v] = u;
				return true;
			}
		}

		return false;
	}

	private static void dfsY(int y, int x, int source) {
		chess[y][x].source = source;

		if (y + 1 < N && !chess[y + 1][x].pawn)
			dfsY(y + 1, x, source);
	}

	private static void dfsX(int y, int x, int sink) {
		chess[y][x].sink = sink;

		if (x + 1 < N && !chess[y][x + 1].pawn)
			dfsX(y, x + 1, sink);
	}

	private static class Cell {
		public boolean pawn;
		public int source, sink;

		public Cell(boolean pawn, int source, int sink) {
			this.pawn = pawn;
			this.source = source;
			this.sink = sink;
		}
	}
}