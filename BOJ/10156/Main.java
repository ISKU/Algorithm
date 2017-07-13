/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.22
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10156
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int totalPrice = input.nextInt() * input.nextInt();
		int current = input.nextInt();
		System.out.print(totalPrice > current ? totalPrice - current : 0);
	}
}