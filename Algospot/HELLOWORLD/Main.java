/*
 * Author: Minho Kim (ISKU)
 * Date: January 24, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://algospot.com/judge/problem/read/HELLOWORLD
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();

		while (C-- > 0)
			System.out.printf("Hello, %s!\n", sc.next());
	}
}