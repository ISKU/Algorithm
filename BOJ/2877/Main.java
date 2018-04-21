/*
 * Author: Minho Kim (ISKU)
 * Date: April 21, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2877
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int K = new Scanner(System.in).nextInt();

		String answer = "";
		while (K > 0) {
			answer = (K % 2 == 1 ? '4' : '7') + answer;
			K = (K - 1) / 2;
		}

		System.out.print(answer);
	}
}