/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.02
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10797
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int numberOfVehicles = 0;

		for (int count = 0; count < 5; count++)
			if (number == input.nextInt())
				numberOfVehicles++;

		System.out.println(numberOfVehicles);
	}
}