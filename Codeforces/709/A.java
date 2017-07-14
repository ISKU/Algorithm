/* 
 * Author: Minho Kim (ISKU)
 * Date: 2016.08.26
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/709/A
 */

import java.util.Scanner;

public class A {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numberOfOranges = input.nextInt();
		int orangeSize = input.nextInt();
		int overflowSize = input.nextInt();
		int sum = 0;
		int count = 0;

		for (int index = 0; index < numberOfOranges; index++) {
			int orange = input.nextInt();
			if (orange > orangeSize)
				continue;
			sum += orange;
			if (sum > overflowSize) {
				sum = 0;
				count++;
			}
		}

		System.out.println(count);
	}
}