/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2864
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		String first = input.next();
		String second = input.next();

		System.out.printf("%d %d", 
				Integer.parseInt(first.replaceAll("6", "5")) + Integer.parseInt(second.replaceAll("6", "5")),
				Integer.parseInt(first.replaceAll("5", "6")) + Integer.parseInt(second.replaceAll("5", "6")));
	}
}