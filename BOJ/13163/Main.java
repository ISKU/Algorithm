/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.24
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13163
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int testCase = Integer.parseInt(input.nextLine());

		while (testCase-- > 0) {
			String[] name = input.nextLine().split(" ");
			StringBuilder output = new StringBuilder("god");

			for (int index = 1; index < name.length; index++)
				output.append(name[index]);

			System.out.println(output);
		}
	}
}