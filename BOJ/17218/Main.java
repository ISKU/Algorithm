/*
 * Author: Minho Kim (ISKU)
 * Date: May 24, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17218
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();

		int[][] dp = new int[A.length + 1][B.length + 1];
		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= B.length; j++) {
				if (A[i - 1] == B[j - 1])
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		List<Character> answer = new ArrayList<>();
		for (int i = A.length, j = B.length; dp[i][j] != 0;) {
			if (dp[i - 1][j] == dp[i][j])
				i--;
			else if (dp[i][j - 1] == dp[i][j])
				j--;
			else if (dp[i - 1][j - 1] + 1 == dp[i][j]) {
				answer.add(A[i - 1]);
				i--;
				j--;
			}
		}

		for (int i = answer.size() - 1; i >= 0; i--)
			System.out.print(answer.get(i));
	}
}