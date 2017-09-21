/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.09.17
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14720
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		int pointer = 0;
		int answer = 0;
		while (N-- > 0) {
			if (pointer == input.nextInt()) {
				answer++;
				pointer = (pointer + 1) % 3;
			}
		}

		System.out.print(answer);
	}
}