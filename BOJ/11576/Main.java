/*
 * Author: Minho Kim (ISKU)
 * Date: January 28, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11576
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int N = sc.nextInt();

		int sum = 0;
		for (int i = N - 1; i >= 0; i--)
			sum += sc.nextInt() * (int) Math.pow(A, i);

		ArrayList<Integer> answer = new ArrayList<Integer>();
		while (sum > 0) {
			answer.add(sum % B);
			sum /= B;
		}

		for (int i = answer.size() - 1; i >= 0; i--)
			System.out.printf("%d ", answer.get(i));
	}
}