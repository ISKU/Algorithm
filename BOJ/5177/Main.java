/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.11
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5177
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = Integer.parseInt(input.nextLine());

		for (int i = 1; i <= testCase; i++) {
			String first = input.nextLine().toLowerCase();
			String second = input.nextLine().toLowerCase();

			while (first.contains("  "))
				first = first.replaceAll("  ", " ");
			while (second.contains("  "))
				second = second.replaceAll("  ", " ");

			while (first.startsWith(" "))
				first = first.substring(1, first.length());
			while (second.startsWith(" "))
				second = second.substring(1, second.length());

			while (first.endsWith(" "))
				first = first.substring(0, first.length() - 1);
			while (second.endsWith(" "))
				second = second.substring(0, second.length() - 1);

			first = first.replaceAll(",", ";");
			second = second.replaceAll(",", ";");
			first = first.replaceAll("[{]", "(");
			second = second.replaceAll("[{]", "(");
			first = first.replaceAll("[}]", ")");
			second = second.replaceAll("[}]", ")");
			first = first.replaceAll("\\[", "(");
			second = second.replaceAll("\\[", "(");
			first = first.replaceAll("\\]", "(");
			second = second.replaceAll("\\]", ")");

			while (first.contains(" ("))
				first = first.replaceAll(" \\(", "(");
			while (first.contains("( "))
				first = first.replaceAll("\\( ", "(");
			while (second.contains(" ("))
				second = second.replaceAll(" \\(", "(");
			while (second.contains("( "))
				second = second.replaceAll("\\( ", "(");

			while (first.contains(" ;"))
				first = first.replaceAll(" ;", ";");
			while (first.contains("; "))
				first = first.replaceAll("; ", ";");
			while (second.contains(" ;"))
				second = second.replaceAll(" ;", ";");
			while (second.contains("; "))
				second = second.replaceAll("; ", ";");

			while (first.contains(" ."))
				first = first.replaceAll(" .", ".");
			while (first.contains(". "))
				first = first.replaceAll(". ", ".");
			while (second.contains(" ."))
				second = second.replaceAll(" .", ".");
			while (second.contains(". "))
				second = second.replaceAll(". ", ".");

			while (first.contains(" :"))
				first = first.replaceAll(" :", ":");
			while (first.contains(": "))
				first = first.replaceAll(": ", ":");
			while (second.contains(" :"))
				second = second.replaceAll(" :", ":");
			while (second.contains(": "))
				second = second.replaceAll(": ", ":");

			System.out.println(String.format("Data Set %d: %s\n", i, first.equals(second) ? "equal" : "not equal"));
		}
	}
}