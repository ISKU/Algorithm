/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9076
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = input.nextInt(); testCase > 0; testCase--) {
			int[] array = new int[5];
			for (int index = 0; index < 5; index++)
				array[index] = input.nextInt();

			Arrays.sort(array);
			if (array[3] - array[1] >= 4)
				System.out.println("KIN");
			else
				System.out.println(array[1] + array[2] + array[3]);
		}
	}
}