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
			input.readLine();
			StringTokenizer parser = new StringTokenizer(input.readLine());

			int number = Integer.parseInt(parser.nextToken());
			while (parser.hasMoreTokens())
				number ^= Integer.parseInt(parser.nextToken());

			output.write(String.format("Case #%d\n%d\n", tCase, number));
		}

		output.close();
	}
}