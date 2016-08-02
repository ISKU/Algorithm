/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.02
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2752
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int[] number = new int[] { input.nextInt(), input.nextInt(), input.nextInt() };

		Arrays.sort(number);
		System.out.printf("%d %d %d", number[0], number[1], number[2]);
	}
}