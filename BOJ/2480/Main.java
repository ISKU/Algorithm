/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2480
 */

import java.util.Scanner;
import java.util.Hashtable;
import java.util.Enumeration;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int max = Integer.MIN_VALUE;
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();

		for (int i = 0; i < 3; i++) {
			int cur = input.nextInt();
			table.put(cur, table.containsKey(cur) ? table.get(cur) + 1 : 1);
		}

		int tempMax = 0;
		int freq = 0;
		int freqKey = 0;
		for (Enumeration<Integer> keys = table.keys(); keys.hasMoreElements();) {
			int key = keys.nextElement();
			if (freq < table.get(key)) {
				freqKey = key;
				freq = table.get(key);
			}
			tempMax = Math.max(tempMax, key);
		}

		if (table.size() == 1)
			System.out.println(10000 + (freqKey * 1000));
		else if (table.size() == 2)
			System.out.println(1000 + (freqKey * 100));
		else
			System.out.println(tempMax * 100);
	}
}