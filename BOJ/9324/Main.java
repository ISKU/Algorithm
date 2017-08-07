/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.08
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9324
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int[] count = new int[26];
			char[] msg = input.next().toCharArray();

			boolean answer = true;
			for (int i = 0; i < msg.length; i++) {
				count[msg[i] % 65]++;
				
				if (count[msg[i] % 65] % 3 == 0) {
					if (i + 1 < msg.length && msg[i + 1] != msg[i])
						answer = false;
					if (i + 1 >= msg.length)
						answer = false;
					if (i + 1 < msg.length && msg[i + 1] == msg[i])
						i++;
				}
			}

			System.out.println(answer ? "OK" : "FAKE");
		}
	}
}