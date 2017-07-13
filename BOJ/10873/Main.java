/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10873
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		StringBuilder output = new StringBuilder();
		int testCase = Integer.parseInt(input.nextLine());

		while (testCase-- > 0)
			output.append(query(input.nextLine(), input.nextLine()));
		System.out.print(output);
	}

	private static String query(String state, String question) {
		switch (state) {
		case "1":
			return "how to install " + question + "\n";
		case "2":
			return "what is " + question + "\n";
		case "3":
			return question + " not working\n";
		case "4":
			return "why use " + question + "\n";
		case "5":
			return "who use " + question + "\n";
		case "6":
			return "disadvantages of " + question + "\n";
		case "7":
			return "advantages of " + question + "\n";
		case "8":
			return question + " open source projects\n";
		case "9":
			return question + " tutorial\n";
		case "10":
			return question + " performance\n";
		case "11":
			return question + " sucks\n";
		case "12":
			return "getting started " + question + "\n";
		case "14":
			return question + " reference\n";
		case "15":
			return question + " solution\n";
		case "16":
			return question + " example code\n";
		case "17":
			return "difference between " + question + " and C++\n";
		case "18":
			return question + " site:acmicpc.net\n";
		case "19":
			return question + " filetype:pdf\n";
		case "20":
			return question + " slides\n";
		case "21":
			return "how to make " + question + "\n";
		case "22":
			return question + " jobs\n";
		case "23":
			return question + " time\n";
		case "24":
			return "best os x " + question + " app\n";
		default:
			return question + "\n";
		}
	}
}