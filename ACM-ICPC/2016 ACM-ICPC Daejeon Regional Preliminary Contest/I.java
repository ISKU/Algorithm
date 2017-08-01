/* 
 * Author: Minho Kim (ISKU)
 * Date: 2016.10.01
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://icpckorea.org/2016/ONLINE/problem.pdf
 */

import java.util.Scanner;

public class I {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int k = input.nextInt();

		int[] array = new int[k];

		for (int i = 0; i < k; i++)
			array[i] = input.nextInt();

		for (int i = k; i > 0; i--) {
			int count = k;

			for (int j = 0; j < k; j++)
				if (array[j] < i)
					count--;

			if (count == 0) {
				System.out.println(0);
				break;
			}

			if (count >= i) {
				System.out.println(i);
				break;
			}
		}
	}
}