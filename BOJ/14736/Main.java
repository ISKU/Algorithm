/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.09.27
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14736
 */

import java.util.*;

public class Main {
	public static void main(String... args) throws Exception {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int K = input.nextInt();
		int A = input.nextInt();

		int answer = Integer.MAX_VALUE;
		while (N-- > 0) {
			int t = input.nextInt();
			int s = input.nextInt();
			int k = K;
			int time = 0;

			OUT: 
			while (K > 0) {
				for (int i = 0; i < t; i++, time++, k -= A)
					if (k == 0)
						break OUT;
				if (k == 0)
					break;
				time += s;
			}

			answer = Math.min(answer, time);
		}

		System.out.print(answer);
	}
}