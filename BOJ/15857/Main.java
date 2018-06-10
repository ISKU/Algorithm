/*
 * Author: Minho Kim (ISKU)
 * Date: June 10, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15857
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		System.out.print(solution(new Scanner(System.in).nextInt()));
	}

	private static char solution(int i) {
		switch (i) {
		case 1:
			return 'a';
		case 2:
			return 'b';
		case 3:
			return 'b';
		case 4:
			return 'c';
		case 5:
			return 'd';
		case 6:
			return 'd';
		case 7:
			return 'd';
		default:
			return 'c';
		}
	}
}