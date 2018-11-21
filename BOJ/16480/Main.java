/*
 * Author: Minho Kim (ISKU)
 * Date: November 21, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16480
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long R = sc.nextLong();
		long r = sc.nextLong();
		System.out.print((R * R) - (2 * R * r));
	}
}