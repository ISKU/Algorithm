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
			int[] score = new int[Integer.parseInt(input.readLine())];
			for (int i = 0; i < score.length; i++)
				score[i] = Integer.parseInt(input.readLine());

			Arrays.sort(score);
			int maxScore = 0;
			for (int i = 0; i < score.length; i++)
				maxScore = Math.max(maxScore, score[i] + score.length - i);

			int answer = 0;
			for (int i = 0; i < score.length; i++)
				if (score[i] >= maxScore - score.length)
					answer++;

			output.write(String.format("Case #%d\n%d\n", tCase, answer));
		}

		output.close();
	}
}