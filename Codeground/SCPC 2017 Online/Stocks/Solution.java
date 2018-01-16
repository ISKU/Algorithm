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

public class Solution {
	public static void main(String... args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(input.readLine());

		for (int tCase = 1; tCase <= testCase; tCase++) {
			Integer.parseInt(input.readLine());
			StringTokenizer parser = new StringTokenizer(input.readLine());
			int prev = Integer.parseInt(parser.nextToken());
			int answer = 0, asc = 0;

			while (parser.hasMoreTokens()) {
				int cur = Integer.parseInt(parser.nextToken());

				if (prev < cur)
					asc++;
				else {
					answer = (asc > 0) ? answer + 1 : answer;
					asc = 0;
				}

				prev = cur;
			}

			output.write(String.format("Case #%d\n%d\n", tCase, ((asc > 0) ? answer + 1 : answer) * 2));
		}

		output.close();
	}
}
