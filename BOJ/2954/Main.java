/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.24
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2954
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		String[] sentence = new Scanner(System.in).nextLine().split("");
		StringBuilder output = new StringBuilder();

		for (int index = 0; index < sentence.length; index++) {
			output.append(sentence[index]);
			if (sentence[index].equals("a") || sentence[index].equals("e") || sentence[index].equals("i")
					|| sentence[index].equals("o") || sentence[index].equals("u"))
				index += 2;
		}

		System.out.print(output);
	}
}