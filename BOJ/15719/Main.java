/*
 * Author: Minho Kim (ISKU)
 * Date: May 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15719
 */

public class Main {

	private static byte[] buffer = new byte[78888905];
	private static byte[] set = new byte[10000000];
	private static int next;
	private static byte b;

	public static void main(String... args) throws Exception {
		System.in.read(buffer, 0, buffer.length);

		int N = nextInt();
		while (N-- > 0) {
			int n = nextInt();

			if (set[n] == 1) {
				System.out.print(n);
				break;
			}

			set[n] = 1;
		}
	}

	private static int nextInt() {
		int n = buffer[next++] - '0';
		while ((b = buffer[next++]) >= '0')
			n = (n * 10) + (b - '0');
		return n;
	}
}