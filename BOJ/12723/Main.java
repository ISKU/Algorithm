/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.07
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12723
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		for (int tCase = 1; tCase <= testCase; tCase++) {
			int n = input.nextInt();
			ArrayList<Long> x = new ArrayList<Long>();
			ArrayList<Long> y = new ArrayList<Long>();

			for (int i = 0; i < n; i++)
				x.add(input.nextLong());
			for (int i = 0; i < n; i++)
				y.add(input.nextLong());

			Collections.sort(x);
			Collections.sort(y, Collections.reverseOrder());

			long ans = 0;
			for (int i = 0; i < n; i++)
				ans += x.get(i) * y.get(i);

			System.out.printf("Case #%d: %d\n", tCase, ans);
		}
	}
}