/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.01
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10773
 */

import java.util.Scanner;
import java.math.BigInteger;
import java.util.Stack;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		Stack<BigInteger> stack = new Stack<BigInteger>();
		int K = input.nextInt();

		while (K-- > 0) {
			BigInteger cur = BigInteger.valueOf(input.nextInt());

			if (cur.equals(BigInteger.ZERO))
				stack.pop();
			else
				stack.push(cur);
		}

		BigInteger sum = BigInteger.ZERO;
		while (!stack.isEmpty())
			sum = sum.add(stack.pop());
		System.out.print(sum);
	}
}