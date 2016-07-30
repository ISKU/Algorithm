/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.31
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5988
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		for (int count = input.nextInt(); count > 0; count--)
			System.out.println(new BigInteger(input.next()).remainder(new BigInteger("2")).toString().equals("0") ? "even" : "odd");
	}
}