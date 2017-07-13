/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.11.11
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13560
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] points = new int[input.nextInt()];
		boolean answer = true;
		int sum = 0;

		for (int index = 0; index < points.length; index++)
			points[index] = input.nextInt();

		Arrays.sort(points);
		for (int index = 0; index < points.length; index++) {
			sum += points[index];
			if (sum < (index + 1) * index / 2) {
				answer = false;
				break;
			}
		}

		System.out.print(sum == (points.length * (points.length - 1) / 2) && answer ? 1 : -1);
		input.close();
	}
}