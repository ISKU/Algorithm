/*
 * Author: Minho Kim (ISKU)
 * Date: November 16, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16495
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] num = sc.next().toCharArray();

		long d = 1;
		long sum = 0;
		for (int i = num.length - 1; i >= 0; i--, d *= 26)
			sum += (num[i] - 'A' + 1) * d;

		System.out.print(sum);
	}
}