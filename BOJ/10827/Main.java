/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.11.12
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10827
 */

import java.util.Scanner;
import java.math.BigDecimal;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		System.out.print(new BigDecimal(input.next()).pow(input.nextInt()).toPlainString());
	}
}