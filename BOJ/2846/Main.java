/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2846
 */

import java.util.Scanner;
import java.util.Vector;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		Vector<Integer> array = new Vector<Integer>();
		int count = input.nextInt();
		int prev, cur;
		int out = 0;

		array.add(input.nextInt());
		cur = array.lastElement();
		while (count-- > 1) {
			prev = cur;
			cur = input.nextInt();

			if (prev < cur)
				array.add(cur);
			else {
				if (!array.isEmpty())
					out = Math.max(out, array.lastElement() - array.firstElement());
				array.clear();
				array.add(cur);
			}
		}

		if (!array.isEmpty())
			System.out.print(Math.max(out, array.lastElement() - array.firstElement()));
		else
			System.out.print(out);
	}
}