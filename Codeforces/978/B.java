/*
 * Author: Minho Kim (ISKU)
 * Date: May 13, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/978/B
 */

import java.util.*;
import java.io.*;

public class B {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String line = br.readLine();

		int count = 0;
		while (line.contains("xxx")) {
			line = line.replaceFirst("xxx", "xx");
			count++;
		}

		bw.write(String.valueOf(count));
		bw.close();
	}
}