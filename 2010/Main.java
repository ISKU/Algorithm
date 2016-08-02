/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.02
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2010
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int totalNumberOfPlug = 0;

		for (int count = input.nextInt(); count > 1; count--)
			totalNumberOfPlug += input.nextInt() - 1;

		System.out.println(totalNumberOfPlug + input.nextInt());
	}
}