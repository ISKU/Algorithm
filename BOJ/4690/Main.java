/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.10
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4690
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
	public static void main(String... args) {
		for (int i = 2; i <= 100; i++) {
			ArrayList<Integer> tri = new ArrayList<Integer>();
			HashSet<String> set = new HashSet<String>();

			for (int j = 2; j <= i; j++)
				for (int k = 2; k <= i; k++)
					for (int x = 2; x <= i; x++)
						if (cube(j) + cube(k) + cube(x) == cube(i)) {
							tri.add(j);
							tri.add(k);
							tri.add(x);
							Collections.sort(tri);

							String candidate = tri.get(0) + " " + tri.get(1) + " " + tri.get(2);
							if (!set.contains(candidate)) {
								System.out.printf("Cube = %d, Triple = (%d,%d,%d)\n", i, tri.get(0), tri.get(1),
										tri.get(2));
								set.add(candidate);
							}

							tri.clear();
						}
		}
	}

	private static int cube(int n) {
		return n * n * n;
	}
}