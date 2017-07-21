/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.21
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.codeground.org/
 */

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String... args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(input.readLine());

		for (int tCase = 1; tCase <= testCase; tCase++) {
			StringTokenizer parser = new StringTokenizer(input.readLine());
			int[] score = new int[Integer.parseInt(parser.nextToken())];
			int K = Integer.parseInt(parser.nextToken());

			parser = new StringTokenizer(input.readLine());
			for (int i = 0; i < score.length; i++)
				score[i] = Integer.parseInt(parser.nextToken());

			Arrays.sort(score);
			int answer = 0;
			for (int i = score.length - 1; K > 0; K--, i--)
				answer += score[i];

			output.write(String.format("Case #%d\n%d\n", tCase, answer));
		}

		output.close();
	}
}