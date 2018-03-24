/*
 * Author: Minho Kim (ISKU)
 * Date: March 23, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14915
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();

		StringBuilder answer = new StringBuilder((M == 0) ? "0" : "");
		while (M > 0) {
			answer.insert(0, Integer.toHexString(M % N).toUpperCase());
			M /= N;
		}

		System.out.print(answer);
	}
}