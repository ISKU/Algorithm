/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1660
 */

import java.util.Scanner;
import java.util.Vector;

public class Main {
	public static void main(String... args) {
		int number = new Scanner(System.in).nextInt();
		Vector<Integer> array = new Vector<Integer>();
		int sum = 1;

		array.add(1);
		for (int i = 2;; i++) {
			sum += i;
			array.add(array.lastElement() + sum);
			if (array.lastElement() >= 300000)
				break;
		}

		int[] table = new int[300001];
		for (int i = 0; i <= number; i++)
			table[i] = 300001;
		for (int i = 0; i < array.size() - 1; i++) {
			table[array.get(i)] = 1;
			for (int k = array.get(i); k <= number; k++)
				table[k] = (table[k] > table[k - array.get(i)] + 1) ? table[k - array.get(i)] + 1 : table[k];
		}

		System.out.print(table[number]);
	}
}