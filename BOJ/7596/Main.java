/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/7596
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		int testCase = 1;
		while (true) {
			int maxCount = Integer.parseInt(input.nextLine());
			String[] array = new String[maxCount];
			if (maxCount == 0)
				break;

			System.out.println(testCase++);
			for (int index = 0; index < maxCount; index++)
				array[index] = input.nextLine();

			Arrays.sort(array);
			for (int index = 0; index < maxCount; index++)
				System.out.println(array[index]);
		}
	}
}