/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1271
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		BigInteger n = new BigInteger(input.next());
		BigInteger m = new BigInteger(input.next());
		System.out.println(n.divide(m));
		System.out.println(n.remainder(m));
	}
}