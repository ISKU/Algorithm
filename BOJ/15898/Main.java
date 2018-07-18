/*
 * Author: Minho Kim (ISKU)
 * Date: July 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15898
 */

import java.util.*;
import java.io.*;

public class Main {

	private static Material[][][] materials;
	private static ArrayList<Integer> candidate;
	private static int N, answer;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		materials = new Material[N][4][4];
		for (int k = 0; k < N; k++)
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++)
					materials[k][i][j] = new Material(0, 'W');

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++)
					materials[k][i][j].effect = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++)
					materials[k][i][j].element = st.nextToken().charAt(0);
			}
		}

		candidate = new ArrayList<Integer>();
		select(0);

		System.out.print(answer);
	}

	private static void select(int n) {
		if (n > N)
			return;
		if (candidate.size() == 3) {
			int a = candidate.get(0);
			int b = candidate.get(1);
			int c = candidate.get(2);

			run(a, b, c);
			run(a, c, b);
			run(b, a, c);
			run(b, c, a);
			run(c, a, b);
			run(c, b, a);
			return;
		}

		candidate.add(n);
		select(n + 1);
		candidate.remove(candidate.size() - 1);
		select(n + 1);
	}

	private static void run(int a, int b, int c) {
		Material[][] A = arraycopy(materials[a], 4);
		Material[][] B = arraycopy(materials[b], 4);
		Material[][] C = arraycopy(materials[c], 4);
		direction(A, B, C);
	}

	private static void direction(Material[][] A, Material[][] B, Material[][] C) {
		for (int i = 0; i < 4; i++) {
			rotate(A);
			for (int j = 0; j < 4; j++) {
				rotate(B);
				for (int k = 0; k < 4; k++) {
					rotate(C);
					placement(A, B, C);
				}
			}
		}
	}

	private static void placement(Material[][] A, Material[][] B, Material[][] C) {
		for (int pi = 0; pi < 4; pi++) {
			Material[][] tempA = new Material[5][5];
			for (int i = 0; i < 5; i++)
				for (int j = 0; j < 5; j++)
					tempA[i][j] = new Material(0, 'W');
			position(pi, tempA, A);

			for (int pj = 0; pj < 4; pj++) {
				Material[][] tempB = arraycopy(tempA, 5);
				position(pj, tempB, B);

				for (int pk = 0; pk < 4; pk++) {
					Material[][] tempC = arraycopy(tempB, 5);
					position(pk, tempC, C);
					answer = Math.max(answer, sum(tempC));
				}
			}
		}
	}

	private static void position(int p, Material[][] array, Material[][] target) {
		if (p == 0)
			merge(0, 0, array, target);
		else if (p == 1)
			merge(0, 1, array, target);
		else if (p == 2)
			merge(1, 0, array, target);
		else
			merge(1, 1, array, target);
	}

	private static void merge(int y, int x, Material[][] array, Material[][] target) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int effect = array[i + y][j + x].effect + target[i][j].effect;
				char element = target[i][j].element;
				array[i + y][j + x].effect = (effect < 0) ? 0 : (effect > 9) ? 9 : effect;
				array[i + y][j + x].element = (element == 'W') ? array[i + y][j + x].element : element;
			}
		}
	}

	private static void rotate(Material[][] array) {
		Material[][] temp = arraycopy(array, 4);
		int pi = 0;
		int pj = 0;

		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >= 0; j--)
				array[i][j] = temp[pi++][pj];
			pi = 0;
			pj++;
		}
	}

	private static int sum(Material[][] array) {
		int R = 0;
		int B = 0;
		int G = 0;
		int Y = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (array[i][j].element == 'R')
					R += array[i][j].effect;
				else if (array[i][j].element == 'B')
					B += array[i][j].effect;
				else if (array[i][j].element == 'G')
					G += array[i][j].effect;
				else if (array[i][j].element == 'Y')
					Y += array[i][j].effect;
			}
		}

		return (7 * R) + (5 * B) + (3 * G) + (2 * Y);
	}

	private static Material[][] arraycopy(Material[][] array, int size) {
		Material[][] temp = new Material[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				temp[i][j] = new Material(array[i][j].effect, array[i][j].element);

		return temp;
	}

	private static class Material {
		public int effect;
		public char element;

		public Material(int effect, char element) {
			this.effect = effect;
			this.element = element;
		}
	}
}