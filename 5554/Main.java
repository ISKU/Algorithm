/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5554
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int time = input.nextInt() + input.nextInt() + input.nextInt() + input.nextInt();
		System.out.println((time / 60) + "\n" + (time % 60));
	}
}