/*
 * Author: Minho Kim (ISKU)
 * Date: April 12, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17009
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt() * 3 + sc.nextInt() * 2 + sc.nextInt();
		int B = sc.nextInt() * 3 + sc.nextInt() * 2 + sc.nextInt();
		System.out.println((A == B) ? "T" : (A > B) ? "A" : "B");
	}
}