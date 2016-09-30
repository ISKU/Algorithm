/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.30
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11502
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int[] array = new int[input.nextInt()];
			boolean correct = false;

			for (int index = 2; index < array.length; index++)
				array[index] = index;

			for (int i = 2; i < array.length; i++)
				for (int j = 2; j < array.length; j++)
					if (array[j] != i && array[j] % i == 0) {
						array[j] = 0;
					}

			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					for (int k = 0; k < array.length; k++) {
						if (array[i] != 0 && array[j] != 0 && array[k] != 0) {
							if (array.length == (array[i] + array[j] + array[k])) {
								System.out.printf("%d %d %d\n", array[i], array[j], array[k]);
								correct = true;
							}
						}
						if (correct)
							break;
					}
					if (correct)
						break;
				}
				if (correct)
					break;
			}
		}

	}
}