/*
 * Author: Minho Kim (ISKU)
 * Date: May 4, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17177
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		double e = Math.sqrt((a * a) - (b * b));
		double f = Math.sqrt((a * a) - (c * c));

		// ad + bc = ef, d = (ef - bc) / a
		double d = ((e * f) - (b * c)) / a;
		System.out.printf("%.0f\n", (d <= 0) ? -1 : d);
	}
}