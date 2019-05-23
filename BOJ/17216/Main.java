/*
 * Author: Minho Kim (ISKU)
 * Date: May 22, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17216
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] array = new int[N];
		int[] dp = new int[N];
		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			dp[i] = array[i];
			for (int j = 0; j < i; j++)
				if (array[i] < array[j] && dp[i] < dp[j] + array[i])
					dp[i] = dp[j] + array[i];
		}

		int max = 0;
		for (int i = 0; i < array.length; i++)
			max = Math.max(max, dp[i]);
		System.out.print(max);
	}
}