/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.11.23
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13900
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int[] table = new int[10001];
		int testCase = Integer.parseInt(parser.nextToken());

		parser = new StringTokenizer(input.readLine());
		while (testCase-- > 0)
			table[Integer.parseInt(parser.nextToken())]++;

		long sum = 0;
		for (long i = 0; i < table.length; i++) {
			if (table[(int) i] > 0) {
				for (long j = i + 1; j < table.length; j++) {
					if (table[(int) j] > 0)
						sum = sum + (i * table[(int) i] * j * table[(int) j]);
				}
				if (table[(int) i] > 1)
					sum = sum + ((i * i * table[(int) i] * (table[(int) i] - 1)) / 2);
			}
		}

		System.out.print(sum);
	}
}