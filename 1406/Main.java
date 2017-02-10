/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.10
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1406
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String... args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder string = new StringBuilder(input.readLine());
		int inst = Integer.parseInt(input.readLine());
		int pointer = string.length();

		while (inst-- > 0) {
			StringTokenizer parser = new StringTokenizer(input.readLine());
			String command = parser.nextToken();

			if (command.equals("L"))
				pointer = (pointer == 0) ? 0 : pointer - 1;
			else if (command.equals("D"))
				pointer = (pointer == string.length()) ? string.length() : pointer + 1;
			else if (command.equals("B")) {
				if (pointer != 0) {
					string.replace(pointer - 1, pointer, "");
					pointer -= 1;
				}
			} else if (command.equals("P")) {
				string.insert(pointer, parser.nextToken());
				pointer += 1;
			}
		}

		System.out.println(string);
	}
}