/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.11
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5532
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int L = input.nextInt();
		int A = input.nextInt();
		int B = input.nextInt();
		int C = input.nextInt();
		int D = input.nextInt();

		int i = 0;
		int sum = 0;
		for (; sum < A; i++)
			sum += C;

		int j = 0;
		for (sum = 0; sum < B; j++)
			sum += D;

		System.out.print((L - Math.max(i, j)));
	}
}