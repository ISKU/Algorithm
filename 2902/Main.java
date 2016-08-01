/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.01
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2902
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String[] longVariation = input.next().split("-");

		for (int index = 0; index < longVariation.length; index++)
			System.out.print(longVariation[index].charAt(0)); // short variation
	}
}