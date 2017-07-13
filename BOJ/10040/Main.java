/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10040
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int[] game = new int[input.nextInt()];
		int[] judge = new int[input.nextInt()];
		int[] popularGame = new int[game.length];

		for (int index = 0; index < game.length; index++)
			game[index] = input.nextInt();

		for (int count = 0; count < judge.length; count++) {
			judge[count] = input.nextInt();
			for (int index = 0; index < game.length; index++) {
				if (game[index] <= judge[count]) {
					popularGame[index]++;
					break;
				}
			}
		}

		int mostPopularGameIndex = -1;
		int max = 0;
		for (int index = 0; index < popularGame.length; index++) {
			if (popularGame[index] > max) {
				max = popularGame[index];
				mostPopularGameIndex = index;
			}
		}
		System.out.println(mostPopularGameIndex + 1);
	}
}