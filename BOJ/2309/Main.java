/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.28
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2309
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] l = new int[9];

		for (int i = 0; i < 9; i++)
			l[i] = input.nextInt();

		int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0;
		OUT: 
		for (a = 0; a < 9; a++)
			for (b = a + 1; b < 9; b++)
				for (c = b + 1; c < 9; c++)
					for (d = c + 1; d < 9; d++)
						for (e = d + 1; e < 9; e++)
							for (f = e + 1; f < 9; f++)
								for (g = f + 1; g < 9; g++) {
									int sum = l[a] + l[b] + l[c] + l[d] + l[e] + l[f] + l[g];
									if (sum == 100)
										break OUT;
								}

		int[] array = new int[] { l[a], l[b], l[c], l[d], l[e], l[f], l[g] };
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++)
			System.out.println(array[i]);
	}
}