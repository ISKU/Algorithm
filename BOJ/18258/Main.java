/*
 * Author: Minho Kim (ISKU)
 * Date: January 9, 2010
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/18258
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		LinkedList<String> q = new LinkedList<>();
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			switch (cmd) {
			case "push":
				q.addLast(st.nextToken());
				break;
			case "pop":
				bw.write(q.isEmpty() ? "-1" : q.removeFirst());
				bw.write('\n');
				break;
			case "front":
				bw.write(q.isEmpty() ? "-1" : q.getFirst());
				bw.write('\n');
				break;
			case "back":
				bw.write(q.isEmpty() ? "-1" : q.getLast());
				bw.write('\n');
				break;
			case "size":
				bw.write(String.valueOf(q.size()));
				bw.write('\n');
				break;
			case "empty":
				bw.write(q.isEmpty() ? '1' : '0');
				bw.write('\n');
				break;
			default:
				break;
			}
		}

		bw.close();
	}
}
