/*
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.30
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10824
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.print(Long.parseLong(String.valueOf(input.nextInt()) + String.valueOf(input.nextInt()))
				+ Long.parseLong(String.valueOf(input.nextInt()) + String.valueOf(input.nextInt())));
	}
}