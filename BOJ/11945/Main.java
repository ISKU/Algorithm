/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.17
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11945
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		input.nextLine();
		while (input.hasNextLine())
			System.out.println((new StringBuilder(input.nextLine())).reverse().toString());
	}
}