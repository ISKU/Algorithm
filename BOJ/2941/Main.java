/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.10.01
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2941
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		String line = new Scanner(System.in).next();
		String[] croatian = new String[] { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		for (String letter : croatian)
			line = line.replaceAll(letter, " ");

		System.out.print(line.length());
	}
}