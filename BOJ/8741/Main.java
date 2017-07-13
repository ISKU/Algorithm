/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.21
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/8741
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		StringBuilder output = new StringBuilder();
		int length = new Scanner(System.in).nextInt();
        
		for (int one = 0; one < length; one++)
			output.append("1");
		for (int zero = 0; zero < length - 1; zero++)
			output.append("0");
		System.out.print(output);
	}
}