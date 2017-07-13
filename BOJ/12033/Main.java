/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.08
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12033
 */

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		for (int test = 1; test <= testCase; test++) {
			int n = input.nextInt() << 1;
			int[] table = new int[n];
			StringBuilder output = new StringBuilder(String.format("Case #%d:", test));
			ArrayList<Integer> answer = new ArrayList<Integer>();

			for (int i = 0; i < n; i++)
				table[i] = input.nextInt();

			for (int i = 0; i < n; i++) {
				if (table[i] == 0 || table[i] % 4 != 0)
					continue;

				int sale = table[i] - (table[i] >> 2);
				for (int j = 0; j < n; j++) {
					if (table[j] == sale) {
						answer.add(sale);
						table[j] = 0;
						table[i] = 0;
						break;
					}
				}
			}

			Collections.sort(answer);
			for (int number : answer)
				output.append(" ").append(number);

			System.out.println(output);
		}
	}
}