/*
 * Author: Minho Kim (ISKU)
 * Date: March 3, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1094
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int X = new Scanner(System.in).nextInt();
		int[] stick = new int[] { 64, 32, 16, 8, 4, 2, 1 };

		int sum = 0;
		int answer = 0;
		for (int n : stick) {
			int count = X / n;
			answer += count;
			X -= n * count;

			if (X == 0)
				break;
		}

		System.out.print(answer);
	}
}