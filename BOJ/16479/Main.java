/*
 * Author: Minho Kim (ISKU)
 * Date: November 21, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16479
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double k = sc.nextDouble();
		double d1 = sc.nextDouble();
		double d2 = sc.nextDouble();
		System.out.printf("%.6f", (k * k) - ((d1 - d2) * (d1 - d2) / 4));
	}
}