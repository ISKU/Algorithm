/*
 * Author: Minho Kim (ISKU)
 * Date: September 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://programmers.co.kr/learn/courses/30/lessons/42890
 */

import java.util.*;

class Solution {
	public int solution(String[][] relation) {
		int Y = relation.length;
		int X = relation[0].length;
		int N = 1 << relation[0].length;

		ArrayList<Integer> candidate = new ArrayList<>();
		for (int i = 1; i < N; i++) {
			Set<String> set = new HashSet<>();
			boolean unique = true;

			for (int y = 0; y < Y; y++) {
				String key = "";

				for (int x = 0; x < X; x++)
					if ((i & (1 << x)) > 0)
						key += relation[y][x];

				if (set.contains(key)) {
					unique = false;
					break;
				}
				set.add(key);
			}

			if (unique) {
				boolean check = true;
				for (int j = 0; j < candidate.size(); j++)
					if ((candidate.get(j) & i) == candidate.get(j))
						check = false;

				if (check)
					candidate.add(i);
			}
		}

		return candidate.size();
	}
}