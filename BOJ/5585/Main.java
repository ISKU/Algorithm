/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.06
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5585
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int[] change = new int[] { 500, 100, 50, 10, 5, 1 };
		int money = 1000 - new Scanner(System.in).nextInt();

		int answer = 0;
		for (int i = 0; i < change.length; i++) {
			answer += money / change[i];
			money %= change[i];
		}

		System.out.print(answer);
	}
}