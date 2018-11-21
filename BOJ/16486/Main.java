/*
 * Author: Minho Kim (ISKU)
 * Date: November 21, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16486
 */

import java.util.*;

public class Main {

	private static final double PI = 3.141592;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double d1 = sc.nextDouble();
		double d2 = sc.nextDouble();
		System.out.printf("%.6f", (2 * d1) + (2 * d2 * PI));
	}
}