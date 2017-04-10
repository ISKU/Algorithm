/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.10
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14491
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		int T = new Scanner(System.in).nextInt();
		StringBuilder output = new StringBuilder();

		while (T > 0) {
			output.insert(0, T % 9);
			T /= 9;
		}

		System.out.print(Integer.parseInt(output.toString()));
	}
}
