/*
 * Author: Minho Kim (ISKU)
 * Date: November 17, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16506
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		while (N-- > 0) {
			String op = sc.next();
			int rD = sc.nextInt();
			int rA = sc.nextInt();
			int rB = sc.nextInt();

			String code = convert(op, rD, rA, rB);
			System.out.println(code);
		}
	}

	private static String convert(String op, int rD, int rA, int rB) {
		String code = "";

		code += toOpcode(op); // 0-4
		code += "0"; // 5
		code += toBinary(rD, 3); // 6-8
		code += toBinary(rA, 3); // 9-11

		if (op.charAt(op.length() - 1) == 'C') {
			code += toBinary(rB, 4); // 12-15
		} else {
			code += toBinary(rB, 3); // 12-14
			code += "0"; // 15
		}

		return code;
	}

	private static String toBinary(int value, int size) {
		int[] binary = new int[] { 0, 0, 0, 0 };

		for (int i = 3; i >= 0; i--) {
			binary[i] = value % 2;
			value /= 2;
		}

		String ret = "";
		for (int i = 4 - size; i < 4; i++)
			ret += String.valueOf(binary[i]);

		return ret;
	}

	private static String toOpcode(String op) {
		switch (op) {
		case "ADD":
			return "00000";
		case "ADDC":
			return "00001";
		case "SUB":
			return "00010";
		case "SUBC":
			return "00011";
		case "MOV":
			return "00100";
		case "MOVC":
			return "00101";
		case "AND":
			return "00110";
		case "ANDC":
			return "00111";
		case "OR":
			return "01000";
		case "ORC":
			return "01001";
		case "NOT":
			return "01010";
		case "MULT":
			return "01100";
		case "MULTC":
			return "01101";
		case "LSFTL":
			return "01110";
		case "LSFTLC":
			return "01111";
		case "LSFTR":
			return "10000";
		case "LSFTRC":
			return "10001";
		case "ASFTR":
			return "10010";
		case "ASFTRC":
			return "10011";
		case "RL":
			return "10100";
		case "RLC":
			return "10101";
		case "RR":
			return "10110";
		case "RRC":
			return "10111";
		default:
			return "";
		}
	}
}