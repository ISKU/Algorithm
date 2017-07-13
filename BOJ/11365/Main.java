/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11365
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		StringBuilder output = new StringBuilder();

		while (true) {
			String line = input.nextLine();
			if (line.equals("END"))
				break;
			output.append(new StringBuilder(line).reverse() + "\n");
		}

		System.out.print(output);
	}
}