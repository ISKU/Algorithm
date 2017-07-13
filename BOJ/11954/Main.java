/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.29
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11954
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		char[] nizovi = new Scanner(System.in).next().toCharArray();
		StringBuilder output = new StringBuilder();
		String space = "  ";
		int depth = 0;
		boolean check = false;

		for (int i = 0; i < nizovi.length; i++) {
			switch (nizovi[i]) {
			case '{':
				if (check)
					for (int j = 0; j < depth; j++)
						output.append(space);
				output.append("{\n");
				depth++;
				check = true;
				break;
			case '}':
				output.append(check ? "" : "\n");
				depth--;
				for (int j = 0; j < depth; j++)
					output.append(space);
				output.append("}");
				check = false;
				break;
			case ',':
				output.append(",\n");
				for (int j = 0; j < depth; j++)
					output.append(space);
				check = false;
				break;
			default:
				if (check)
					for (int j = 0; j < depth; j++)
						output.append(space);
				output.append(nizovi[i]);
				check = false;
			}
		}

		System.out.print(output);
	}
}