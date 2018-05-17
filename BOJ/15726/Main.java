/*
 * Author: Minho Kim (ISKU)
 * Date: May 16, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15726
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		double A = sc.nextLong();
		double B = sc.nextLong();
		double C = sc.nextLong();

		System.out.print((long) Math.max(A * B / C, A / B * C));
	}
}