/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.09.28
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14614
 */

import java.util.*;
import java.math.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		BigInteger A = new BigInteger(input.next());
		BigInteger B = new BigInteger(input.next());
		BigInteger C = new BigInteger(input.next());

		System.out.print((C.remainder(new BigInteger("2")).toString().equals("0")) ?
				A.toString() : A.xor(B).toString());
	}
}