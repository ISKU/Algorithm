/*
 * Author: Minho Kim (ISKU)
 * Date: January 29, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/918/B
 */

import java.util.*;
import java.io.*;

public class B {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, String> ips = new HashMap<String, String>();
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String domain = st.nextToken();
			String ip = st.nextToken() + ";";
			ips.put(ip, domain);
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			String domain = st.nextToken();
			String ip = st.nextToken();
			bw.write(String.format("%s %s #%s\n", domain, ip, ips.get(ip)));
		}

		bw.close();
	}
}