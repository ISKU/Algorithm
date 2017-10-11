/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.04.22
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14804
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		for (int tc = 1; tc <= testCase; tc++) {
			double D = input.nextDouble();
			int N = input.nextInt();

			double max = 0;
			for (int i = 0; i < N; i++)
				max = Math.max(max, (D - input.nextDouble()) / input.nextDouble());

			System.out.printf("Case #%d: %.6f\n", tc, D / max);
		}
	}
}