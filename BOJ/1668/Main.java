/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.10
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1668
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] array = new int[input.nextInt()];
		for (int i = 0; i < array.length; i++)
			array[i] = input.nextInt();

		int left = array[0];
		int leftAnswer = 1;
		for (int i = 1; i < array.length; i++)
			if (left < array[i]) {
				leftAnswer++;
				left = array[i];
			}

		int right = array[array.length - 1];
		int rightAnswer = 1;
		for (int i = array.length - 1; i >= 0; i--)
			if (array[i] > right) {
				rightAnswer++;
				right = array[i];
			}

		System.out.println(leftAnswer);
		System.out.println(rightAnswer);
	}
}