/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.02
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10807
 */

import java.util.Scanner;
import java.util.Hashtable;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();

		for (int count = input.nextInt(); count > 0; count--) {
			int number = input.nextInt();
			table.put(number, table.containsKey(number) ? table.get(number) + 1 : 1);
		}

		int findNumber = input.nextInt();
		System.out.printf("%d", table.containsKey(findNumber) ? table.get(findNumber) : 0);
	}
}