/*
 * Author: Minho Kim (ISKU)
 * Date: June 5, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17263
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int answer = 0;
		while (N-- > 0)
			answer = Math.max(answer, sc.nextInt());

		System.out.print(answer);
	}
}