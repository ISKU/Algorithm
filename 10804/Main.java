/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.04.29
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10804
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] array = new int[21];

		for (int i = 1; i <= 20; i++)
			array[i] = i;

		for (int i = 0; i < 10; i++)
			reverse(array, input.nextInt(), input.nextInt());

		for (int i = 1; i <= 20; i++)
			System.out.printf("%d ", array[i]);
	}

	private static void reverse(int[] array, int front, int rear) {
		while (front < rear) {
			int temp = array[front];
			array[front++] = array[rear];
			array[rear--] = temp;
		}
	}
}