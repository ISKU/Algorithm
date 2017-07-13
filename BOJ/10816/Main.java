/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.09
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10816
 */

import java.util.Scanner;
import java.util.HashMap;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();

		int N = input.nextInt();
		while (N-- > 0) {
			int number = input.nextInt();
			table.put(number, table.containsKey(number) ? table.get(number) + 1 : 1);
		}

		int M = input.nextInt();
		while (M-- > 0) {
			int number = input.nextInt();
			System.out.printf("%d ", table.containsKey(number) ? table.get(number) : 0);
		}
	}
}