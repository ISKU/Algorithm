/*
 * Author: Minho Kim (ISKU)
 * Date: January 25, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2817
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double X = sc.nextDouble();

		int N = sc.nextInt();
		Staff[] staff = new Staff[N];
		for (int i = 0; i < N; i++)
			staff[i] = new Staff(sc.next(), sc.nextDouble());

		List<Node> list = new ArrayList<>();
		double limit = X * 0.05;
		for (int i = 0; i < N; i++) {
			if (staff[i].vote < limit) {
				staff[i].check = true;
				continue;
			}
			for (int j = 1; j <= 14; j++)
				list.add(new Node(i, staff[i].vote / j));
		}

		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Double.compare(o2.value, o1.value);
			}
		});
		for (int i = 0; i < 14; i++)
			staff[list.get(i).index].score++;

		Arrays.sort(staff, new Comparator<Staff>() {
			@Override
			public int compare(Staff o1, Staff o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		for (int i = 0; i < N; i++) {
			if (staff[i].check)
				continue;
			System.out.printf("%s %d\n", staff[i].name, staff[i].score);
		}
	}

	private static class Staff {
		public String name;
		public double vote;
		public int score;
		public boolean check;

		public Staff(String name, double vote) {
			this.name = name;
			this.vote = vote;
		}
	}

	private static class Node {
		public int index;
		public double value;

		public Node(int index, double value) {
			this.index = index;
			this.value = value;
		}
	}
}