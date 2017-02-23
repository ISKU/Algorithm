/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11034
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (input.hasNext()) {
			int first = input.nextInt();
			int second = input.nextInt();
			int third = input.nextInt();
			System.out.println(Math.max(second - first, third - second) - 1);
		}
	}
}