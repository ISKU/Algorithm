/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.10
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3047
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int[] arrayNumber = new int[3];

		for (int index = 0; index < 3; index++)
			arrayNumber[index] = input.nextInt();
		Arrays.sort(arrayNumber);

		String[] abc = input.next().split("");
		for (int index = 0; index < 3; index++) {
			switch (abc[index]) {
			case "A":
				System.out.print(arrayNumber[0] + " ");
				break;
			case "B":
				System.out.print(arrayNumber[1] + " ");
				break;
			case "C":
				System.out.print(arrayNumber[2] + " ");
				break;
			}
		}
	}
}