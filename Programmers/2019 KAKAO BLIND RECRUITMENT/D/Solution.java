/*
 * Author: Minho Kim (ISKU)
 * Date: September 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://programmers.co.kr/learn/courses/30/lessons/42891
 */

import java.util.*;

class Solution {
	public int solution(int[] food_times, long k) {
		int N = food_times.length;

		long[] foods = new long[N + 1];
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			foods[i] = food_times[i - 1];
			sum += foods[i];
		}
		if (k >= sum)
			return -1;

		Arrays.sort(foods);
		long count = N;
		for (int i = 1; i <= N; i++, count--) {
			long remain = foods[i] - foods[i - 1];
			if (remain * count <= k) {
				k -= remain * count;
				continue;
			}

			k %= count;
			for (int j = 0; j < N; j++) {
				if (food_times[j] <= foods[i - 1])
					continue;
				if (k == 0)
					return j + 1;
				k--;
			}
		}

		return -1;
	}
}