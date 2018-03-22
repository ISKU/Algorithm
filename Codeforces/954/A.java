/*
 * Author: Minho Kim (ISKU)
 * Date: March 22, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/954/A
 */

import java.util.*;

public class A {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] line = sc.next().toCharArray();

		for (int i = 0; i < line.length - 1; i++) {
			if ((line[i] == 'U' && line[i + 1] == 'R') || line[i] == 'R' && line[i + 1] == 'U') {
				line[i] = line[i + 1] = 'D';
				N--;
			}
		}

		System.out.print(N);
	}
}