/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.11
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12780
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		String H = input.nextLine();
		String N = input.nextLine();
		int count = 0;

		while (H.contains(N)) {
			H = H.replaceFirst(N, "");
			count++;
		}

		System.out.println(count);
	}
}