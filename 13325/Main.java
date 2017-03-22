/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.23
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13325
 */

import java.util.Scanner;

public class Main {

	private static int[] tree;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int sum = 0;
		tree = new int[(1 << (input.nextInt() + 1)) - 1];

		for (int i = 1; i < tree.length; i++)
			tree[i] = input.nextInt();

		find(0);

		for (int i = 0; i < tree.length; i++)
			sum += tree[i];

		System.out.print(sum);
	}

	private static int find(int index) {
		int left = 2 * index + 1;
		int right = 2 * index + 2;

		if (left > tree.length || right > tree.length)
			return tree[index];

		int leftSum = find(left);
		int rightSum = find(right);

		if (leftSum < rightSum)
			tree[left] += rightSum - leftSum;
		else
			tree[right] += leftSum - rightSum;

		return tree[index] + Math.max(leftSum, rightSum);
	}
}