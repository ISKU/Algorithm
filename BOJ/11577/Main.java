/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.10
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11577
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int K = input.nextInt();
		int[] bulb = new int[N];

		for (int i = 0; i < N; i++)
			bulb[i] = input.nextInt();

		int answer = 0;
		for (int i = 0; i <= N - K; i++)
			if (bulb[i] == 1) {
				for (int j = i; j < i + K; j++)
					bulb[j] = (bulb[j] == 1) ? 0 : 1;
				answer++;
			}

		boolean check = false;
		for (int i = 0; i < N; i++)
			if (bulb[i] != 0) {
				check = true;
				break;
			}

		System.out.print(check ? "Insomnia" : answer);
	}
}