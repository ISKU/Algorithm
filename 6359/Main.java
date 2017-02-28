/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.01
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/6359
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			boolean[] array = new boolean[input.nextInt() + 1];

			for (int i = 1; i < array.length; i++)
				for (int j = i; j < array.length; j += i)
					array[j] = !array[j];

			int count = 0;
			for (int i = 1; i < array.length; i++)
				if (array[i])
					count++;
			System.out.println(count);
		}
	}
}