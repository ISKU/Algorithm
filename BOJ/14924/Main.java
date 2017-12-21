/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.12.21
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14924
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int S = input.nextInt();
		int T = input.nextInt();
		int D = input.nextInt();
		System.out.print((D / (S * 2)) * T);
	}
}