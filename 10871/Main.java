/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.21
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10871
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int limit = input.nextInt();
		int boundaryNumber = input.nextInt();

		for (int i = 0; i < limit; i++) {
			int currentNumber = input.nextInt();
			if (currentNumber < boundaryNumber)
				System.out.printf("%d ", currentNumber);
		}
	}
}