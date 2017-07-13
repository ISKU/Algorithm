/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.26
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11104
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		for (int testCase = Integer.parseInt(input.next()); testCase > 0; testCase--) {
			String[] binaryNumber = new StringBuilder(input.next()).reverse().toString().split("");
			int sum = 0;

			for (int index = 0; index < binaryNumber.length; index++) {
				if (binaryNumber[index].equals("1"))
					sum += Math.pow(2, index);
			}

			System.out.println(sum);
		}
	}
}