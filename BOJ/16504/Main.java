/*
 * Author: Minho Kim (ISKU)
 * Date: November 17, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16504
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		long sum = 0;
		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++)
				sum += sc.nextLong();

		System.out.print(sum);
	}
}