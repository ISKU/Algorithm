/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.11
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1547
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		boolean[] cup = new boolean[] { false, true, false, false };

		int testCase = input.nextInt();
		while (testCase-- > 0) {
			int first = input.nextInt();
			int second = input.nextInt();

			boolean temp = cup[first];
			cup[first] = cup[second];
			cup[second] = temp;
		}

		System.out.print(cup[1] ? 1 : cup[2] ? 2 : cup[3] ? 3 : 0);
	}
}