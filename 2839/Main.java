/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.28
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2839
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();
		int count = 0, temp = N;

		for (; N > 4; N -= 5, count++);
		for (; (temp > N) && (N % 3 != 0); N += 5, count--);
		for (; N > 0; N -= 3, count++);
		System.out.print(N == 0 ? count : -1);
	}
}