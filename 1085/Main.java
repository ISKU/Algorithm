/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.31
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1085
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int currentX = input.nextInt();
		int currentY = input.nextInt();
		int cornerX = input.nextInt();
		int cornerY = input.nextInt();
		System.out.println(
				Math.min(Math.min(currentX - 0, cornerX - currentX), Math.min(currentY - 0, cornerY - currentY)));
	}
}