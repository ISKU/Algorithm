/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.13
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12414
 */

import java.util.Scanner;
import java.util.Hashtable;
import java.util.ArrayList;

public class Main {

	private static Hashtable<String, ArrayList<String>> table;
	private static Hashtable<String, Boolean> visited;
	private static ArrayList<String> goal;
	private static StringBuilder output;
	private static int count;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = Integer.parseInt(input.nextLine());

		for (int tCase = 1; tCase <= testCase; tCase++) {
			table = new Hashtable<String, ArrayList<String>>();
			visited = new Hashtable<String, Boolean>();
			goal = new ArrayList<String>();
			output = new StringBuilder();
			count = 0;

			for (int i = Integer.parseInt(input.nextLine()); i > 0; i--) {
				String[] tech = input.nextLine().split(":");

				ArrayList<String> prev = table.containsKey(tech[0]) ? table.get(tech[0]) : new ArrayList<String>();
				prev.add(tech[1]);
				table.put(tech[0], prev);

				if (!visited.containsKey(tech[0]))
					visited.put(tech[0], false);
				if (!visited.containsKey(tech[1]))
					visited.put(tech[1], false);
			}

			for (int i = Integer.parseInt(input.nextLine()); i > 0; i--)
				goal.add(input.nextLine());

			for (int i = 0; i < goal.size(); i++)
				plan(goal.get(i));

			System.out.printf("Case #%s: %d\n%s", tCase, count, output);
		}
	}

	private static void plan(String goal) {
		if (table.containsKey(goal))
			for (String element : table.get(goal))
				if (!visited.get(element))
					plan(element);

		visited.put(goal, true);
		output.append(goal).append("\n");
		count++;
	}
}