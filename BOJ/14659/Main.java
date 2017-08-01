/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.01
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14659
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		int answer = 0, desc = 0;
		int arc = input.nextInt();
		while (N-- > 1) {
			int number = input.nextInt();

			if (arc > number)
				desc++;
			else {
				arc = number;
				desc = 0;
			}

			answer = Math.max(answer, desc);
		}

		System.out.print(answer);
	}
}