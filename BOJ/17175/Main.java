/*
 * Author: Minho Kim (ISKU)
 * Date: May 4, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17175
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] fibo = new int[51];
		fibo[0] = 1;
		fibo[1] = 1;
		for (int i = 2; i <= N; i++)
			fibo[i] = (fibo[i - 1] + fibo[i - 2] + 1) % 1000000007;

		System.out.println(fibo[N]);
	}
}