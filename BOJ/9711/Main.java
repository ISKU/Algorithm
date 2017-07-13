/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.11.11
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9711
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer parser = new StringTokenizer(input.readLine());

		for (int testCase = Integer.parseInt(parser.nextToken()), count = 1; count <= testCase; count++) {
			parser = new StringTokenizer(input.readLine());
			output.append(String.format("Case #%d: %d\n", count,
					findfibonacciNumber(Long.parseLong(parser.nextToken()), Long.parseLong(parser.nextToken()))));
		}

		System.out.print(output);
	}

	private static long findfibonacciNumber(long nth, long modular) {
		long[][] fibonacci = new long[][] { { 1, 1 }, { 1, 0 } };
		long[][] matrix = new long[][] { { 1, 0 }, { 0, 1 } };

		while (nth != 0) {
			if (nth % 2 != 0)
				matrix = multiply(fibonacci, matrix, modular);
			fibonacci = multiply(fibonacci, fibonacci, modular);
			nth /= 2;
		}

		return matrix[0][1] % modular;
	}

	private static long[][] multiply(long[][] A, long[][] B, long modular) {
		long[][] newMatrix = new long[][] { { 0, 0 }, { 0, 0 } };

		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				for (int k = 0; k < 2; k++)
					newMatrix[i][j] = (newMatrix[i][j] + A[i][k] * B[k][j]) % modular;

		return newMatrix;
	}
}