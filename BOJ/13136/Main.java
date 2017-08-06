/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.06
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13136
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		long M = input.nextInt();
		long N = input.nextInt();
		long C = input.nextInt();
		long answer = ((M % C == 0) ? M / C : (M / C) + 1) * ((N % C == 0) ? N / C : (N / C) + 1);
		System.out.print(answer);
	}
}