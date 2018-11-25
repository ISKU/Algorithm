/*
 * Author: Minho Kim (ISKU)
 * Date: November 25, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16459
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		List<String> contents = new ArrayList<>();
		while (true) {
			String line = br.readLine();
			if ("0".equals(line))
				break;
			contents.add(line);
		}

		String who = br.readLine();
		String where = br.readLine();
		String what = br.readLine();
		where = where.replaceAll("WHO", who);
		what = what.replaceAll("WHERE", where);
		what = what.replaceAll("WHO", who);

		for (String content : contents) {
			content = content.replaceAll("WHO", who);
			content = content.replaceAll("WHERE", where);
			content = content.replaceAll("WHAT", what);
			bw.write(content);
			bw.write('\n');
		}

		bw.close();
	}
}