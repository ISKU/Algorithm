/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4493
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder output = new StringBuilder();
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int[] wins = new int[2];

			for (int count = input.nextInt(); count > 0; count--) {
				String playerA = input.next();
				String playerB = input.next();

				if (playerA.equals("R")) {
					if (playerB.equals("P"))
						wins[1]++;
					else if (playerB.equals("S"))
						wins[0]++;
				} else if (playerA.equals("P")) {
					if (playerB.equals("R"))
						wins[0]++;
					else if (playerB.equals("S"))
						wins[1]++;
				} else if (playerA.equals("S")) {
					if (playerB.equals("R"))
						wins[1]++;
					else if (playerB.equals("P"))
						wins[0]++;
				}
			}

			if (wins[0] > wins[1])
				output.append("Player 1\n");
			else if (wins[1] > wins[0])
				output.append("Player 2\n");
			else
				output.append("TIE\n");
		}

		System.out.print(output);
	}
}