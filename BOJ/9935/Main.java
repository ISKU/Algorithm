/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9935
 */

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Stack<Character> stackOutputLine = new Stack<Character>(); // output line, set of characters
		Stack<Character> buffer = new Stack<Character>(); // store the deleted character.

		// initialization
		String firstLine = input.next(); // input, first line
		String explosion = input.next(); // input explosion string, second line
		int firstLineLength = firstLine.length();
		int explosionLength = explosion.length();
		char explosionFirstCharacter = explosion.charAt(0); // first letter of the explosion

		for (int index = firstLineLength - 1; index >= 0; index--) {
			char currentCharacter = firstLine.charAt(index);
			stackOutputLine.push(currentCharacter);
			if (currentCharacter == explosionFirstCharacter) { // check explosion string
				for (int explosionIndex = 0, explosionCharacterCheckCount = 0; explosionIndex < explosionLength; explosionIndex++) {
					if (!stackOutputLine.isEmpty() && stackOutputLine.peek() == explosion.charAt(explosionIndex)) {
						buffer.push(stackOutputLine.pop()); // deleted explosion
						explosionCharacterCheckCount++;
					} else {
						for (int restoreExplosionCount = 0; restoreExplosionCount < explosionCharacterCheckCount; restoreExplosionCount++)
							if (!buffer.isEmpty())
								stackOutputLine.push(buffer.pop()); // if not explosion string
						break; // next
					}
				}
			}
		}

		StringBuilder output = new StringBuilder();
		if (stackOutputLine.isEmpty()) // if nothing remains, output “FRULA”
			output.append("FRULA");
		else
			while (stackOutputLine.isEmpty() == false)
				output.append(stackOutputLine.pop());

		System.out.println(output);
		// final string remaining after all the reactions as stated in the task.
	}
}