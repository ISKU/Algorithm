/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.09.17
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14723
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();
		int g = (int) ((Math.sqrt((8 * N) - 7) - 1) / 2) + 1;
		int m = (g * (g + 1)) / 2;

		System.out.printf("%d %d", m - N + 1, N - m + g);
	}
}