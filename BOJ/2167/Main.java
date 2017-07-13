/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2167
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int[][] array = new int[input.nextInt()][input.nextInt()];

		for (int row = 0; row < array.length; row++)
			for (int column = 0; column < array[row].length; column++)
				array[row][column] = input.nextInt();

		for (int count = input.nextInt(); count > 0; count--) {
			int startRow = input.nextInt() - 1;
			int startColumn = input.nextInt() - 1;
			int endRow = input.nextInt() - 1;
			int endColumn = input.nextInt() - 1;
			int sum = 0;

			for (int row = startRow; row <= endRow; row++)
				for (int column = startColumn; column <= endColumn; column++)
					sum = sum + array[row][column];
			System.out.println(sum);
		}
	}
}