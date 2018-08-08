/*
 * Author: Minho Kim (ISKU)
 * Date: August 8, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1057
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();

		int H = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));
		int h = (int) (Math.log(H) / Math.log(2));
		boolean[] tree = new boolean[H * 2];
		tree[H + A - 1] = true;
		tree[H + B - 1] = true;

		for (int i = H - 1; i >= 1; i--) {
			if (tree[i * 2] && tree[i * 2 + 1]) {
				int ch = (int) (Math.log(i) / Math.log(2));
				System.out.print(h - ch);
				System.exit(0);
			}

			tree[i] = tree[i * 2] | tree[i * 2 + 1];
		}

		System.out.print(-1);
	}
}