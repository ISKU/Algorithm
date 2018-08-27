/*
 * Author: Minho Kim (ISKU)
 * Date: August 23, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15969
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] array = new int[N];
		for (int i = 0; i < N; i++)
			array[i] = sc.nextInt();

		Arrays.sort(array);
		System.out.print(array[N - 1] - array[0]);
	}
}