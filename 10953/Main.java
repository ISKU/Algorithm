/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.29
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10953
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		for (int testCase = input.nextInt(); testCase > 0; testCase--) {
			String[] operand = (input.next()).split(",");
			System.out.println(Integer.parseInt(operand[0]) + Integer.parseInt(operand[1]));
		}
	}
}