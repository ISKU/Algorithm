/*
 * Author: Minho Kim (ISKU)
 * Date: May 29, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/987/B
 */

import java.util.*;
import java.io.*;

public class B {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double x = Double.parseDouble(st.nextToken());
		double y = Double.parseDouble(st.nextToken());

		double yy = Math.pow(y, x / y);

		if (x < yy)
			System.out.println("<");
		else if (x > yy)
			System.out.println(">");
		else if (x == yy)
			System.out.println("=");
	}
}