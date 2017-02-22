/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11050
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		System.out.print(combination(input.nextInt(), input.nextInt()));
	}

	private static int combination(int n, int k) {
		int result = 1;
		for (int i = 0; i < k; i++)
			result = result * (n - i) / (i + 1);
		return result;
	}
}