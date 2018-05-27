/*
 * Author: Minho Kim (ISKU)
 * Date: May 25, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4378
 */

import java.util.*;

public class Main {

	private static String table = "       ;    M0,.9`12345678 L,-    VXSWDFGUHJKNBIO EARYCQZT P][";

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			for (char c : sc.nextLine().toCharArray())
				System.out.print(table.charAt(c - ' '));
			System.out.println();
		}
	}
}