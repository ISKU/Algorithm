/*
 * Author: Minho Kim (ISKU)
 * Date: November 25, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16461
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = freq2int(st.nextToken());
			int B = freq2int(st.nextToken());
			char channel = st.nextToken().charAt(0);
			int freq = freq2int(st.nextToken());

			int answer = Math.min(check(A, 'A', freq, channel), check(B, 'B', freq, channel));
			bw.write(String.valueOf((answer >= 6) ? 6 : answer));
			bw.write('\n');
		}

		bw.close();
	}

	private static int check(int freq, char channel, int targetFreq, char targetChannel) {
		int up = freq;
		int down = freq;
		if (freq == targetFreq)
			return (channel == targetChannel) ? 0 : 1;

		for (int i = 1; i <= 6; i++) {
			up += 20;
			if (up > 146000)
				up = 144000;
			if (up == targetFreq)
				return (channel == targetChannel) ? i : i + 1;

			down -= 20;
			if (down < 144000)
				down = 146000;
			if (down == targetFreq)
				return (channel == targetChannel) ? i : i + 1;
		}

		return 6;
	}

	private static int freq2int(String freq) {
		int ret = 0;
		ret += Integer.parseInt(freq.substring(0, 3)) * 1000;
		ret += Integer.parseInt(freq.substring(4, 7));
		return ret;
	}
}