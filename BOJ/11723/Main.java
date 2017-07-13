/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11723
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Main {

	private static HashSet<Integer> ALLSET = new HashSet<Integer>();

	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer parser;
		HashSet<Integer> set = new HashSet<Integer>();

		for (int number = 1; number <= 20; number++)
			ALLSET.add(number);

		for (int testCase = Integer.parseInt(input.readLine()); testCase > 0; testCase--) {
			parser = new StringTokenizer(input.readLine());
			String command = parser.nextToken();
			int value = 0;
			if (parser.hasMoreTokens())
				value = Integer.parseInt(parser.nextToken());

			switch (command) {
			case "check":
				if (set.contains(value))
					output.append(1 + "\n");
				else
					output.append(0 + "\n");
				break;
			case "add":
				set.add(value);
				break;
			case "remove":
				if (!set.isEmpty())
					set.remove(value);
				break;
			case "toggle":
				if (set.contains(value))
					set.remove(value);
				else
					set.add(value);
				break;
			case "all":
				set = ALLSET;
				break;
			case "empty":
				set.clear();
				break;
			}
		}
		System.out.print(output);

	}
}