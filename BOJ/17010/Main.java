/*
 * Author: Minho Kim (ISKU)
 * Date: April 12, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17010
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int L = Integer.parseInt(br.readLine());
		while (L-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);

			while (n-- > 0)
				bw.write(c);
			bw.write('\n');
		}

		bw.close();
	}
}