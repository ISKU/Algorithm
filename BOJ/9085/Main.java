/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.01
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9085
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = input.nextInt(); testCase > 0; testCase--) {
			int sumOfNaturalNumbers = 0;
			for (int numberOfNaturalNumbers = input.nextInt(); numberOfNaturalNumbers > 0; numberOfNaturalNumbers--)
				sumOfNaturalNumbers = sumOfNaturalNumbers + input.nextInt();
			System.out.println(sumOfNaturalNumbers);
		}
	}
}