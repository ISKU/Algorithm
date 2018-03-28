/*
 * Author: Minho Kim (ISKU)
 * Date: March 28, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15595
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashMap<String, Info> map = new HashMap<>();
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			String user = st.nextToken();
			int state = Integer.parseInt(st.nextToken());

			if ("megalusion".equals(user))
				continue;
			if (!map.containsKey(user))
				map.put(user, new Info());

			if (state == 4)
				map.get(user).AC = true;
			if (state != 4 && !map.get(user).AC)
				map.get(user).WA++;
		}

		double ac = 0;
		double wa = 0;
		for (String key : map.keySet()) {
			if (map.get(key).AC) {
				ac++;
				wa += map.get(key).WA;
			}
		}

		System.out.printf("%.8f", (ac == 0) ? 0 : (ac / (ac + wa)) * 100);
	}

	private static class Info {
		public boolean AC = false;
		public int WA = 0;
	}
}