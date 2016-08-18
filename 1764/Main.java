/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1764
 */

import java.util.Scanner;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		Hashtable<String, Integer> table = new Hashtable<String, Integer>(500000);

		for (int count = 0; count < N; count++)
			table.put(input.next(), 1);
		for (int count = 0; count < M; count++) {
			String name = input.next();
			table.put(name, table.containsKey(name) ? 2 : 1);
		}

		ArrayList<String> list = new ArrayList<String>();
		for (Enumeration<String> keySet = table.keys(); keySet.hasMoreElements();) {
			String key = keySet.nextElement();
			if (table.get(key) == 2) {
				list.add(key);
			}
		}

		Object[] sortingList = list.toArray();
		Arrays.sort(sortingList);
		System.out.println(sortingList.length);
		for (int index = 0; index < sortingList.length; index++) {
			System.out.println((String) sortingList[index]);
		}
	}
}