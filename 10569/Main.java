/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.26
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10569
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		for (int testCase = input.nextInt(); testCase > 0; testCase--)
			System.out.println(Math.abs(input.nextInt() - input.nextInt() - 2));
	}
}