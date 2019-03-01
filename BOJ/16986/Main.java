/*
 * Author: Minho Kim (ISKU)
 * Date: March 1, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16986
 */

import java.io.*;
import java.util.*;

public class Main {

	private static int[][] rule;
	private static int[] JW, KH, MH;
	private static boolean[] select;
	private static int N, K;
	private static int indexJW, indexKH, indexMH;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		rule = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				rule[i][j] = Integer.parseInt(st.nextToken());
		}
		KH = new int[21];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= 20; i++)
			KH[i] = Integer.parseInt(st.nextToken());
		MH = new int[21];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= 20; i++)
			MH[i] = Integer.parseInt(st.nextToken());

		JW = new int[N + 1];
		select = new boolean[N + 1];
		dfs(1);

		System.out.println(0);
	}

	private static void dfs(int n) {
		if (n > N) {
			if (play()) {
				System.out.println(1);
				System.exit(0);
			}
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (select[i])
				continue;

			select[i] = true;
			JW[n] = i;
			dfs(n + 1);
			select[i] = false;
		}
	}

	private static boolean play() {
		int player1 = 1;
		int player2 = 2;
		int countJW = 0;
		int countKH = 0;
		int countMH = 0;
		indexJW = 1;
		indexKH = 1;
		indexMH = 1;

		while (true) {
			if (countJW >= K)
				return true;
			if (countKH >= K || countMH >= K)
				return false;
			if (indexJW > N || indexKH > 20 || indexMH > 20)
				break;

			int hand1 = getHand(player1);
			int hand2 = getHand(player2);
			int winner = 0;
			if (rule[hand1][hand2] == 2) {
				winner = player1;
				player2 = nextPlayer(player1, player2);
			}
			else if (rule[hand1][hand2] == 0) {
				winner = player2;
				player2 = nextPlayer(player1, player2);
				player1 = winner;
			}
			else {
				winner = draw(player1, player2);
				player2 = nextPlayer(player1, player2);
				player1 = winner;
			}

			if (winner == 1)
				countJW++;
			else if (winner == 2)
				countKH++;
			else if (winner == 3)
				countMH++;
		}

		return false;
	}

	private static int getHand(int p) {
		if (p == 2)
			return KH[indexKH++];
		if (p == 3)
			return MH[indexMH++];
		return JW[indexJW++];
	}

	private static int nextPlayer(int p1, int p2) {
		if ((p1 == 2 && p2 == 3) || (p1 == 3 && p2 == 2))
			return 1;
		if ((p1 == 1 && p2 == 3) || (p1 == 3 && p2 == 1))
			return 2;
		return 3;
	}

	private static int draw(int p1, int p2) {
		if ((p1 == 1 && p2 == 2) || (p1 == 2 && p2 == 1))
			return 2;
		return 3;
	}
}