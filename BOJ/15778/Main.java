/*
 * Author: Minho Kim (ISKU)
 * Date: May 22, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15778
 */

import java.util.*;
import java.io.*;

public class Main {

	private static char[][] board = {
		{ '.', '.', '-', '-', '-', '-', '.', '.', '-', '-', '-', '-', '.', '.', '-', '-', '-', '-', '.', '.', '-', '-', '-', '-', '.', '.', '-', '-', '-', '-', '.', '.' },
		{ '.', '.', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', '.', '.' },
		{ '|', ' ', '\\', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' ', '|' },
		{ '|', ' ', ' ', '\\', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' ', '|' },
		{ '|', ' ', ' ', ' ', '\\', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' ', ' ', '|' },
		{ '|', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', '|' },
		{ '.', '.', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', '.', '.' },
		{ '.', '.', ' ', ' ', ' ', ' ', ' ', '\\', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' ', ' ', ' ', ' ', '.', '.' },
		{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '\\', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
		{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '\\', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
		{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
		{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
		{ '.', '.', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '\\', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '.' },
		{ '.', '.', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '\\', ' ', ' ', ' ', ' ', '/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '.' },
		{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '\\', ' ', ' ', '/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
		{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
		{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
		{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' ', '\\', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
		{ '.', '.', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' ', ' ', ' ', '\\', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '.' },
		{ '.', '.', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' ', ' ', ' ', ' ', ' ', '\\', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '.' },
		{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
		{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
		{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '\\', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
		{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '\\', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
		{ '.', '.', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '\\', ' ', ' ', ' ', ' ', ' ', '.', '.' },
		{ '.', '.', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', '.', '.' },
		{ '|', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', '|' },
		{ '|', ' ', ' ', ' ', '/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '\\', ' ', ' ', ' ', '|' },
		{ '|', ' ', ' ', '/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '\\', ' ', ' ', '|' },
		{ '|', ' ', '/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '\\', ' ', '|' },
		{ '.', '.', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', '.', '.', ' ', ' ', ' ', ' ', '.', '.' },
		{ '.', '.', '-', '-', '-', '-', '.', '.', '-', '-', '-', '-', '.', '.', '-', '-', '-', '-', '.', '.', '-', '-', '-', '-', '.', '.', '-', '-', '-', '-', '.', '.' }
	};

	private static Location[] location;
	private static int[] upperLocation, lowerLocation;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		location = new Location[33];
		for (int i = 0; i < location.length; i++)
			location[i] = new Location();

		upperLocation = new int[4];
		lowerLocation = new int[4];
		for (int i = 0; i < 4; i++) {
			upperLocation[i] = 1;
			lowerLocation[i] = 1;
			location[1].upper[i] = true;
			location[1].lower[i] = true;
		}

		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char turn = st.nextToken().charAt(0);
			int move = count(st.nextToken());

			if (turn <= 'Z') {
				int mal = turn - 'A';
				int start = upperLocation[mal];
				int end = direction(start, move);
				if (end >= 32)
					end = 32;

				upperLocation[mal] = end;
				location[start].upper[mal] = false;
				location[end].upper[mal] = true;

				for (int i = 0; i < 4; i++) {
					if (start == 1 || !location[start].upper[i])
						continue;

					upperLocation[i] = end;
					location[start].upper[i] = false;
					location[end].upper[i] = true;
				}

				for (int i = 0; i < 4; i++) {
					if (!location[end].lower[i])
						continue;

					lowerLocation[i] = 1;
					location[end].lower[i] = false;
				}
			}
			else if (turn >= 'a') {
				int mal = turn - 'a';
				int start = lowerLocation[mal];
				int end = direction(start, move);
				if (end >= 32)
					end = 32;

				lowerLocation[mal] = end;
				location[start].lower[mal] = false;
				location[end].lower[mal] = true;

				for (int i = 0; i < 4; i++) {
					if (start == 1 || !location[start].lower[i])
						continue;

					lowerLocation[i] = end;
					location[start].lower[i] = false;
					location[end].lower[i] = true;
				}

				for (int i = 0; i < 4; i++) {
					if (!location[end].upper[i])
						continue;

					upperLocation[i] = 1;
					location[end].upper[i] = false;
				}
			}
		}

		for (int i = 1; i < location.length; i++) {
			for (int j = 0; j < 4; j++) {
				if (location[i].upper[j])
					place(i, j, true);
				if (location[i].lower[j])
					place(i, j, false);
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++)
				bw.write(board[i][j]);
			bw.newLine();
		}

		bw.close();
	}

	private static int direction(int start, int move) {
		switch (start) {
		case 6:
			return 20 + move;
		case 11:
			return (move == 3) ? 23 : 25 + move;
		case 21:
			return (move == 5) ? 16 : 21 + move;
		case 22:
			return (move == 4) ? 16 : (move == 5) ? 17 : 22 + move;
		case 23:
			return 28 + move;
		case 26:
			return (move == 2) ? 23 : 26 + move;
		case 27:
			return (move == 1) ? 23 : 27 + move;
		case 24:
			return (move == 1) ? 25 : 14 + move;
		case 25:
			return (move == 1) ? 16 : 15 + move;
		default:
			return (16 <= start && start <= 20 && start + move >= 21) ? 10 + start + move : start + move;
		}
	}

	private static int count(String yut) {
		int count = 0;
		for (int i = 0; i < 4; i++)
			if (yut.charAt(i) == 'F')
				count++;

		return (count == 0) ? 5 : count;
	}

	private static void place(int loc, int mal, boolean team) {
		if (loc == 31) {
			if (mal == 0)
				board[30][30] = team ? 'A' : 'a';
			if (mal == 1)
				board[30][31] = team ? 'B' : 'b';
			if (mal == 2)
				board[31][30] = team ? 'C' : 'c';
			if (mal == 3)
				board[31][31] = team ? 'D' : 'd';
		}
		else if (loc == 2) {
			if (mal == 0)
				board[24][30] = team ? 'A' : 'a';
			if (mal == 1)
				board[24][31] = team ? 'B' : 'b';
			if (mal == 2)
				board[25][30] = team ? 'C' : 'c';
			if (mal == 3)
				board[25][31] = team ? 'D' : 'd';
		}
		else if (loc == 3) {
			if (mal == 0)
				board[18][30] = team ? 'A' : 'a';
			if (mal == 1)
				board[18][31] = team ? 'B' : 'b';
			if (mal == 2)
				board[19][30] = team ? 'C' : 'c';
			if (mal == 3)
				board[19][31] = team ? 'D' : 'd';
		}
		else if (loc == 4) {
			if (mal == 0)
				board[12][30] = team ? 'A' : 'a';
			if (mal == 1)
				board[12][31] = team ? 'B' : 'b';
			if (mal == 2)
				board[13][30] = team ? 'C' : 'c';
			if (mal == 3)
				board[13][31] = team ? 'D' : 'd';
		}
		else if (loc == 5) {
			if (mal == 0)
				board[6][30] = team ? 'A' : 'a';
			if (mal == 1)
				board[6][31] = team ? 'B' : 'b';
			if (mal == 2)
				board[7][30] = team ? 'C' : 'c';
			if (mal == 3)
				board[7][31] = team ? 'D' : 'd';
		}
		else if (loc == 6) {
			if (mal == 0)
				board[0][30] = team ? 'A' : 'a';
			if (mal == 1)
				board[0][31] = team ? 'B' : 'b';
			if (mal == 2)
				board[1][30] = team ? 'C' : 'c';
			if (mal == 3)
				board[1][31] = team ? 'D' : 'd';
		}
		else if (loc == 7) {
			if (mal == 0)
				board[0][24] = team ? 'A' : 'a';
			if (mal == 1)
				board[0][25] = team ? 'B' : 'b';
			if (mal == 2)
				board[1][24] = team ? 'C' : 'c';
			if (mal == 3)
				board[1][25] = team ? 'D' : 'd';
		}
		else if (loc == 8) {
			if (mal == 0)
				board[0][18] = team ? 'A' : 'a';
			if (mal == 1)
				board[0][19] = team ? 'B' : 'b';
			if (mal == 2)
				board[1][18] = team ? 'C' : 'c';
			if (mal == 3)
				board[1][19] = team ? 'D' : 'd';
		}
		else if (loc == 9) {
			if (mal == 0)
				board[0][12] = team ? 'A' : 'a';
			if (mal == 1)
				board[0][13] = team ? 'B' : 'b';
			if (mal == 2)
				board[1][12] = team ? 'C' : 'c';
			if (mal == 3)
				board[1][13] = team ? 'D' : 'd';
		}
		else if (loc == 10) {
			if (mal == 0)
				board[0][6] = team ? 'A' : 'a';
			if (mal == 1)
				board[0][7] = team ? 'B' : 'b';
			if (mal == 2)
				board[1][6] = team ? 'C' : 'c';
			if (mal == 3)
				board[1][7] = team ? 'D' : 'd';
		}
		else if (loc == 11) {
			if (mal == 0)
				board[0][0] = team ? 'A' : 'a';
			if (mal == 1)
				board[0][1] = team ? 'B' : 'b';
			if (mal == 2)
				board[1][0] = team ? 'C' : 'c';
			if (mal == 3)
				board[1][1] = team ? 'D' : 'd';
		}
		else if (loc == 12) {
			if (mal == 0)
				board[6][0] = team ? 'A' : 'a';
			if (mal == 1)
				board[6][1] = team ? 'B' : 'b';
			if (mal == 2)
				board[7][0] = team ? 'C' : 'c';
			if (mal == 3)
				board[7][1] = team ? 'D' : 'd';
		}
		else if (loc == 13) {
			if (mal == 0)
				board[12][0] = team ? 'A' : 'a';
			if (mal == 1)
				board[12][1] = team ? 'B' : 'b';
			if (mal == 2)
				board[13][0] = team ? 'C' : 'c';
			if (mal == 3)
				board[13][1] = team ? 'D' : 'd';
		}
		else if (loc == 14) {
			if (mal == 0)
				board[18][0] = team ? 'A' : 'a';
			if (mal == 1)
				board[18][1] = team ? 'B' : 'b';
			if (mal == 2)
				board[19][0] = team ? 'C' : 'c';
			if (mal == 3)
				board[19][1] = team ? 'D' : 'd';
		}
		else if (loc == 15) {
			if (mal == 0)
				board[24][0] = team ? 'A' : 'a';
			if (mal == 1)
				board[24][1] = team ? 'B' : 'b';
			if (mal == 2)
				board[25][0] = team ? 'C' : 'c';
			if (mal == 3)
				board[25][1] = team ? 'D' : 'd';
		}
		else if (loc == 16) {
			if (mal == 0)
				board[30][0] = team ? 'A' : 'a';
			if (mal == 1)
				board[30][1] = team ? 'B' : 'b';
			if (mal == 2)
				board[31][0] = team ? 'C' : 'c';
			if (mal == 3)
				board[31][1] = team ? 'D' : 'd';
		}
		else if (loc == 17) {
			if (mal == 0)
				board[30][6] = team ? 'A' : 'a';
			if (mal == 1)
				board[30][7] = team ? 'B' : 'b';
			if (mal == 2)
				board[31][6] = team ? 'C' : 'c';
			if (mal == 3)
				board[31][7] = team ? 'D' : 'd';
		}
		else if (loc == 18) {
			if (mal == 0)
				board[30][12] = team ? 'A' : 'a';
			if (mal == 1)
				board[30][13] = team ? 'B' : 'b';
			if (mal == 2)
				board[31][12] = team ? 'C' : 'c';
			if (mal == 3)
				board[31][13] = team ? 'D' : 'd';
		}
		else if (loc == 19) {
			if (mal == 0)
				board[30][18] = team ? 'A' : 'a';
			if (mal == 1)
				board[30][19] = team ? 'B' : 'b';
			if (mal == 2)
				board[31][18] = team ? 'C' : 'c';
			if (mal == 3)
				board[31][19] = team ? 'D' : 'd';
		}
		else if (loc == 20) {
			if (mal == 0)
				board[30][24] = team ? 'A' : 'a';
			if (mal == 1)
				board[30][25] = team ? 'B' : 'b';
			if (mal == 2)
				board[31][24] = team ? 'C' : 'c';
			if (mal == 3)
				board[31][25] = team ? 'D' : 'd';
		}
		else if (loc == 21) {
			if (mal == 0)
				board[5][25] = team ? 'A' : 'a';
			if (mal == 1)
				board[5][26] = team ? 'B' : 'b';
			if (mal == 2)
				board[6][25] = team ? 'C' : 'c';
			if (mal == 3)
				board[6][26] = team ? 'D' : 'd';
		}
		else if (loc == 22) {
			if (mal == 0)
				board[10][20] = team ? 'A' : 'a';
			if (mal == 1)
				board[10][21] = team ? 'B' : 'b';
			if (mal == 2)
				board[11][20] = team ? 'C' : 'c';
			if (mal == 3)
				board[11][21] = team ? 'D' : 'd';
		}
		else if (loc == 23) {
			if (mal == 0)
				board[15][15] = team ? 'A' : 'a';
			if (mal == 1)
				board[15][16] = team ? 'B' : 'b';
			if (mal == 2)
				board[16][15] = team ? 'C' : 'c';
			if (mal == 3)
				board[16][16] = team ? 'D' : 'd';
		}
		else if (loc == 24) {
			if (mal == 0)
				board[20][10] = team ? 'A' : 'a';
			if (mal == 1)
				board[20][11] = team ? 'B' : 'b';
			if (mal == 2)
				board[21][10] = team ? 'C' : 'c';
			if (mal == 3)
				board[21][11] = team ? 'D' : 'd';
		}
		else if (loc == 25) {
			if (mal == 0)
				board[25][5] = team ? 'A' : 'a';
			if (mal == 1)
				board[25][6] = team ? 'B' : 'b';
			if (mal == 2)
				board[26][5] = team ? 'C' : 'c';
			if (mal == 3)
				board[26][6] = team ? 'D' : 'd';
		}
		else if (loc == 26) {
			if (mal == 0)
				board[5][5] = team ? 'A' : 'a';
			if (mal == 1)
				board[5][6] = team ? 'B' : 'b';
			if (mal == 2)
				board[6][5] = team ? 'C' : 'c';
			if (mal == 3)
				board[6][6] = team ? 'D' : 'd';
		}
		else if (loc == 27) {
			if (mal == 0)
				board[10][10] = team ? 'A' : 'a';
			if (mal == 1)
				board[10][11] = team ? 'B' : 'b';
			if (mal == 2)
				board[11][10] = team ? 'C' : 'c';
			if (mal == 3)
				board[11][11] = team ? 'D' : 'd';
		}
		else if (loc == 29) {
			if (mal == 0)
				board[20][20] = team ? 'A' : 'a';
			if (mal == 1)
				board[20][21] = team ? 'B' : 'b';
			if (mal == 2)
				board[21][20] = team ? 'C' : 'c';
			if (mal == 3)
				board[21][21] = team ? 'D' : 'd';
		}
		else if (loc == 30) {
			if (mal == 0)
				board[25][25] = team ? 'A' : 'a';
			if (mal == 1)
				board[25][26] = team ? 'B' : 'b';
			if (mal == 2)
				board[26][25] = team ? 'C' : 'c';
			if (mal == 3)
				board[26][26] = team ? 'D' : 'd';
		}
	}

	private static class Location {
		public boolean[] upper, lower;

		public Location() {
			this.upper = new boolean[4];
			this.lower = new boolean[4];
		}
	}
}