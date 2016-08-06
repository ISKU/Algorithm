/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.06
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11726
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		long[] numberOfRectangle = new long[size];

		numberOfRectangle[0] = 1;
		if (size > 1)
			numberOfRectangle[1] = 2;

		for (int index = 2; index < size; index++)
			numberOfRectangle[index] = (numberOfRectangle[index - 1] + numberOfRectangle[index - 2]) % 10007;

		System.out.println((numberOfRectangle[size - 1]) % 10007);
	}
}