/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9658
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();
		System.out.print(N % 7 == 1 || N % 7 == 3 ? "CY" : "SK");
	}
}