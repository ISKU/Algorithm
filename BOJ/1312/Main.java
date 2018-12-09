/*
 * Author: Minho Kim (ISKU)
 * Date: December 8, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1312
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int N = sc.nextInt();

		int answer = 0;
		while (N-- > 0) {
			A = (A % B) * 10;
			answer = A / B;
		}
		System.out.print(answer);
	}
}