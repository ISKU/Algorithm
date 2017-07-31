/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.30
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/834/B
 */

import java.util.*;

public class B {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int K = input.nextInt();
		char[] line = input.next().toCharArray();

		Door[] door = new Door[26];
		for (int i = 0; i < 26; i++)
			door[i] = new Door();

		for (int i = 0; i < line.length; i++) {
			if (door[line[i] % 65].start == -1)
				door[line[i] % 65].start = i;
			else
				door[line[i] % 65].end = i;
		}

		boolean[] check = new boolean[26];
		for (int i = 0; i < line.length; i++) {
			if (!check[line[i] % 65]) {
				if (K <= 0) {
					System.out.print("YES");
					System.exit(0);
				}

				check[line[i] % 65] = true;
				K--;
				if (door[line[i] % 65].end == -1)
					K++;
			} else {
				if (door[line[i] % 65].end == i)
					K++;
			}
		}

		System.out.print("NO");
	}

	private static class Door {
		public int start;
		public int end;

		public Door() {
			this.start = -1;
			this.end = -1;
		}
	}
}