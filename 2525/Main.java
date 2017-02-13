/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2525
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int time = input.nextInt() * 60 + input.nextInt() + input.nextInt();
		System.out.print(((time / 60) % 24) + " ");
		System.out.print(time % 60);
	}
}