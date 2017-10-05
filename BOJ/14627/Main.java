/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.10.06
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14627
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int S = Integer.parseInt(parser.nextToken());
		int C = Integer.parseInt(parser.nextToken());

		long front = 0;
		long rear = 0;
		long[] onions = new long[S];

		for (int i = 0; i < S; i++) {
			onions[i] = Long.parseLong(input.readLine());
			rear += onions[i];
		}

		while (front + 1 < rear) {
			int count = 0;
			long mid = (front + rear) / 2;

			for (long l : onions)
				count += l / mid;

			if (count >= C)
				front = mid;
			else
				rear = mid;
		}

		long answer = 0;
		for (long l : onions) {
			if (l / front < C) {
				C -= l / front;
				answer += l % front;
			} else
				answer += l - (front * C);
		}

		System.out.print(answer);
	}
}