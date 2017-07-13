
/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.31
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1453
 */

import java.util.Scanner;
import java.util.Enumeration;
import java.util.Hashtable;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		int numberOfRejection = 0;

		for (int customer = input.nextInt(); customer > 0; customer--) {
			int number = input.nextInt();
			table.put(number, table.containsKey(number) ? table.get(number) + 1 : 0);
		}

		for (Enumeration<Integer> rejection = table.elements(); rejection.hasMoreElements();)
			numberOfRejection += rejection.nextElement();

		System.out.println(numberOfRejection);
	}
}