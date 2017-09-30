/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.09.30
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2501
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int K = input.nextInt();
		ArrayList<Integer> number = new ArrayList<Integer>();

		for (int i = 1; i <= N; i++)
			if (N % i == 0)
				number.add(i);

		System.out.printf("%d", K - 1 < number.size() ? number.get(K - 1) : 0);
	}
}