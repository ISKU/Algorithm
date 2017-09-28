/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.09.28
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14656
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		int answer = 0;
		for (int i = 1; i <= N; i++)
			if (i != input.nextInt())
				answer++;

		System.out.print(answer);
	}
}