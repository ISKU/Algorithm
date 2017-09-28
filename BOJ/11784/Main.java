/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.09.28
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11784
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (input.hasNext()) {
			String[] hex = input.next().split("");
			for (int i = 0; i < hex.length; i += 2)
				System.out.print((char) Integer.parseInt(hex[i] + hex[i + 1], 16));
			System.out.println();
		}
	}
}