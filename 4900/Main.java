/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.24
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4900
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		StringBuilder output = new StringBuilder();

		while (true) {
			String equation = input.nextLine();
			String[] number = equation.split("=")[0].split("[+]");
			StringBuilder numberA = new StringBuilder();
			StringBuilder numberB = new StringBuilder();
			StringBuilder result = new StringBuilder();

			if (equation.equals("BYE"))
				break;

			int digitA = number[0].length() / 3;
			int digitB = number[1].length() / 3;

			for (int count = 0; count < digitA; count++) {
				StringBuilder digit = new StringBuilder();
				for (int index = 0; index < 3; index++)
					digit.append(number[0].charAt(count * 3 + index));
				numberA.append(codeToInteger(digit.toString()));
			}

			for (int count = 0; count < digitB; count++) {
				StringBuilder digit = new StringBuilder();
				for (int index = 0; index < 3; index++)
					digit.append(number[1].charAt(count * 3 + index));
				numberB.append(codeToInteger(digit.toString()));
			}

			String[] sum = String.valueOf(Integer.parseInt(numberA.toString()) + Integer.parseInt(numberB.toString())).split("");
			for (int index = 0; index < sum.length; index++)
				result.append(integerToCode(Integer.parseInt(sum[index])));
			output.append(equation + result + "\n");
		}

		System.out.print(output);
	}

	private static int codeToInteger(String code) {
		String binary = Integer.toBinaryString(Integer.parseInt(code));

		switch (binary) {
		case "111111":
			return 0;
		case "1010":
			return 1;
		case "1011101":
			return 2;
		case "1001111":
			return 3;
		case "1101010":
			return 4;
		case "1100111":
			return 5;
		case "1110111":
			return 6;
		case "1011":
			return 7;
		case "1111111":
			return 8;
		case "1101011":
			return 9;
		default:
			return -1;
		}
	}

	private static String integerToCode(int integer) {
		switch (integer) {
		case 0:
			return "063";
		case 1:
			return "010";
		case 2:
			return "093";
		case 3:
			return "079";
		case 4:
			return "106";
		case 5:
			return "103";
		case 6:
			return "119";
		case 7:
			return "011";
		case 8:
			return "127";
		case 9:
			return "107";
		default:
			return "000";
		}
	}
}