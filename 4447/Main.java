/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.24
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4447
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int testCase = Integer.parseInt(input.readLine());

		while (testCase-- > 0) {
			String name = input.readLine();
			int g = 0;
			int b = 0;

			for (int index = 0, length = name.length(); index < length; index++) {
				char letter = name.charAt(index);
				if (letter == 'g' || letter == 'G')
					g++;
				else if (letter == 'b' || letter == 'B')
					b++;
			}

			if (g > b)
				output.append(name + " is GOOD\n");
			else if (g < b)
				output.append(name + " is A BADDY\n");
			else
				output.append(name + " is NEUTRAL\n");
		}

		System.out.print(output);
	}
}