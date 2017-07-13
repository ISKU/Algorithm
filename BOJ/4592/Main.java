/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9933
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder output = new StringBuilder();

		while (true) {
			int size = input.nextInt();

			if (size == 0)
				break;

			int prevValue = input.nextInt();
			output.append(prevValue + " ");

			for (int index = 1; index < size; index++) {
				int currentValue = input.nextInt();
				if (prevValue != currentValue) {
					output.append(currentValue + " ");
					prevValue = currentValue;
				}
			}
			output.append("$\n");
		}

		System.out.print(output);
	}
}