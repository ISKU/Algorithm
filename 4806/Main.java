/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.24
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4806
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;

		while (input.readLine() != null)
			sum++;

		System.out.print(sum);
	}
}