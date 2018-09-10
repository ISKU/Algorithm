/*
 * Author: Minho Kim (ISKU)
 * Date: September 9, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16120
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		String line = new Scanner(System.in).next();
		int N = line.length();

		ArrayList<Character> stack = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			stack.add(line.charAt(i));

			if (stack.size() >= 4) {
				int n = stack.size();
				if (stack.get(n - 4) == 'P' && stack.get(n - 3) == 'P' && stack.get(n - 2) == 'A' && stack.get(n - 1) == 'P') {
					stack.remove(n - 1);
					stack.remove(n - 2);
					stack.remove(n - 3);
				}
			}
		}

		System.out.print((stack.size() == 1 && stack.get(0) == 'P') ? "PPAP" : "NP");
	}
}