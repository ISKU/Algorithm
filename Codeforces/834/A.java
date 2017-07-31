/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.30
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/834/A
 */

import java.util.*;

public class A {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		String[] spun = new String[] { "^", ">", "v", "<" };
		String[] line = input.nextLine().split(" ");
		int N = input.nextInt();

		int startIndex = 0;
		for (int i = 0; i < spun.length; i++)
			if (line[0].equals(spun[i]))
				startIndex = i;

		boolean right = false;
		boolean left = false;

		if (spun[((N % 4) + startIndex) % 4].equals(line[1]))
			right = true;
		if (spun[(startIndex - (N % 4)) < 0 ? 4 + (startIndex - (N % 4)) : (startIndex - (N % 4)) % 4].equals(line[1]))
			left = true;

		if ((!right && !left) || (right && left))
			System.out.print("undefined");
		else if (right)
			System.out.print("cw");
		else
			System.out.print("ccw");
	}
}