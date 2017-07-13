/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.03
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11720
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int index = input.nextInt() - 1;
		int sum = 0;

		for (String[] number = input.next().split(""); index >= 0; index--)
			sum = sum + Integer.parseInt(number[index]);

		System.out.println(sum);
	}
}