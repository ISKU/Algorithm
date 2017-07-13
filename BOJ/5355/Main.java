/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5355
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCase = Integer.parseInt(input.nextLine());

		while (testCase-- > 0) {
			String[] equation = input.nextLine().split(" ");
			float number = Float.parseFloat(equation[0]);

			for (int index = 1; index < equation.length; index++) {
				if (equation[index].equals("@"))
					number = number * 3;
				else if (equation[index].equals("%"))
					number = number + 5;
				else if (equation[index].equals("#"))
					number = number - 7;
			}

			System.out.printf("%.2f\n", number);
		}
	}
}