/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11809
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		String first = input.next();
		String second = input.next();

		int count = Math.abs(first.length() - second.length());
		if (first.length() > second.length())
			for (int i = 0; i < count; i++)
				second = "0" + second;
		else if (first.length() < second.length())
			for (int i = 0; i < count; i++)
				first = "0" + first;

		String[] N = first.split("");
		String[] M = second.split("");

		for (int i = 0; i < N.length; i++) {
			int n = Integer.parseInt(N[i]);
			int m = Integer.parseInt(M[i]);

			if (n > m)
				M[i] = "";
			else if (n < m)
				N[i] = "";
		}

		String nOut = "";
		String mOut = "";
		for (int i = 0; i < N.length; i++) {
			nOut += N[i];
			mOut += M[i];
		}

		System.out.println(nOut.length() == 0 ? "YODA" : Integer.parseInt(nOut));
		System.out.println(mOut.length() == 0 ? "YODA" : Integer.parseInt(mOut));
	}
}