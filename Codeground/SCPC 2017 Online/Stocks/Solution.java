/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.06.30
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.codeground.org/
 */

import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	public static void main(String... args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(input.readLine());

		for (int tCase = 1; tCase <= testCase; tCase++) {
			StringTokenizer parser = new StringTokenizer(input.readLine());
			int previous = Integer.parseInt(parser.nextToken());
			int answer = 0, ascending = 0;

			while (parser.hasMoreTokens()) {
				int current = Integer.parseInt(parser.nextToken());

				if (previous < current)
					ascending++;
				else {
					answer = (ascending > 0) ? answer + 1 : answer;
					ascending = 0;
				}

				previous = current;
			}

			output.write(String.format("Case #%d\n%d\n", tCase, ((ascending > 0) ? answer + 1 : answer) << 1));
		}

		output.close();
	}
}