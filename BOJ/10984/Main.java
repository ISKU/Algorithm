/*
 * Author: Minho Kim (ISKU)
 * Date: January 10, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10984
 */

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		while (tc-- > 0) {
			int N = sc.nextInt();
			int credit = 0;
			double grade = 0;

			for (int i = 0; i < N; i++) {
				int temp = sc.nextInt();
				credit += temp;
				grade += temp * sc.nextFloat();
			}

			System.out.printf("%d %.1f\n", credit, grade / credit);
		}
	}
}
