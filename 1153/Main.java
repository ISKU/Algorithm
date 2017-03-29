/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.29
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1153
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();
		ArrayList<Boolean> prime = new ArrayList<Boolean>() {{
			add(false);
			add(false);
		}};

		for (int i = 2; i <= N; i++)
			prime.add(i, true);

		for (int i = 2; i * i <= N; i++)
			if (prime.get(i))
				for (int j = i * i; j <= N; j += i)
					prime.set(j, false);

		if (N % 2 == 0) {
			for (int i = 2; i <= N; i++)
				for (int j = 2; j <= N; j++)
					if (prime.get(i) && prime.get(j))
						if (N == (4 + i + j)) {
							System.out.printf("2 2 %d %d", i, j);
							System.exit(0);
						}
		} else {
			for (int i = 2; i <= N; i++)
				for (int j = 2; j <= N; j++)
					if (prime.get(i) && prime.get(j))
						if (N == (5 + i + j)) {
							System.out.printf("2 3 %d %d", i, j);
							System.exit(0);
						}
		}
		
		System.out.print(-1);
	}
}