/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9625
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		int K = new Scanner(System.in).nextInt();
		int first = 0;
		int second = 1;
		int result = 1;

		while (K-- > 1) {
			result = first + second;
			first = second;
			second = result;
		}

		System.out.println(first + " " + result);
	}
}