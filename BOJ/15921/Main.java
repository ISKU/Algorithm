/*
 * Author: Minho Kim (ISKU)
 * Date: August 8, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15921
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		double N = sc.nextDouble();
		if (N == 0)
			exit();

		HashMap<Integer, Integer> map = new HashMap<>();
		double avg = 0;
		for (int i = 0; i < N; i++) {
			int score = sc.nextInt();
			avg += score;
			map.put(score, map.containsKey(score) ? map.get(score) + 1 : 1);
		}

		double exp = 0;
		for (int score : map.keySet())
			exp += score * (map.get(score) / N);

		avg /= N;
		System.out.printf("%.2f", avg / exp);
	}

	private static void exit() {
		System.out.print("divide by zero");
		System.exit(0);
	}
}