/*
 * Author: Minho Kim (ISKU)
 * Date: November 30, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16637
 */

import java.util.*;

public class Main {

	private static final long PLUS = Long.MAX_VALUE;
	private static final long MINUS = Long.MAX_VALUE - 1;
	private static final long MULT = Long.MAX_VALUE - 2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] line = sc.next().toCharArray();

		int size = 1 << (N / 2 + 1);
		long answer = Long.MIN_VALUE;
		for (int i = 1; i < size; i++) {
			ArrayList<Long> candidate = new ArrayList<>();
			boolean[] visited = new boolean[size];

			for (int j = 0, d = 1; j < size; j++, d <<= 1) {
				if ((i & d) == d) {
					if (j * 2 >= N || visited[j])
						continue;
					if ((j + 1) * 2 >= N || visited[j]) {
						candidate.add((long) (line[j * 2] - '0'));
						if (j * 2 + 1 < N)
							candidate.add(oper2int(line[j * 2 + 1]));
						continue;
					}

					long A = line[j * 2] - '0';
					long oper = oper2int(line[j * 2 + 1]);
					long B = line[(j + 1) * 2] - '0';
					visited[j] = true;
					visited[j + 1] = true;

					long result = calc(A, oper, B);
					candidate.add(result);
					if ((j + 1) * 2 + 1 < N)
						candidate.add(oper2int(line[(j + 1) * 2 + 1]));
				} else {
					if (j * 2 >= N || visited[j])
						continue;

					candidate.add((long) (line[j * 2] - '0'));
					if (j * 2 + 1 < N)
						candidate.add(oper2int(line[j * 2 + 1]));
				}
			}

			long result = calculate(candidate);
			answer = Math.max(answer, result);
		}

		System.out.print(answer);
	}

	private static long calculate(ArrayList<Long> array) {
		if (array.size() == 1)
			return array.get(0);

		long sum = calc(array.get(0), array.get(1), array.get(2));
		for (int i = 4; i < array.size(); i += 2)
			sum = calc(sum, array.get(i - 1), array.get(i));

		return sum;
	}

	private static long calc(long A, long oper, long B) {
		if (oper == PLUS)
			return A + B;
		else if (oper == MINUS)
			return A - B;
		else if (oper == MULT)
			return A * B;
		else
			throw new RuntimeException();
	}

	private static long oper2int(char oper) {
		switch (oper) {
		case '+':
			return PLUS;
		case '-':
			return MINUS;
		case '*':
			return MULT;
		default:
			return 0;
		}
	}
}