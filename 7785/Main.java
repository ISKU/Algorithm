/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.26
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/7785
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Collections;

public class Main {
	public static void main(String... args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		TreeMap<String, Boolean> table = new TreeMap<String, Boolean>(Collections.reverseOrder());
		StringTokenizer parser = new StringTokenizer(input.readLine());

		int n = Integer.parseInt(parser.nextToken());

		while (n-- > 0) {
			parser = new StringTokenizer(input.readLine());
			String name = parser.nextToken();
			String state = parser.nextToken();

			if (state.equals("enter"))
				table.put(name, true);
			else
				table.remove(name);
		}

		for (String key : table.keySet())
			output.write(key + "\n");
		output.close();
	}
}