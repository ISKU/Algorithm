/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9612
 */

import java.util.Scanner;
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
		int testCase = Integer.parseInt(input.nextLine());

		while (testCase-- > 0) {
			String word = input.nextLine();
			table.put(word, table.containsKey(word) ? table.get(word) + 1 : 1);
		}

		String key = "";
		int max = Integer.MIN_VALUE;
		for (Enumeration<String> keys = table.keys(); keys.hasMoreElements();) {
			String tempKey = keys.nextElement();
			if (table.get(tempKey) > max) {
				max = table.get(tempKey);
				key = tempKey;
			}
		}

		ArrayList<String> out = new ArrayList<String>();
		for (Enumeration<String> keys = table.keys(); keys.hasMoreElements();) {
			String tempKey = keys.nextElement();
			if (table.get(tempKey) == max)
				out.add(tempKey);
		}

		Collections.sort(out);
		System.out.println(out.get(out.size() - 1) + " " + table.get(out.get(out.size() - 1)));
	}
}