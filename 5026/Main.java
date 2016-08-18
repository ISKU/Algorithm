/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5026
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = Integer.parseInt(input.next()); testCase > 0; testCase--) {
			String[] problem = input.next().split("[+]");
			System.out.println(
					problem[0].equals("P=NP") ? "skipped" : Integer.parseInt(problem[0]) + Integer.parseInt(problem[1]));
		}
	}
}