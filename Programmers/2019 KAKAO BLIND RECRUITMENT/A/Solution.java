/*
 * Author: Minho Kim (ISKU)
 * Date: September 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 */

import java.util.*;

class Solution {
	public String[] solution(String[] record) {
		HashMap<String, String> map = new HashMap<>();

		int N = 0;
		for (int i = 0; i < record.length; i++) {
			StringTokenizer st = new StringTokenizer(record[i]);
			String command = st.nextToken();

			if ("Enter".equals(command)) {
				map.put(st.nextToken(), st.nextToken());
				N++;
			} else if ("Change".equals(command))
				map.put(st.nextToken(), st.nextToken());
			else if ("Leave".equals(command))
				N++;
		}

		String[] answer = new String[N];
		for (int i = 0, n = 0; i < record.length; i++) {
			StringTokenizer st = new StringTokenizer(record[i]);
			String command = st.nextToken();

			if ("Enter".equals(command))
				answer[n++] = map.get(st.nextToken()) + "님이 들어왔습니다.";
			else if ("Leave".equals(command))
				answer[n++] = map.get(st.nextToken()) + "님이 나갔습니다.";
		}

		return answer;
	}
}