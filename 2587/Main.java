/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2587
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int[] array = new int[5];
		int sum = 0;

		for (int index = 0; index < 5; index++) {
			array[index] = input.nextInt();
			sum += array[index];
		}

		Arrays.sort(array);
		System.out.println(sum / 5);
		System.out.println(array[2]);
	}
}