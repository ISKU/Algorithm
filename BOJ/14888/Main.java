/*
 * Author: Minho Kim (ISKU)
 * Date: January 14, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14888
 */

import java.util.*;

public class Main {

	private static int N;
	private static int[] seq;
	private static int MAX = Integer.MIN_VALUE;
	private static int MIN = Integer.MAX_VALUE;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		seq = new int[N];
		for (int i = 0; i < N; i++)
			seq[i] = sc.nextInt();

		ArrayList<Integer> oper = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {
			int count = sc.nextInt();
			while (count-- > 0)
				oper.add(i);
		}

		find(1, seq[0], oper);
		System.out.printf("%d\n%d", MAX, MIN);
	}

	private static void find(int i, int result, ArrayList<Integer> list) {
		if (i == N) {
			MAX = Math.max(MAX, result);
			MIN = Math.min(MIN, result);
			return;
		}

		for (int op : list) {
			int sum = result;

			if (op == 0)
				sum += seq[i];
			else if (op == 1)
				sum -= seq[i];
			else if (op == 2)
				sum *= seq[i];
			else if (op == 3)
				sum /= seq[i];

			ArrayList<Integer> oper = (ArrayList<Integer>) list.clone();
			oper.remove(Integer.valueOf(op));
			find(i + 1, sum, oper);
		}
	}
}