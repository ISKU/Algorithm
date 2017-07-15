/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.04.22
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://code.google.com/codejam/contest/8294486/dashboard#s=p0
 */

import java.util.*;
import java.io.*;
import java.math.*;

public class A_Small {
	public static void main(String... args) throws IOException {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		for (int tCase = 1; tCase <= testCase; tCase++) {
			double D = input.nextDouble();
			int N = input.nextInt();
			Node[] array = new Node[N];

			for (int i = 0; i < N; i++)
				array[i] = new Node(input.nextDouble(), input.nextDouble());

			double max = 0;
			for (int i = 0; i < N; i++) {
				double h = (D - array[i].p) / array[i].k;
				max = Math.max(max, h);
			}

			System.out.printf("Case #%d: %.6f\n", tCase, D / max);
		}
	}

	private static class Node {
		double p;
		double k;

		public Node(double p, double k) {
			this.p = p;
			this.k = k;
		}
	}
}