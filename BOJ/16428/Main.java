/*
 * Author: Minho Kim (ISKU)
 * Date: November 11, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16428
 */

import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger A = new BigInteger(st.nextToken());
		BigInteger B = new BigInteger(st.nextToken());
		BigInteger[] result = A.divideAndRemainder(B);

		if (result[1].compareTo(BigInteger.ZERO) == 0)
			System.out.printf("%d %d", result[0], result[1]);
		else if (A.signum() == -1 && B.signum() == 1) {
			BigInteger remain = B.multiply(result[0].subtract(BigInteger.ONE)).subtract(A).negate();
			System.out.printf("%d %d", result[0].subtract(BigInteger.ONE), remain);
		} else if ((A.signum() == -1 && B.signum() == -1)) {
			BigInteger remain = B.multiply(result[0].add(BigInteger.ONE)).subtract(A).negate();
			System.out.printf("%d %d", result[0].add(BigInteger.ONE), remain);
		} else {
			System.out.printf("%d %d", result[0], result[1]);
		}
	}
}