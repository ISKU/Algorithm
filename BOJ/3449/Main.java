/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3449
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = Integer.parseInt(input.next()); testCase > 0; testCase--) {
			String[] firstLine = input.next().split("");
			String[] secondLine = input.next().split("");
			int equalCount = 0;

			for (int index = 0; index < firstLine.length; index++)
				if (!firstLine[index].equals(secondLine[index]))
					equalCount++;
			System.out.printf("Hamming distance is %d.\n", equalCount);
		}
	}
}