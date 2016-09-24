/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5523
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int testCase = Integer.parseInt(parser.nextToken());
		int[] wins = new int[2];

		while (testCase-- > 0) {
			parser = new StringTokenizer(input.readLine());
			int A = Integer.parseInt(parser.nextToken());
			int B = Integer.parseInt(parser.nextToken());

			if (A > B)
				wins[0]++;
			else if (A < B)
				wins[1]++;
		}

		System.out.print(wins[0] + " " + wins[1]);
	}
}