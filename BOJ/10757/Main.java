/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.05
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10757
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println(new BigInteger(input.next()).add(new BigInteger(input.next())));
	}
}