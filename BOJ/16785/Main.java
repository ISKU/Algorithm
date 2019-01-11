/*
 * Author: Minho Kim (ISKU)
 * Date: January 11, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16785
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		int sum = 0;
		int count = 0;
		while (sum < C) {
			sum += A;
			count++;
			if (count % 7 == 0)
				sum += B;
		}

		System.out.print(count);
	}
}