/*
 * Author: Minho Kim (ISKU)
 * Date: March 5, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/931/B
 */

import java.util.*;

public class B {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int H = (int) (Math.log(N) / Math.log(2));
		int A = sc.nextInt() + (1 << H) - 1;
		int B = sc.nextInt() + (1 << H) - 1;

		while (A != B) {
			A /= 2;
			B /= 2;
		}

		int R = (int) (Math.log(A) / Math.log(2));
		System.out.print((R == 0) ? "Final!" : H - R);
	}
}