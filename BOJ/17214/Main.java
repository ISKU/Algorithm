/*
 * Author: Minho Kim (ISKU)
 * Date: May 20, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17214
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String polynomial = br.readLine();
		if (polynomial.equals("0")) {
			bw.write("W");
			bw.close();
			System.exit(0);
		}

		StringTokenizer st = new StringTokenizer(polynomial, "+|-");
		List<String> terms = new ArrayList<>();
		for (int s = 0; st.hasMoreTokens();) {
			String term = st.nextToken();
			s = polynomial.indexOf(term, s) - 1;
			if (s >= 0 && polynomial.charAt(s) == '-')
				term = "-" + term;

			terms.add(term);
			s += term.length();
		}

		for (int i = 0; i < terms.size(); i++) {
			String term = terms.get(i);
			int sx = term.indexOf('x');
			if (sx == -1)
				sx = term.length();

			int n = term.length() - sx + 1;
			int coefficient = ((sx == 0) ? 1 : Integer.parseInt(term.substring(0, sx))) / n;
			if (coefficient == 0)
				continue;

			if (i >= 1 && coefficient > 0)
				bw.write('+');
			if (coefficient != 1)
				bw.write((coefficient == -1) ? "-" : String.valueOf(coefficient));
			for (int j = n; j > 0; j--)
				bw.write('x');
		}
		bw.write("+W");
		bw.close();
	}
}