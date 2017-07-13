/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.09
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1316
 */

import java.util.Scanner;
import java.util.HashSet;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int answer = N;

		while (N-- > 0) {
			char[] group = input.next().toCharArray();
			HashSet<Character> table = new HashSet<Character>();

			char prev = group[0];
			table.add(group[0]);
			for (int i = 1; i < group.length; i++) {
				if (prev != group[i] && table.contains(group[i])) {
					answer--;
					break;
				}

				prev = group[i];
				table.add(group[i]);
			}
		}

		System.out.print(answer);
	}
}