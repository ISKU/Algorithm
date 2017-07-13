/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.29
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11021
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numberOfCase = input.nextInt();
		for (int testCase = 1; testCase <= numberOfCase; testCase++)
			System.out.printf("Case #%d: %d\n", testCase, input.nextInt() + input.nextInt());
	}
}