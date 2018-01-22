/*
 * Author: Minho Kim (ISKU)
 * Date: January 23, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1267
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int Y = 0, M = 0;
		for (int i = 0; i < N; i++) {
			int time = sc.nextInt();
			Y += (time % 30 >= 0) ? (time / 30) * 10 + 10 : (time / 30) * 10;
			M += (time % 60 >= 0) ? (time / 60) * 15 + 15 : (time / 60) * 15;
		}

		if (Y < M)
			System.out.print("Y " + Y);
		else if (Y > M)
			System.out.print("M " + M);
		else
			System.out.printf("Y M %d", Y);
	}
}