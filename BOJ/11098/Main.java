/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.26
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11098
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		for (int testCase = input.nextInt(); testCase > 0; testCase--) {
			String nameOfExpensivePlayer = null;
			int maxValue = 0;

			for (int players = input.nextInt(); players > 0; players--) {
				int cost = input.nextInt();

				if (maxValue < cost) {
					maxValue = cost;
					nameOfExpensivePlayer = input.next();
				} else {
					input.next();
				}
			}

			System.out.println(nameOfExpensivePlayer);
		}
	}
}