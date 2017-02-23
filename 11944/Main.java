/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11944
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		StringBuilder output = new StringBuilder();
		int N = input.nextInt();
		int size = input.nextInt();

		for (int i = 0; i < N; i++)
			output.append(N);

		if (output.length() > size) {
			for (int i = 0; i < size; i++)
				System.out.print(output.charAt(i));
		} else
			System.out.print(output);
	}
}