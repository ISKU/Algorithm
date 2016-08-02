/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.02
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2566
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Matrix maximumValueInMatrix = new Matrix(0, 0, 0);

		for (int row = 0; row < 9; row++) {
			for (int columm = 0; columm < 9; columm++) {
				int currentValue = input.nextInt();
				if (maximumValueInMatrix.value < currentValue) {
					maximumValueInMatrix.row = row + 1;
					maximumValueInMatrix.columm = columm + 1;
					maximumValueInMatrix.value = currentValue;
				}
			}
		}

		System.out.println(maximumValueInMatrix.value);
		System.out.println(maximumValueInMatrix.row + " " + maximumValueInMatrix.columm);
	}

	private static class Matrix {
		public int row;
		public int columm;
		public int value;

		public Matrix(int row, int columm, int value) {
			this.row = row;
			this.columm = columm;
			this.value = value;
		}
	}
}