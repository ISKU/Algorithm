/*
 * Author: Minho Kim (ISKU)
 * Date: April 18, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15659
 */

import java.util.*;

public class Main {

	private static int N, MIN, MAX;
	private static int[] array, operator;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		array = new int[2 * N - 1];
		for (int i = 0; i < array.length; i += 2)
			array[i] = sc.nextInt();

		operator = new int[4];
		for (int i = 0; i < 4; i++)
			operator[i] = sc.nextInt();

		MIN = Integer.MAX_VALUE;
		MAX = Integer.MIN_VALUE;
		dfs(1);

		System.out.printf("%d\n%d", MAX, MIN);
	}

	private static void dfs(int n) {
		if (n == N) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int i : array)
				list.add(i);

			while (list.contains((int) 1e9 + 3) || list.contains((int) 1e9 + 4)) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) == (int) 1e9 + 3) {
						list.set(i, list.get(i - 1) * list.get(i + 1));
						list.remove(i - 1);
						list.remove(i);
						i = i - 1;
					}
					if (list.get(i) == (int) 1e9 + 4) {
						if (list.get(i + 1) == 0)
							return;
						list.set(i, list.get(i - 1) / list.get(i + 1));
						list.remove(i - 1);
						list.remove(i);
						i = i - 1;
					}
				}
			}
			while (list.contains((int) 1e9 + 1) || list.contains((int) 1e9 + 2)) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) == (int) 1e9 + 1) {
						list.set(i, list.get(i - 1) + list.get(i + 1));
						list.remove(i - 1);
						list.remove(i);
						i = i - 1;
					}
					if (list.get(i) == (int) 1e9 + 2) {
						list.set(i, list.get(i - 1) - list.get(i + 1));
						list.remove(i - 1);
						list.remove(i);
						i = i - 1;
					}
				}
			}

			MIN = Math.min(MIN, list.get(0));
			MAX = Math.max(MAX, list.get(0));
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				array[n * 2 - 1] = (int) 1e9 + i + 1;
				operator[i]--;
				dfs(n + 1);
				operator[i]++;
			}
		}
	}
}