
/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.01
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4927
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int testCase = 1;

		while (true) {
			String expression = input.nextLine();
			if (expression.equals("."))
				break;

			String formular = expression.split("[.]")[0];
			String[] separation = formular.split("=");
			String calculate = separation[0];
			String[] result = separation[1].split("");
			int operator = calculate.indexOf("*");
			String[] operand = new String[2];

			if (operator != -1) {
				operand = calculate.split("[*]");
				String[] firstOperand = operand[0].split("");
				String[] secondOperand = operand[1].split("");
				int sumOfFirstOperand = 0;
				int sumOfSecondOperand = 0;
				int sumOfResult = 0;
				long productOfOperand;

				for (int index = 0; index < firstOperand.length; index++)
					sumOfFirstOperand += Integer.parseInt(firstOperand[index]);
				for (int index = 0; index < secondOperand.length; index++)
					sumOfSecondOperand += Integer.parseInt(secondOperand[index]);
				for (int index = 0; index < result.length; index++)
					sumOfResult += Integer.parseInt(result[index]);

				productOfOperand = (sumOfFirstOperand * sumOfSecondOperand) % 9;
				sumOfResult = sumOfResult % 9;

				System.out.printf("%d. %s\n", testCase++, productOfOperand == sumOfResult ? "PASS" : "NOT!");
			} else {
				operand = calculate.split("[+]");
				String[] firstOperand = operand[0].split("");
				String[] secondOperand = operand[1].split("");
				int sumOfFirstOperand = 0;
				int sumOfSecondOperand = 0;
				int sumOfResult = 0;
				long productOfOperand;

				for (int index = 0; index < firstOperand.length; index++)
					sumOfFirstOperand += Integer.parseInt(firstOperand[index]);
				for (int index = 0; index < secondOperand.length; index++)
					sumOfSecondOperand += Integer.parseInt(secondOperand[index]);
				for (int index = 0; index < result.length; index++)
					sumOfResult += Integer.parseInt(result[index]);

				productOfOperand = (sumOfFirstOperand + sumOfSecondOperand) % 9;
				sumOfResult = sumOfResult % 9;

				System.out.printf("%d. %s\n", testCase++, productOfOperand == sumOfResult ? "PASS" : "NOT!");
			}
		}
	}
}