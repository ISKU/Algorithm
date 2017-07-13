/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.30
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2562
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Table[] table = new Table[9];

		for (int index = 0; index < 9; index++)
			table[index] = new Table(index + 1, input.nextInt());

		Arrays.sort(table);
		System.out.println(table[0].value);
		System.out.println(table[0].index);
	}

	private static class Table implements Comparable<Table> {

		public int index;
		public int value;

		public Table(int index, int value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(Table target) {
			if (this.value > target.value)
				return -1;
			else if (this.value < target.value)
				return 1;
			else
				return 0;
		}
	}
}