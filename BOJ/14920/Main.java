/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.12.18
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14920
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int n = new Scanner(System.in).nextInt();

		int answer = 1;
		while (n != 1) {
			n = ((n & 1) == 1) ? (3 * n + 1) : n / 2;
			answer++;
		}

		System.out.print(answer);
	}
}