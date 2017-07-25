/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.24
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/832/A
 */

import java.util.*;

public class A {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		System.out.print(((input.nextLong() / input.nextLong()) & 1) == 1 ? "YES" : "NO");
	}
}