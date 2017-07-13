/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.24
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10822
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		String[] numberArray = new Scanner(System.in).nextLine().split(",");
		int sum = 0;

		for (int index = 0; index < numberArray.length; index++)
			sum += Integer.parseInt(numberArray[index]);

		System.out.print(sum);
	}
}