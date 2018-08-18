/*
 * Author: Minho Kim (ISKU)
 * Date: August 14, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15964
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();

		System.out.print((A + B) * (A - B));
	}
}