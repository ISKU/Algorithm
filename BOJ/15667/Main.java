/*
 * Author: Minho Kim (ISKU)
 * Date: April 28, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15667
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();

		for (int k = 1; k <= N; k++) {
			if (k * (k + 1) == N - 1) {
				System.out.print(k);
				break;
			}
		}
	}
}