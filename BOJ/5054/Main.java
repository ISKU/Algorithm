/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.12
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5054
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();

		while (t-- > 0) {
			int[] array = new int[input.nextInt()];
			for (int i = 0; i < array.length; i++)
				array[i] = input.nextInt();

			Arrays.sort(array);

			int sum = 0;
			for (int i = 1; i < array.length; i++)
				sum += array[i] - array[i - 1];

			System.out.println(sum * 2);
		}
	}
}