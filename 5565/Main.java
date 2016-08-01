/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.02
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5565
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int totalPrice = input.nextInt();

		for (int count = 0; count < 9; count++)
			totalPrice = totalPrice - input.nextInt();

		System.out.println(totalPrice);
	}
}