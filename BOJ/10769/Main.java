/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.15
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10769
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		String sentence = new Scanner(System.in).nextLine();
		int happy = 0, sad = 0;

		while (sentence.contains(":-)")) {
			sentence = sentence.replaceFirst(":-[)]", "");
			happy++;
		}
		while (sentence.contains(":-(")) {
			sentence = sentence.replaceFirst(":-[(]", "");
			sad++;
		}

		System.out.println(
				(happy == 0 && sad == 0) ? "none" : (happy == sad) ? "unsure" : (happy > sad) ? "happy" : "sad");
	}
}