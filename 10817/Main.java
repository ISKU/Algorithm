/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.21
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10817
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int[] listNumber = new int[3];

		for (int i = 0; i < 3; i++)
			listNumber[i] = input.nextInt();
		Arrays.sort(listNumber);

		System.out.println(listNumber[1]);
	}
}