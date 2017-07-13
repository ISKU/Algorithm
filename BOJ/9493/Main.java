/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9493
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			int M = input.nextInt();
			int A = input.nextInt();
			int B = input.nextInt();

			if (M == 0 && A == 0 && B == 0)
				break;

			double sA = M / (A / 3600.0);
			double sB = M / (B / 3600.0);
			int dist = (int) Math.round(Math.abs(sA - sB));

			System.out.print(dist / 3600 + ":");
			dist = dist % 3600;
			System.out.print((dist / 60) <= 9 ? "0" + (dist / 60) + ":" : (dist / 60) + ":");
			System.out.println((dist % 60) <= 9 ? "0" + (dist % 60) : dist % 60);
		}
	}
}