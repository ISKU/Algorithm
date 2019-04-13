/*
 * Author: Minho Kim (ISKU)
 * Date: April 12, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16861
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		int harshad = new Scanner(System.in).nextInt();

		while (true) {
			int n = harshad;
			int div = 0;

			while (n > 0) {
				div += n % 10;
				n /= 10;
			}

			if (harshad % div == 0) {
				System.out.println(harshad);
				break;
			}
			harshad++;
		}
	}
}