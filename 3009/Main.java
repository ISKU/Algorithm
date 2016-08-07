/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.08
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3009
 */

import java.util.Scanner;
import java.util.Enumeration;
import java.util.Hashtable;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Hashtable<Integer, Integer> tableX = new Hashtable<Integer, Integer>();
		Hashtable<Integer, Integer> tableY = new Hashtable<Integer, Integer>();

		for (int index = 0; index < 3; index++) {
			int x = input.nextInt();
			int y = input.nextInt();
			tableX.put(x, tableX.containsKey(x) ? tableX.get(x) + 1 : 1);
			tableY.put(y, tableY.containsKey(y) ? tableY.get(y) + 1 : 1);
		}

		for (Enumeration<Integer> keyX = tableX.keys(); keyX.hasMoreElements();) {
			int x = keyX.nextElement();
			if (tableX.get(x) == 1) {
				System.out.print(x + " ");
				break;
			}
		}

		for (Enumeration<Integer> keyY = tableY.keys(); keyY.hasMoreElements();) {
			int y = keyY.nextElement();
			if (tableY.get(y) == 1) {
				System.out.println(y);
				break;
			}
		}
	}
}