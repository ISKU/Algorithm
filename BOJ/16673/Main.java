/*
 * Author: Minho Kim (ISKU)
 * Date: December 10, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16673
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int K = sc.nextInt();
		int P = sc.nextInt();

		long sum = 0;
		for (int i = 1; i < C; i++)
			sum += K * i + P * i * i;
		sum += K * C + P * C * C;

		System.out.print(sum);
	}
}