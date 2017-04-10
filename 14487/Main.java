/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.10
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14487
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] array = new int[input.nextInt()];

		for (int i = 0; i < array.length; i++)
			array[i] = input.nextInt();

		Arrays.sort(array);

		int sum = 0;
		for (int i = 0; i < array.length - 1; i++)
			sum += array[i];

		System.out.print(sum);
	}
}