/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1037
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int[] aliquot = new int[input.nextInt()];

		for (int index = 0; index < aliquot.length; index++)
			aliquot[index] = input.nextInt();

		Arrays.sort(aliquot);
		System.out.print(aliquot[0] * aliquot[aliquot.length - 1]);
	}
}