/*
 * Author: Minho Kim (ISKU)
 * Date: March 5, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/931/A
 */

import java.util.*;

public class A {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int first = sc.nextInt();
		int second = sc.nextInt();

		if (first > second) {
			int temp = second;
			second = first;
			first = temp;
		}

		int i = 1, j = 1;
		int sum = 0;
		while (true) {
			first++;
			sum += i++;
			if (first == second)
				break;

			second--;
			sum += j++;
			if (first == second)
				break;
		}

		System.out.print(sum);
	}
}