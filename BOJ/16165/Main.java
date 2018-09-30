/*
 * Author: Minho Kim (ISKU)
 * Date: September 29, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16165
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		Map<String, List<String>> teams = new HashMap<>();
		Map<String, String> names = new HashMap<>();
		while (N-- > 0) {
			String team = sc.next();
			int n = sc.nextInt();

			List<String> member = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				String name = sc.next();
				member.add(name);
				names.put(name, team);
			}

			Collections.sort(member);
			teams.put(team, member);
		}

		while (M-- > 0) {
			String arg = sc.next();
			int cmd = sc.nextInt();

			if (cmd == 0)
				for (String name : teams.get(arg))
					System.out.println(name);

			if (cmd == 1)
				System.out.println(names.get(arg));
		}
	}
}