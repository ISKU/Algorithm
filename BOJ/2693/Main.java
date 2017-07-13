/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.04
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2693
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = input.nextInt(); testCase > 0; testCase--) {
			int[] numberArray = new int[10];
			for (int index = 0; index < 10; index++)
				numberArray[index] = input.nextInt();
			Arrays.sort(numberArray);
			System.out.println(numberArray[7]);
		}
	}
}