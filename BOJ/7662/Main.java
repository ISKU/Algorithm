/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.08
 * E-Mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/7662
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int testCase = Integer.parseInt(parser.nextToken());

		while (testCase-- > 0) {
			TreeMap<Integer, Integer> depq = new TreeMap<Integer, Integer>();
			int instructions = Integer.parseInt(input.readLine());

			while (instructions-- > 0) {
				parser = new StringTokenizer(input.readLine());
				String command = parser.nextToken();
				int value = Integer.parseInt(parser.nextToken());

				if (command.equals("I"))
					depq.put(value, depq.containsKey(value) ? depq.get(value) + 1 : 1);

				if (command.equals("D") && !depq.isEmpty()) {
					if (value == -1) {
						if (depq.get(depq.firstKey()) == 1)
							depq.pollFirstEntry();
						else
							depq.put(depq.firstKey(), depq.get(depq.firstKey()) - 1);
					}
					if (value == 1) {
						if (depq.get(depq.lastKey()) == 1)
							depq.pollLastEntry();
						else
							depq.put(depq.lastKey(), depq.get(depq.lastKey()) - 1);
					}
				}
			}

			if (depq.isEmpty())
				output.write("EMPTY\n");
			else
				output.write(String.format("%d %d\n", depq.lastKey(), depq.firstKey()));
		}

		output.close();
	}
}