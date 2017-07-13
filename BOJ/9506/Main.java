/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9506
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			int N = input.nextInt();
			if (N == -1)
				break;

			ArrayList<Integer> out = new ArrayList<Integer>();
			StringBuilder output = new StringBuilder("1");
			for (int i = 2; i <= N / 2; i++)
				if (N % i == 0) {
					out.add(i);
					output.append(" + " + i);
				}

			int sum = 1;
			for (int i = 0; i < out.size(); i++)
				sum += out.get(i);

			if (N == sum)
				System.out.println(N + " = " + output);
			else
				System.out.println(N + " is NOT perfect.");
		}
	}
}