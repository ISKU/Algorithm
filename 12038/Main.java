/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.08
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12038
 */

import java.util.Scanner;

public class Main {

	public static final long MODULAR = 1000000007;
	public static long[][] table;
	public static int C, V, L;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		for (int tCase = 1; tCase <= testCase; tCase++) {
			C = input.nextInt();
			V = input.nextInt();
			L = input.nextInt();

			table = new long[2][L];
			for (int i = 0; i < L; i++) {
				table[0][i] = -1;
				table[1][i] = -1;
			}

			System.out.printf("Case #%d: %d\n", tCase, find(0, 0));
		}
	}

	public static long find(int index, int cur) {
		if (cur == L)
			return (index == 1) ? 0 : 1;
		if (table[index][cur] != -1)
			return table[index][cur];

		long ans = 0;
		ans = (ans + find(0, cur + 1) * V) % MODULAR;
		if (index != 1)
			ans = (ans + (find(1, cur + 1) * C)) % MODULAR;

		table[index][cur] = ans;
		return ans;
	}
}