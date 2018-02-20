/*
 * Author: Minho Kim (ISKU)
 * Date: February 20, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15551
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();

		StringBuilder a = new StringBuilder("aa");
		StringBuilder b = new StringBuilder("bB");
		for (int i = 2; i < N; i++) {
			a.append("a");
			b.insert(0, "a");
		}

		System.out.println(a);
		System.out.println(b);
	}
}