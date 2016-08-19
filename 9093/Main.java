/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.19
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9093
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = Integer.parseInt(input.nextLine()); testCase > 0; testCase--) {
			String[] sentence = input.nextLine().split(" ");
			for (int index = 0; index < sentence.length; index++)
				System.out.print(new StringBuilder(sentence[index]).reverse().toString() + " ");
			System.out.println();
		}
	}
}