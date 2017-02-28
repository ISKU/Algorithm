/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.28
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2903
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		System.out.print((int) Math.pow((1 << new Scanner(System.in).nextInt()) + 1, 2));
	}
}