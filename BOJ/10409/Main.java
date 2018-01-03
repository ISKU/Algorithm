/* 
 * Author: Minho Kim (ISKU)
 * Date: January 3, 2018
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10409
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int T = input.nextInt();

		int sum = 0, count = 0;
		while (N-- > 0) {
			sum += input.nextInt();
			if (sum > T)
				break;
			count++;
		}

		System.out.print(count);
	}
}