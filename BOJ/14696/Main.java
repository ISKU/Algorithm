/*
 * Author: Minho Kim (ISKU)
 * Date: March 25, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14696
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		while (N-- > 0) {
			int a = sc.nextInt();
			int[] A = new int[5];
			while (a-- > 0)
				A[sc.nextInt()]++;

			int b = sc.nextInt();
			int[] B = new int[5];
			while (b-- > 0)
				B[sc.nextInt()]++;

			for (int i = 4; i >= 1; i--) {
				if (A[i] == B[i]) {
					if (i == 1)
						System.out.println("D");
					continue;
				}

				System.out.println((A[i] > B[i]) ? "A" : "B");
				break;
			}
		}
	}
}