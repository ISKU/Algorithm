/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.02
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10103
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int scoreA = 100, scoreB = 100;

		for (int round = input.nextInt(); round > 0; round--) {
			int dicePointA = input.nextInt();
			int dicePointB = input.nextInt();

			if (dicePointA > dicePointB)
				scoreB = scoreB - dicePointA;
			else if (dicePointA == dicePointB)
				continue;
			else
				scoreA = scoreA - dicePointB;
		}

		System.out.printf("%d\n%d\n", scoreA, scoreB);
	}
}