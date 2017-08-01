/* 
 * Author: Minho Kim (ISKU)
 * Date: 2016.10.01
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://icpckorea.org/2016/ONLINE/problem.pdf
 */

import java.util.*;

public class A {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int k = input.nextInt();
		int[] tree = new int[(int) Math.pow(2, k + 1) - 1];

		int sum = 0;
		for (int i = 1; i < tree.length; i++) {
			tree[i] = input.nextInt();
			sum += tree[i];
		}

		for (int i = tree.length - 1; i > 0; i -= 2) {
			int max = Math.max(tree[i], tree[i - 1]);
			int diff = Math.abs(tree[i] - tree[i - 1]);
			tree[(i - 1) / 2] += max;
			sum += diff;
		}

		System.out.println(sum);
	}
}