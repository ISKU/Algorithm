/*
 * Author: Minho Kim (ISKU)
 * Date: May 1, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/975/A
 */

import java.util.*;
import java.io.*;

public class A {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		HashSet<String> set = new HashSet<String>();
		while (N-- > 0) {
			char[] word = st.nextToken().toCharArray();

			HashSet<Character> tempSet = new HashSet<Character>();
			for (char c : word)
				tempSet.add(c);

			char[] object = new char[tempSet.size()];
			int i = 0;
			for (char c : tempSet)
				object[i++] = c;
			Arrays.sort(object);

			set.add(String.valueOf(object));
		}

		bw.write(String.valueOf(set.size()));
		bw.close();
	}
}