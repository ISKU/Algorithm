/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.31
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/834/C
 */

import java.util.*;
import java.io.*;

public class C {
	public static void main(String... args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int testCase = Integer.parseInt(parser.nextToken());

		while (testCase-- > 0) {
			parser = new StringTokenizer(input.readLine());
			long first = Long.parseLong(parser.nextToken());
			long second = Long.parseLong(parser.nextToken());

			long N = (long) Math.cbrt(first * second);
			long x = first / N;
			long y = second / N;

			boolean answer = (x * x * y == first) && (y * y * x == second);
			output.write(answer ? "Yes\n" : "No\n");
		}

		output.close();
	}
}