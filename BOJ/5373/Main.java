/*
 * Author: Minho Kim (ISKU)
 * Date: November 22, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5373
 */

import java.util.*;
import java.io.*;

public class Main {

	private static BufferedWriter bw;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Cube cube = new Cube();

			while (N-- > 0) {
				String cmd = st.nextToken();

				if ("L-".equals(cmd))
					cube.ccwL();
				else if ("L+".equals(cmd))
					cube.cwL();
				else if ("R-".equals(cmd))
					cube.ccwR();
				else if ("R+".equals(cmd))
					cube.cwR();
				else if ("F-".equals(cmd))
					cube.ccwF();
				else if ("F+".equals(cmd))
					cube.cwF();
				else if ("B-".equals(cmd))
					cube.ccwB();
				else if ("B+".equals(cmd))
					cube.cwB();
				else if ("U-".equals(cmd))
					cube.ccwU();
				else if ("U+".equals(cmd))
					cube.cwU();
				else if ("D-".equals(cmd))
					cube.ccwD();
				else if ("D+".equals(cmd))
					cube.cwD();
			}

			cube.print();
		}

		bw.close();
	}

	private static class Cube {

		private static char[][] U, D, F, B, L, R;

		public Cube() {
			U = new char[3][3];
			D = new char[3][3];
			F = new char[3][3];
			B = new char[3][3];
			L = new char[3][3];
			R = new char[3][3];

			for (int y = 0; y < 3; y++) {
				for (int x = 0; x < 3; x++) {
					U[y][x] = 'w';
					D[y][x] = 'y';
					F[y][x] = 'r';
					B[y][x] = 'o';
					L[y][x] = 'g';
					R[y][x] = 'b';
				}
			}
		}

		public void ccwD() {
			rotateR(D);
			char a = F[2][0];
			char b = F[2][1];
			char c = F[2][2];
			F[2][0] = R[2][0];
			F[2][1] = R[2][1];
			F[2][2] = R[2][2];
			R[2][0] = B[2][2];
			R[2][1] = B[2][1];
			R[2][2] = B[2][0];
			B[2][2] = L[2][0];
			B[2][1] = L[2][1];
			B[2][0] = L[2][2];
			L[2][0] = a;
			L[2][1] = b;
			L[2][2] = c;
		}

		public void cwD() {
			rotateL(D);
			char a = F[2][2];
			char b = F[2][1];
			char c = F[2][0];
			F[2][2] = L[2][2];
			F[2][1] = L[2][1];
			F[2][0] = L[2][0];
			L[2][2] = B[2][0];
			L[2][1] = B[2][1];
			L[2][0] = B[2][2];
			B[2][0] = R[2][2];
			B[2][1] = R[2][1];
			B[2][2] = R[2][0];
			R[2][2] = a;
			R[2][1] = b;
			R[2][0] = c;
		}

		public void ccwR() {
			rotateL(R);
			char a = U[2][2];
			char b = U[1][2];
			char c = U[0][2];
			U[2][2] = B[0][2];
			U[1][2] = B[1][2];
			U[0][2] = B[2][2];
			B[0][2] = D[0][2];
			B[1][2] = D[1][2];
			B[2][2] = D[2][2];
			D[0][2] = F[2][2];
			D[1][2] = F[1][2];
			D[2][2] = F[0][2];
			F[2][2] = a;
			F[1][2] = b;
			F[0][2] = c;
		}

		public void cwR() {
			rotateR(R);
			char a = U[0][2];
			char b = U[1][2];
			char c = U[2][2];
			U[0][2] = F[0][2];
			U[1][2] = F[1][2];
			U[2][2] = F[2][2];
			F[0][2] = D[2][2];
			F[1][2] = D[1][2];
			F[2][2] = D[0][2];
			D[2][2] = B[2][2];
			D[1][2] = B[1][2];
			D[0][2] = B[0][2];
			B[2][2] = a;
			B[1][2] = b;
			B[0][2] = c;
		}

		public void ccwU() {
			rotateL(U);
			char a = B[0][0];
			char b = B[0][1];
			char c = B[0][2];
			B[0][0] = R[0][2];
			B[0][1] = R[0][1];
			B[0][2] = R[0][0];
			R[0][2] = F[0][2];
			R[0][1] = F[0][1];
			R[0][0] = F[0][0];
			F[0][2] = L[0][2];
			F[0][1] = L[0][1];
			F[0][0] = L[0][0];
			L[0][2] = a;
			L[0][1] = b;
			L[0][0] = c;
		}

		public void cwU() {
			rotateR(U);
			char a = B[0][2];
			char b = B[0][1];
			char c = B[0][0];
			B[0][2] = L[0][0];
			B[0][1] = L[0][1];
			B[0][0] = L[0][2];
			L[0][0] = F[0][0];
			L[0][1] = F[0][1];
			L[0][2] = F[0][2];
			F[0][0] = R[0][0];
			F[0][1] = R[0][1];
			F[0][2] = R[0][2];
			R[0][0] = a;
			R[0][1] = b;
			R[0][2] = c;
		}

		public void ccwB() {
			rotateR(B);
			char a = U[0][2];
			char b = U[0][1];
			char c = U[0][0];
			U[0][2] = L[0][0];
			U[0][1] = L[1][0];
			U[0][0] = L[2][0];
			L[0][0] = D[0][0];
			L[1][0] = D[0][1];
			L[2][0] = D[0][2];
			D[0][0] = R[2][2];
			D[0][1] = R[1][2];
			D[0][2] = R[0][2];
			R[2][2] = a;
			R[1][2] = b;
			R[0][2] = c;
		}

		public void cwB() {
			rotateL(B);
			char a = U[0][0];
			char b = U[0][1];
			char c = U[0][2];
			U[0][0] = R[0][2];
			U[0][1] = R[1][2];
			U[0][2] = R[2][2];
			R[0][2] = D[0][2];
			R[1][2] = D[0][1];
			R[2][2] = D[0][0];
			D[0][2] = L[2][0];
			D[0][1] = L[1][0];
			D[0][0] = L[0][0];
			L[2][0] = a;
			L[1][0] = b;
			L[0][0] = c;
		}

		public void ccwF() {
			rotateL(F);
			char a = U[2][0];
			char b = U[2][1];
			char c = U[2][2];
			U[2][0] = R[0][0];
			U[2][1] = R[1][0];
			U[2][2] = R[2][0];
			R[0][0] = D[2][2];
			R[1][0] = D[2][1];
			R[2][0] = D[2][0];
			D[2][2] = L[2][2];
			D[2][1] = L[1][2];
			D[2][0] = L[0][2];
			L[2][2] = a;
			L[1][2] = b;
			L[0][2] = c;
		}

		public void cwF() {
			rotateR(F);
			char a = U[2][2];
			char b = U[2][1];
			char c = U[2][0];
			U[2][2] = L[0][2];
			U[2][1] = L[1][2];
			U[2][0] = L[2][2];
			L[0][2] = D[2][0];
			L[1][2] = D[2][1];
			L[2][2] = D[2][2];
			D[2][0] = R[2][0];
			D[2][1] = R[1][0];
			D[2][2] = R[0][0];
			R[2][0] = a;
			R[1][0] = b;
			R[0][0] = c;
		}

		public void ccwL() {
			rotateL(L);
			char a = U[0][0];
			char b = U[1][0];
			char c = U[2][0];
			U[0][0] = F[0][0];
			U[1][0] = F[1][0];
			U[2][0] = F[2][0];
			F[0][0] = D[2][0];
			F[1][0] = D[1][0];
			F[2][0] = D[0][0];
			D[2][0] = B[2][0];
			D[1][0] = B[1][0];
			D[0][0] = B[0][0];
			B[2][0] = a;
			B[1][0] = b;
			B[0][0] = c;
		}

		public void cwL() {
			rotateR(L);
			char a = U[2][0];
			char b = U[1][0];
			char c = U[0][0];
			U[2][0] = B[0][0];
			U[1][0] = B[1][0];
			U[0][0] = B[2][0];
			B[0][0] = D[0][0];
			B[1][0] = D[1][0];
			B[2][0] = D[2][0];
			D[0][0] = F[2][0];
			D[1][0] = F[1][0];
			D[2][0] = F[0][0];
			F[2][0] = a;
			F[1][0] = b;
			F[0][0] = c;
		}

		private static void rotateL(char[][] T) {
			char a = T[0][0];
			char b = T[0][1];
			char c = T[0][2];
			T[0][0] = T[0][2];
			T[0][1] = T[1][2];
			T[0][2] = T[2][2];
			T[1][2] = T[2][1];
			T[2][2] = T[2][0];
			T[2][1] = T[1][0];
			T[2][0] = a;
			T[1][0] = b;
			T[0][0] = c;
		}

		private static void rotateR(char[][] T) {
			char a = T[0][0];
			char b = T[0][1];
			char c = T[0][2];
			T[0][2] = T[0][0];
			T[0][1] = T[1][0];
			T[0][0] = T[2][0];
			T[1][0] = T[2][1];
			T[2][0] = T[2][2];
			T[2][1] = T[1][2];
			T[2][2] = c;
			T[1][2] = b;
			T[0][2] = a;
		}

		public void print() throws Exception {
			for (int y = 0; y < 3; y++) {
				for (int x = 0; x < 3; x++)
					bw.write(U[y][x]);
				bw.write('\n');
			}
		}
	}
}