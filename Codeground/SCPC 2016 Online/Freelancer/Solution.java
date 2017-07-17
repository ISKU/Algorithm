/* 
 * Author: Minho Kim (ISKU)
 * Date: 2016.07.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.codeground.org/
 */

import java.util.Scanner;

public class Solution {

	private static Scanner input = new Scanner(System.in);
	private static int numberOfCase;
	private static int dp[][];

	public static void main(String args[]) {

		numberOfCase = input.nextInt();

		for (int count = 1; count <= numberOfCase; count++) {
			int N = input.nextInt();
			int currentMaxValue = 0;

			dp = new int[N + 1][2];
			int[] listP = new int[N];
			int[] listQ = new int[N];

			for (int i = 0; i < N; i++)
				listP[i] = input.nextInt();
			for (int i = 0; i < N; i++)
				listQ[i] = input.nextInt();

			dp[0][0] = listP[0];
			dp[0][1] = listQ[0];
			int tempMaxValue1 = Math.max(dp[0][0], dp[0][1]);
			if (currentMaxValue < tempMaxValue1)
				currentMaxValue = tempMaxValue1;

			if (N >= 2) {
				dp[1][0] = tempMaxValue1 + listP[1];
				dp[1][1] = listQ[1];
				int tempMaxValue2 = Math.max(dp[1][0], dp[1][1]);
				if (currentMaxValue < tempMaxValue2)
					currentMaxValue = tempMaxValue2;

				for (int i = 2; i < N; i++) {
					dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]) + listP[i];
					dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + listQ[i];
					int tempMaxValue3 = Math.max(dp[i][0], dp[i][1]);
					if (currentMaxValue < tempMaxValue3)
						currentMaxValue = tempMaxValue3;
				}
			}
			System.out.println("Case #" + count);
			System.out.println(currentMaxValue);
		}
	}
}