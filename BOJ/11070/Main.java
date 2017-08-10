/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.10
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11070
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			Team[] teams = new Team[input.nextInt() + 1];
			for (int i = 1; i < teams.length; i++)
				teams[i] = new Team(0, 0);

			int m = input.nextInt();
			while (m-- > 0) {
				int a = input.nextInt();
				int b = input.nextInt();
				double p = input.nextDouble();
				double q = input.nextDouble();
				teams[a].S += p;
				teams[a].A += q;
				teams[b].S += q;
				teams[b].A += p;
			}

			double max = 0;
			double min = Double.MAX_VALUE;
			for (int i = 1; i < teams.length; i++) {
				double W = (teams[i].S == 0 && teams[i].A == 0) ? 0
						: (teams[i].S * teams[i].S) / ((teams[i].S * teams[i].S) + (teams[i].A * teams[i].A));
				max = Math.max(max, W);
				min = Math.min(min, W);
			}

			System.out.println((int) (max * 1000));
			System.out.println((int) (min * 1000));
		}
	}

	private static class Team {
		public double S;
		public double A;

		public Team(int plus, int minus) {
			this.S = plus;
			this.A = minus;
		}
	}
}