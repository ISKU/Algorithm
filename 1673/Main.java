/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.30
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1673
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		while (input.hasNext()) {
			int n = input.nextInt();
			int k = input.nextInt();
			int count = n;

			while (n / k > 0) {
				count += (n / k);
				n = (n / k) + (n % k);
			}

			System.out.println(count);
		}
	}
}