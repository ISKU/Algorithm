/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.10
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2577
 */

import java.util.Scanner;
import java.util.Hashtable;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();

		String[] result = String.valueOf(input.nextInt() * input.nextInt() * input.nextInt()).split("");
		for (int index = 0; index < result.length; index++) {
			int number = Integer.parseInt(result[index]);
			table.put(number, table.containsKey(number) ? table.get(number) + 1 : 1);
		}

		for (int count = 0; count < 10; count++)
			System.out.println(table.containsKey(count) ? table.get(count) : "0");
	}
}