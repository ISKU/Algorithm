/*
 * Author: Minho Kim (ISKU)
 * Date: March 31, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15639
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		System.out.print(check(new Scanner(System.in).nextLine()));
	}

	private static String check(String line) {
		switch (line) {
		case "Give you up":
		case "Let you down":
		case "Run around and desert you":
		case "Make you cry":
		case "Say goodbye":
		case "Tell a lie and hurt you":
			return "NO";
		default:
			return "YES";
		}
	}
}