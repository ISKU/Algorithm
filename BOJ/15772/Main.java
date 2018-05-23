/*
 * Author: Minho Kim (ISKU)
 * Date: May 22, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15772
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int r1, r2, r3, r4, f1, f2, f3, f4;
	private static HashMap<String, Customer> map;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		map = new HashMap<String, Customer>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		r3 = Integer.parseInt(st.nextToken());
		r4 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		f1 = Integer.parseInt(st.nextToken());
		f2 = Integer.parseInt(st.nextToken());
		f3 = Integer.parseInt(st.nextToken());
		f4 = Integer.parseInt(st.nextToken());

		int t = 0;
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			t++;

			if (!map.containsKey(name))
				map.put(name, new Customer(0, 0));

			Customer customer = map.get(name);
			if (command == 1) {
				customer.frequency++;
				customer.access = t;
			}
			if (command == 2) {
				bw.write(decision(t, customer.frequency, customer.access));
				bw.newLine();
			}
		}

		bw.close();
	}

	private static String decision(int t, int frequency, int access) {
		int f = frequency;
		int r = t - access;

		if (f == 0)
			return "None";

		if (r <= r1 && f <= f1)
			return "New Customer";
		if (r <= r2 && f <= f1)
			return "Promising";
		if (r <= r3 && f <= f1)
			return "About to Sleep";
		if (r <= r4 && f <= f1)
			return "Lost";
		if (r > r4 && f <= f1)
			return "Lost";

		if (r <= r1 && f <= f2)
			return "Potential Loyalist";
		if (r <= r2 && f <= f2)
			return "Potential Loyalist";
		if (r <= r3 && f <= f2)
			return "About to Sleep";
		if (r <= r4 && f <= f2)
			return "Hibernating";
		if (r > r4 && f <= f2)
			return "Lost";

		if (r <= r1 && f <= f3)
			return "Potential Loyalist";
		if (r <= r2 && f <= f3)
			return "Potential Loyalist";
		if (r <= r3 && f <= f3)
			return "Need Attention";
		if (r <= r4 && f <= f3)
			return "About to Leave";
		if (r > r4 && f <= f3)
			return "About to Leave";

		if (r <= r1 && f <= f4)
			return "Loyal Customer";
		if (r <= r2 && f <= f4)
			return "Loyal Customer";
		if (r <= r3 && f <= f4)
			return "Loyal Customer";
		if (r <= r4 && f <= f4)
			return "About to Leave";
		if (r > r4 && f <= f4)
			return "About to Leave";

		if (r <= r1 && f > f4)
			return "Champion";
		if (r <= r2 && f > f4)
			return "Loyal Customer";
		if (r <= r3 && f > f4)
			return "Loyal Customer";
		if (r <= r4 && f > f4)
			return "About to Leave";
		if (r > r4 && f > f4)
			return "Can't Lose Them";

		return "";
	}

	private static class Customer {
		public int frequency;
		public int access;

		public Customer(int frequency, int access) {
			this.frequency = frequency;
			this.access = access;
		}
	}
}