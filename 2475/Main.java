/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.26
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2475
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int validate = 0;
		for (int index = 1; index <= 5; index++)
			validate += Math.pow(input.nextInt(), 2);
		System.out.println(validate % 10);
	}
}