/*
 * Author: Minho Kim (ISKU)
 * Date: September 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://programmers.co.kr/learn/courses/30/lessons/42889
 */

import java.util.*;

class Solution {
	public int[] solution(int N, int[] stages) {
		int[] count = new int[N + 2];
		for (int i = 0; i < stages.length; i++)
			count[stages[i]]++;

		double n = stages.length;
		Failure[] failures = new Failure[N + 1];
		for (int i = 1; i <= N; i++) {
			double rate = (n == 0) ? 0 : count[i] / n;
			failures[i] = new Failure(i, rate);
			n -= count[i];
		}
		Arrays.sort(failures, 1, N + 1, new Comparator<Failure>() {
			@Override
			public int compare(Failure o1, Failure o2) {
				if (o1.rate == o2.rate)
					return Integer.compare(o1.stage, o2.stage);
				return Double.compare(o2.rate, o1.rate);
			}
		});

		int[] answer = new int[N];
		for (int i = 1; i <= N; i++)
			answer[i - 1] = failures[i].stage;
		return answer;
	}

	private class Failure {
		public int stage;
		public double rate;

		public Failure(int stage, double rate) {
			this.stage = stage;
			this.rate = rate;
		}
	}
}