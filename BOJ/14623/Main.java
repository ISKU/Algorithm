/*
 * Author: Minho Kim (ISKU)
 * Date: March 31, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14623
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		System.out.print(Long.toBinaryString(Long.parseLong(input.next(), 2) * Long.parseLong(input.next(), 2)));
	}
}