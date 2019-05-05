/*
 * Author: Minho Kim (ISKU)
 * Date: May 4, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17178
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Ticket[] tickets = new Ticket[N * 5];
		Ticket[] sortedTickets = new Ticket[N * 5];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				String ticket = st.nextToken();
				char letter = ticket.charAt(0);
				int number = Integer.parseInt(ticket.substring(2, ticket.length()));

				tickets[i * 5 + j] = new Ticket(letter, number);
				sortedTickets[i * 5 + j] = new Ticket(letter, number);
			}
		}
		Arrays.sort(sortedTickets, new Comparator<Ticket>() {
			@Override
			public int compare(Ticket o1, Ticket o2) {
				if (o1.letter == o2.letter)
					return Integer.compare(o1.number, o2.number);
				return Character.compare(o1.letter, o2.letter);
			}
		});

		Stack<Ticket> stack = new Stack<>();
		int p = 0;
		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i].equals(sortedTickets[p])) {
				p++;
				continue;
			}
			while (!stack.isEmpty() && sortedTickets[p].equals(stack.peek())) {
				p++;
				stack.pop();
				continue;
			}
			stack.add(tickets[i]);
		}

		while (!stack.isEmpty()) {
			if (!sortedTickets[p].equals(stack.peek())) {
				System.out.println("BAD");
				System.exit(0);
			}
			p++;
			stack.pop();
		}

		System.out.println("GOOD");
	}

	private static class Ticket {
		public char letter;
		public int number;

		public Ticket(char letter, int number) {
			this.letter = letter;
			this.number = number;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Ticket) {
				Ticket ticket = (Ticket) obj;
				if (this.letter == ticket.letter && this.number == ticket.number)
					return true;
			}
			return false;
		}
	}
}