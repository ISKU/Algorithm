/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.29
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10950
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		for (int testCase = input.nextInt(); testCase > 0; testCase--)
			System.out.println(input.nextInt() + input.nextInt());
	}
}