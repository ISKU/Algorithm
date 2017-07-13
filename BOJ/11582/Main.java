/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.30
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11582
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] array = new int[input.nextInt()];

		for (int i = 0; i < array.length; i++)
			array[i] = input.nextInt();

		int k = input.nextInt();
		int check = array.length >> 1, iter = 2;

		while (check >= k) {
			for (int i = 0; i < array.length; i += iter)
				Arrays.sort(array, i, i + iter);
			iter <<= 1;
			check >>= 1;
		}

		for (int i = 0; i < array.length; i++)
			System.out.printf("%d ", array[i]);
	}
}