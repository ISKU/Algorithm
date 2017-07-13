/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.06
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12792
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int[] destination = new int[size];
		int result = 0;

		// input
		for (int index = 0; index < size; index++)
			destination[index] = input.nextInt();

		// always fault
		for (int index = 0; index < size; index++)
			if (destination[index] == index + 1) {
				result = -1;
				break;
			}

		if (result != -1)
			System.out.println(1000000007);
		else
			System.out.println(-1);
	}
}