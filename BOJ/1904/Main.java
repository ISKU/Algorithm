/*
 * Author: Minho Kim (ISKU)
 * Date: April 27, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1904
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();

		int[] array = new int[N + 1];
		array[0] = 1;
		array[1] = 1;
		for (int i = 2; i <= N; i++)
			array[i] = (array[i - 1] + array[i - 2]) % 15746;

		System.out.print(array[N]);
	}
}