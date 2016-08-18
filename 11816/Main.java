/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11816
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String number = input.nextLine();

		if (number.charAt(1) == 'x')
			System.out.println(Integer.parseInt(number.substring(2, number.length()), 16));
		else if (number.charAt(0) == '0')
			System.out.println(Integer.parseInt(number.substring(1, number.length()), 8));
		else
			System.out.println(number);
	}
}