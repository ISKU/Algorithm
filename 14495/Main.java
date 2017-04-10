/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.10
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14495
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String... args) {
		int n = new Scanner(System.in).nextInt();
		long[] fibo = new long[117];

		Arrays.fill(fibo, 1, 4, 1);
		for (int i = 4; i <= 116; i++)
			fibo[i] = fibo[i - 1] + fibo[i - 3];

		System.out.print(fibo[n]);
	}
}
