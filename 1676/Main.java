/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.06
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1676
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		System.out.println((N / 5) + (N / 25) + (N / 125));
	}
}