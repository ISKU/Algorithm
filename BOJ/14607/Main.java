/*
 * Author: Minho Kim (ISKU)
 * Date: January 18, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14607
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		long N = new Scanner(System.in).nextLong();
		System.out.print(N * (N - 1) / 2);
	}
}