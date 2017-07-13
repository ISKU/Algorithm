/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.14
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3052
 */

import java.util.Scanner;
import java.util.Hashtable;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>(10);

		for (int count = 0; count < 10; count++)
			table.put(input.nextInt() % 42, 1);
		System.out.println(table.size());
	}
}