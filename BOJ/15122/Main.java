/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.12.22
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15122
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt() + 1;

		while (String.valueOf(N).contains("0"))
			N++;
		System.out.print(N);
	}
}