/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2935
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		BigInteger A = new BigInteger(input.next());
		String oper = input.next();
		BigInteger B = new BigInteger(input.next());
		System.out.println(oper.equals("+") ? A.add(B) : A.multiply(B));
	}
}