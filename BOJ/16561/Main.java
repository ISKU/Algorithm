/*
 * Author: Minho Kim (ISKU)
 * Date: November 24, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16561
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		N /= 3;
		System.out.print((N - 1) * (N - 2) / 2);
	}
}