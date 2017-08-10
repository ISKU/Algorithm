/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.10
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4470
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = Integer.parseInt(input.nextLine());
		for (int i = 1; i <= N; i++)
			System.out.printf("%d. %s\n", i, input.nextLine());
	}
}