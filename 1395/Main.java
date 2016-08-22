/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.22
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1395
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int numberOfSwitchs = Integer.parseInt(parser.nextToken());
		int work = Integer.parseInt(parser.nextToken());
		int[] arraySwitch = new int[numberOfSwitchs + 1];

		for (int count = 0; count < work; count++) {
			parser = new StringTokenizer(input.readLine());
			String task = parser.nextToken();
			int startIndex = Integer.parseInt(parser.nextToken());
			int endIndex = Integer.parseInt(parser.nextToken());

			if (task.equals("0")) {
				for (int index = startIndex; index <= endIndex; index++)
					arraySwitch[index]++;
			} else {
				int OnStateSwitchs = 0;
				for (int index = startIndex; index <= endIndex; index++)
					OnStateSwitchs += arraySwitch[index] & 1;
				output.append(OnStateSwitchs + "\n");
			}
		}

		System.out.print(output);
	}
}