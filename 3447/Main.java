/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3447
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		while (input.hasNextLine()) {
			String line = input.nextLine();

			while (line.contains("BUG"))
				line = line.replace("BUG", "");
			System.out.println(line);
		}
	}
}