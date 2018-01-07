/* 
 * Author: Minho Kim (ISKU)
 * Date: January 7, 2018
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5598
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		char[] letter = new char[] { 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W' };
		for (char c : new Scanner(System.in).nextLine().toCharArray())
			System.out.print(letter[(c % 65)]);
	}
}