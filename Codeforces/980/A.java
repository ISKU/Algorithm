/*
 * Author: Minho Kim (ISKU)
 * Date: May 9, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/980/A
 */

import java.util.*;
import java.io.*;

public class A {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = br.readLine();

		int p = 0;
		for (int i = 0; i < line.length(); i++)
			if (line.charAt(i) == 'o')
				p++;

		if (p == 0 || (line.length() - p) % p == 0)
			bw.write("YES");
		else
			bw.write("NO");

		bw.close();
	}
}