/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4766
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		float first = input.nextFloat();

		while (true) {
			float next = input.nextFloat();
			if (next == 999)
				break;

			System.out.printf("%.2f\n", next - first);
			first = next;
		}
	}
}