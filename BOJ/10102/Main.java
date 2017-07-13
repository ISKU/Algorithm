/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10102
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = Integer.parseInt(input.nextLine());
		String[] score = input.nextLine().split("");
		int[] wins = new int[2];

		while (N-- > 0) {
			if (score[N].equals("A"))
				wins[0]++;
			else
				wins[1]++;
		}

		if (wins[0] > wins[1])
			System.out.println("A");
		else if (wins[1] > wins[0])
			System.out.println("B");
		else
			System.out.println("Tie");
	}
}