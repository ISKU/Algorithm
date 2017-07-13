/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1546
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		float[] array = new float[input.nextInt()];
		float sum = 0;

		for (int index = 0; index < array.length; index++)
			array[index] = input.nextFloat();

		Arrays.sort(array);
		float maxValue = array[array.length - 1];

		for (int index = 0; index < array.length; index++)
			sum += (array[index] / maxValue) * 100;

		System.out.printf("%.2f", sum / array.length);
	}
}