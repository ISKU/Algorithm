/*
 * Author: Minho Kim (ISKU)
 * Date: November 26, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/18125
 */

import java.io.*;
import java.util.*;

public class Main {

	private static int Y, X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		int[][] A = new int[Y][X];
		for (int x = X - 1; x >= 0; x--) {
			st = new StringTokenizer(br.readLine());
			for (int y = 0; y < Y; y++)
				A[y][x] = Integer.parseInt(st.nextToken());
		}

		int[][] B = new int[Y][X];
		for (int y = 0; y < Y; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < X; x++)
				B[y][x] = Integer.parseInt(st.nextToken());
		}

		if (compare(A, B)) {
			System.out.println(
					"|>___/|        /}\n" + 
					"| O < |       / }\n" + 
					"(==0==)------/ }\n" + 
					"| ^  _____    |\n" + 
					"|_|_/     ||__|");
		} else {
			System.out.println(
					"|>___/|     /}\n" + 
					"| O O |    / }\n" + 
					"( =0= )\"\"\"\"  \\\n" + 
					"| ^  ____    |\n" + 
					"|_|_/    ||__|");
		}
	}

	private static boolean compare(int[][] A, int[][] B) {
		for (int y = 0; y < Y; y++)
			for (int x = 0; x < X; x++)
				if (A[y][x] != B[y][x])
					return false;

		return true;
	}
}
