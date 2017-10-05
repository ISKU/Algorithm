/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.09.23
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://icpckorea.org/2017/preliminary/problems.pdf
 */

import java.util.*;

public class H {
	public static void main(String... args) throws Exception {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int[] cards = new int[N];

		for (int i = 0; i < N; i++)
			cards[i] = input.nextInt();
		Arrays.sort(cards);

		int answer = cards[0] * cards[1];
		answer = Math.max(answer, cards[N - 2] * cards[N - 1]);
		answer = Math.max(answer, cards[0] * cards[1] * cards[N - 1]);
		answer = Math.max(answer, cards[N - 3] * cards[N - 2] * cards[N - 1]);

		System.out.print(answer);
	}
}