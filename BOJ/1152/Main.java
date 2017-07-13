/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.01
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1152
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		ArrayList<String> frequencyTable = new ArrayList<String>(); // the number of each word
		String[] word = input.nextLine().split(" "); // input, sentence

		// add the number of words to arraylist
		for (int index = 0; index < word.length; index++) {
			if (word[index].equals(""))
				continue;
			frequencyTable.add(word[index]);
		}

		// output, total number of words
		System.out.println(frequencyTable.size());
	}
}