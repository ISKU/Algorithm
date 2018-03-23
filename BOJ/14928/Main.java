/*
 * Author: Minho Kim (ISKU)
 * Date: March 23, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14928
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		char[] N = new Scanner(System.in).next().toCharArray();

		int remainder = 0;
		for (int i = 0; i < N.length && N[i] != 0; i++)
			remainder = (remainder * 10 + N[i] - '0') % 20000303;

		System.out.print(remainder);
	}
}