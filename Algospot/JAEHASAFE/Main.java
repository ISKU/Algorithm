/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.05
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://algospot.com/judge/problem/read/JAEHASAFE
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int N = input.nextInt();
			String origin = input.next();

			int answer = 0;
			for (int i = 0; i < N; i++) {
				String target = input.next();
				answer += ((i & 1) == 1) ? 
						kmp(origin + origin, target).get(0) :
						kmp(target + target, origin).get(0);
				origin = target;
			}

			System.out.println(answer);
		}
	}

	public static ArrayList<Integer> kmp(String N, String M) {
		ArrayList<Integer> pi = getPartialMatch(M);
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int n = N.length(), m = M.length();
		int begin = 0, matched = 0;

		while (begin <= n - m) {
			if (matched < m && N.charAt(begin + matched) == M.charAt(matched)) {
				if (++matched == m)
					ret.add(begin);
			} else {
				if (matched == 0)
					begin++;
				else {
					begin += matched - pi.get(matched - 1);
					matched = pi.get(matched - 1);
				}
			}
		}

		return ret;
	}

	static ArrayList<Integer> getPartialMatch(String M) {
		ArrayList<Integer> pi = new ArrayList<Integer>();
		int m = M.length();
		int begin = 1, matched = 0;

		for (int i = 0; i < m; i++)
			pi.add(0);

		while (begin + matched < m) {
			if (M.charAt(begin + matched) == M.charAt(matched)) {
				matched++;
				pi.set(begin + matched - 1, matched);
			} else {
				if (matched == 0)
					begin++;
				else {
					begin += matched - pi.get(matched - 1);
					matched = pi.get(matched - 1);
				}
			}
		}

		return pi;
	}
}
