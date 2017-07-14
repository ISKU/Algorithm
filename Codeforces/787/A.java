/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.03.23
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/787/A
 */

import java.util.*;
import java.io.*;
import java.math.*;

public class A {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		int d = input.nextInt();

		HashSet<Integer> table1 = new HashSet<Integer>();
		HashSet<Integer> table2 = new HashSet<Integer>();
		ArrayList<Integer> array = new ArrayList<Integer>();

		for (int i = 0; i < 100000; i++) {
			table1.add(b + (a * i));
			table2.add(d + (c * i));
		}

		for (int value : table1)
			if (table2.contains(value))
				array.add(value);

		Collections.sort(array);

		System.out.println(array.isEmpty() ? -1 : array.get(0));
	}
}