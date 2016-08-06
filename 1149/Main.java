/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.06
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1149
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numberOfHouse = input.nextInt();
		int[][] dp = new int[3][numberOfHouse];

		if (numberOfHouse > 0) {
			int firstR = input.nextInt();
			int firstG = input.nextInt();
			int firstB = input.nextInt();
			dp[0][0] = firstR;
			dp[1][0] = firstG;
			dp[2][0] = firstB;
		}

		for (int count = 1; count < numberOfHouse; count++) {
			int houseR = input.nextInt();
			int houseG = input.nextInt();
			int houseB = input.nextInt();
			dp[0][count] = Math.min(dp[1][count - 1], dp[2][count - 1]) + houseR;
			dp[1][count] = Math.min(dp[0][count - 1], dp[2][count - 1]) + houseG;
			dp[2][count] = Math.min(dp[0][count - 1], dp[1][count - 1]) + houseB;
		}

		System.out.println(Math.min(dp[0][numberOfHouse - 1], Math.min(dp[1][numberOfHouse - 1], dp[2][numberOfHouse - 1])));
	}
}