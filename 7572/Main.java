/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/7572
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		int year = new Scanner(System.in).nextInt();
		int ten = ((year % 12 + 8) % 12) + 'A';
		int tentwo = ((year % 10 + 5) % 10) + 1;
		System.out.println((char) (ten) + "" + tentwo % 10);
	}
}