/*
 * Author: Minho Kim (ISKU)
 * Date: January 17, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1032
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		char[] answer = sc.next().toCharArray();
		while (N-- > 1) {
			char[] line = sc.next().toCharArray();
			for (int i = 0; i < line.length; i++)
				if (answer[i] != line[i])
					answer[i] = '?';
		}

		System.out.print(answer);
	}
}