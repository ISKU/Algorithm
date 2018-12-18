/*
 * Author: Minho Kim (ISKU)
 * Date: December 8, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11921
 */

public class Main {
	public static void main(String[] args) throws Exception {
		byte[] buffer = new byte[7200000];
		int next = 8;
		int i = 0;
		long sum = 0;
		int n;
		byte b;

		System.in.read(buffer, 0, buffer.length);
		for (; i < 900000; i++) {
			n = buffer[next++] - '0';
			while ((b = buffer[next++]) != '\n')
				n = n * 10 + b - '0';

			sum += n;
		}

		next = 7;
		buffer[0] = '9';
		buffer[1] = '0';
		buffer[2] = '0';
		buffer[3] = '0';
		buffer[4] = '0';
		buffer[5] = '0';
		buffer[6] = '\n';

		n = 1000;
		while (sum > 0) {
			buffer[n++] = (byte) (sum % 10 + '0');
			sum /= 10;
		}
		while (n-- > 1000)
			buffer[next++] = buffer[n];

		System.out.write(buffer, 0, next);
	}
}