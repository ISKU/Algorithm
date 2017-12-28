/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.12.28
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14593
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		User[] users = new User[input.nextInt()];

		for (int i = 0; i < users.length; i++)
			users[i] = new User(i + 1, input.nextInt(), input.nextInt(), input.nextInt());

		Arrays.sort(users);
		System.out.println(users[0].index);
	}

	private static class User implements Comparable<User> {
		public int index;
		public int s;
		public int c;
		public int l;

		public User(int index, int s, int c, int l) {
			this.index = index;
			this.s = s;
			this.c = c;
			this.l = l;
		}

		@Override
		public int compareTo(User o) {
			if (this.s != o.s)
				return o.s - this.s;
			else {
				if (this.c != o.c)
					return this.c - o.c;
				else
					return this.l - o.l;
			}
		}
	}
}