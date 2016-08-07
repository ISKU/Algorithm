/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.07
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5524
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		for (int count = Integer.parseInt(input.readLine()); count > 0; count--) {
			StringBuilder out = new StringBuilder();
			String[] words = input.readLine().split("");
			for (int index = 0; index < words.length; index++)
				out.append(words[index].toLowerCase());
			System.out.println(out);
		}
	}
}