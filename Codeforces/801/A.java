/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.04.16
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/801/A
 */

import java.util.*;
import java.io.*;
import java.math.*;

public class A {
	public static void main(String... args) throws IOException {
		Scanner input = new Scanner(System.in);
		String line = input.next();

		int answer = 0;
		while (line.contains("VK")) {
			line = line.replaceFirst("VK", "XX");
			answer++;
		}

		System.out.print(line.contains("VV") || line.contains("KK") ? answer + 1 : answer);
	}
}