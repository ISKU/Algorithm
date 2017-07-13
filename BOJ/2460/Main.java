/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.02
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2460
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numberOfPeople = 0, maximumNumberOfPeople = 0;

		for (int station = 0; station < 10; station++) {
			numberOfPeople = numberOfPeople - input.nextInt() + input.nextInt();
			maximumNumberOfPeople = Math.max(maximumNumberOfPeople, numberOfPeople);
		}

		System.out.println(maximumNumberOfPeople);
	}
}