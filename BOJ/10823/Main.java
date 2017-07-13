
/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.24
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10823
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder number = new StringBuilder();
		String line = null;
		long sum = 0;

		while ((line = input.readLine()) != null) {
			for (int index = 0, length = line.length(); index < length; index++)
				if (line.charAt(index) == ',') {
					sum += Integer.parseInt(number.toString());
					number = new StringBuilder();
				} else
					number.append(line.charAt(index));
		}

		System.out.print((sum + Integer.parseInt(number.toString())));
	}
}