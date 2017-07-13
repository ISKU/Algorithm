/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.17
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10798
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		char[][] array = new char[5][];

		int maxSize = 0;
		for (int i = 0; i < 5; i++) {
			array[i] = input.nextLine().toCharArray();
			maxSize = Math.max(maxSize, array[i].length);
		}

		for (int i = 0; i < maxSize; i++)
			for (int j = 0; j < 5; j++)
				if (array[j].length > i)
					System.out.print(array[j][i]);
	}
}