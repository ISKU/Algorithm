/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.28
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10545
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder output = new StringBuilder();
		int[] keyNumber = new int[10];
		int lastButton = 0;

		for (int index = 1; index < keyNumber.length; index++)
			keyNumber[input.nextInt()] = index;

		String[] string = input.next().split("");
		for (int index = 0; index < string.length; index++) {
			StringBuilder count = new StringBuilder();
			switch (string[index]) {
			case "c":
				count.append(keyNumber[2]);
			case "b":
				count.append(keyNumber[2]);
			case "a":
				count.append(keyNumber[2]);
				if (lastButton == 2)
					output.append("#");
				output.append(count);
				lastButton = 2;
				break;
			case "f":
				count.append(keyNumber[3]);
			case "e":
				count.append(keyNumber[3]);
			case "d":
				count.append(keyNumber[3]);
				if (lastButton == 3)
					output.append("#");
				output.append(count);
				lastButton = 3;
				break;
			case "i":
				count.append(keyNumber[4]);
			case "h":
				count.append(keyNumber[4]);
			case "g":
				count.append(keyNumber[4]);
				if (lastButton == 4)
					output.append("#");
				output.append(count);
				lastButton = 4;
				break;
			case "l":
				count.append(keyNumber[5]);
			case "k":
				count.append(keyNumber[5]);
			case "j":
				count.append(keyNumber[5]);
				if (lastButton == 5)
					output.append("#");
				output.append(count);
				lastButton = 5;
				break;
			case "o":
				count.append(keyNumber[6]);
			case "n":
				count.append(keyNumber[6]);
			case "m":
				count.append(keyNumber[6]);
				if (lastButton == 6)
					output.append("#");
				output.append(count);
				lastButton = 6;
				break;
			case "s":
				count.append(keyNumber[7]);
			case "r":
				count.append(keyNumber[7]);
			case "q":
				count.append(keyNumber[7]);
			case "p":
				count.append(keyNumber[7]);
				if (lastButton == 7)
					output.append("#");
				output.append(count);
				lastButton = 7;
				break;
			case "v":
				count.append(keyNumber[8]);
			case "u":
				count.append(keyNumber[8]);
			case "t":
				count.append(keyNumber[8]);
				if (lastButton == 8)
					output.append("#");
				output.append(count);
				lastButton = 8;
				break;
			case "z":
				count.append(keyNumber[9]);
			case "y":
				count.append(keyNumber[9]);
			case "x":
				count.append(keyNumber[9]);
			case "w":
				count.append(keyNumber[9]);
				if (lastButton == 9)
					output.append("#");
				output.append(count);
				lastButton = 9;
				break;
			}
		}

		System.out.print(output);
	}
}