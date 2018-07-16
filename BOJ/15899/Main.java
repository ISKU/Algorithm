/*
 * Author: Minho Kim (ISKU)
 * Date: July 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15899
 */

import java.util.*;
import java.io.*;

public class Main {

	public static long MOD = 1000000007;

	private static ArrayList<Integer>[] tree, segtree;
	private static int[] color, start, end;
	private static boolean[] visited;
	private static int order, H;

	private static void solve() {
		int N = io.nextInt();
		int M = io.nextInt();
		int C = io.nextInt();

		color = new int[N + 1];
		for (int i = 1; i <= N; i++)
			color[i] = io.nextInt();

		tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			tree[i] = new ArrayList<Integer>();

		for (int i = 1; i < N; i++) {
			int u = io.nextInt();
			int v = io.nextInt();
			tree[u].add(v);
			tree[v].add(u);
		}

		start = new int[N + 1];
		end = new int[N + 1];
		visited = new boolean[N + 1];
		dfs(1);

		H = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));
		segtree = new ArrayList[H * 2];
		for (int i = 1; i < segtree.length; i++)
			segtree[i] = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++)
			segtree[start[i] + H - 1].add(color[i]);
		build(1, H, 1);

		long sum = 0;
		while (M-- > 0) {
			int v = io.nextInt();
			int c = io.nextInt();
			sum = (sum + query(1, H, 1, start[v], end[v], c)) % MOD;
		}

		io.print(sum);
	}

	private static int query(int l, int r, int i, int L, int R, int C) {
		if (r < L || R < l)
			return 0;
		if (L <= l && r <= R)
			return upperBound(segtree[i], C);

		int mid = (l + r) / 2;
		return query(l, mid, i * 2, L, R, C) + query(mid + 1, r, i * 2 + 1, L, R, C);
	}

	private static void build(int l, int r, int i) {
		if (i >= H)
			return;

		int mid = (l + r) / 2;
		build(l, mid, i * 2);
		build(mid + 1, r, i * 2 + 1);

		int pl = 0;
		int pr = 0;
		while (pl < segtree[i * 2].size() && pr < segtree[i * 2 + 1].size()) {
			if (segtree[i * 2].get(pl) <= segtree[i * 2 + 1].get(pr))
				segtree[i].add(segtree[i * 2].get(pl++));
			else
				segtree[i].add(segtree[i * 2 + 1].get(pr++));
		}
		while (pl < segtree[i * 2].size())
			segtree[i].add(segtree[i * 2].get(pl++));
		while (pr < segtree[i * 2 + 1].size())
			segtree[i].add(segtree[i * 2 + 1].get(pr++));
	}

	private static int upperBound(ArrayList<Integer> array, int C) {
		int l = 0;
		int r = array.size() - 1;

		while (l < r) {
			int mid = (l + r) / 2;

			if (array.get(mid) <= C)
				l = mid + 1;
			else
				r = mid;
		}

		return (array.get(l) <= C) ? l + 1 : l;
	}

	private static void dfs(int u) {
		visited[u] = true;

		start[u] = ++order;
		for (int v : tree[u])
			if (!visited[v])
				dfs(v);
		end[u] = order;
	}

	private static FastIO io;

	public static void main(String... args) {
		io = new FastIO(System.in, System.out);
		solve();
		io.close();
	}

	/**
	 * @author Minho Kim <minho.kim093@gmail.com>
	 */
	private static class FastIO {

		public static final int DEFAULT_BUFFER_SIZE = 65536;
		public static final int DEFAULT_INTEGER_SIZE = 10;
		public static final int DEFAULT_LONG_SIZE = 19;
		public static final int DEFAULT_WORD_SIZE = 32;
		public static final int DEFAULT_LINE_SIZE = 256;
		public static final int EOF = -1;

		private final InputStream in;
		private final OutputStream out;

		private byte[] inBuffer;
		private int nextIn, inLength;
		private byte[] outBuffer;
		private int nextOut;

		private char[] charBuffer;
		private byte[] byteBuffer;

		public FastIO(InputStream in, OutputStream out, int inBufferSize, int outBufferSize) {
			this.in = in;
			this.inBuffer = new byte[inBufferSize];
			this.nextIn = 0;
			this.inLength = 0;

			this.out = out;
			this.outBuffer = new byte[outBufferSize];
			this.nextOut = 0;

			this.charBuffer = new char[DEFAULT_LINE_SIZE];
			this.byteBuffer = new byte[DEFAULT_LONG_SIZE];
		}

		public FastIO(InputStream in, OutputStream out) {
			this(in, out, DEFAULT_BUFFER_SIZE, DEFAULT_BUFFER_SIZE);
		}

		public FastIO(InputStream in, OutputStream out, int bufferSize) {
			this(in, out, bufferSize, bufferSize);
		}

		public char nextChar() {
			return (char) read();
		}

		public String next() {
			byte b;
			while (isSpace(b = read()))
				;

			int pos = 0;
			do {
				charBuffer[pos++] = (char) b;
			} while (!isSpace(b = read()));

			return new String(charBuffer, 0, pos);
		}

		public String nextLine() {
			byte b;
			int pos = 0;

			while (!isLine(b = read()))
				charBuffer[pos++] = (char) b;

			return new String(charBuffer, 0, pos);
		}

		public int nextInt() {
			byte b;
			while (isSpace(b = read()))
				;

			boolean negative = false;
			int result = b - '0';
			if (b == '-') {
				negative = true;
				result = 0;
			}

			while (isDigit(b = read()))
				result = (result * 10) + (b - '0');

			return negative ? -result : result;
		}

		public long nextLong() {
			byte b;
			while (isSpace(b = read()))
				;

			boolean negative = false;
			long result = b - '0';
			if (b == '-') {
				negative = true;
				result = 0;
			}

			while (isDigit(b = read()))
				result = (result * 10) + (b - '0');

			return negative ? -result : result;
		}

		public float nextFloat() {
			byte b;
			while (isSpace(b = read()))
				;

			int pos = 0;
			do {
				charBuffer[pos++] = (char) b;
			} while (!isSpace(b = read()));

			return Float.parseFloat(new String(charBuffer, 0, pos));
		}

		public float nextFloat2() {
			byte b;
			while (isSpace(b = read()))
				;

			boolean negative = false;
			float result = b - '0';
			if (b == '-') {
				negative = true;
				result = 0;
			}

			while (isDigit(b = read()))
				result = (result * 10) + (b - '0');

			float d = 1;
			if (b == '.') {
				while (isDigit(b = read()))
					result += (b - '0') / (d *= 10);
			}

			return negative ? -result : result;
		}

		public double nextDouble() {
			byte b;
			while (isSpace(b = read()))
				;

			int pos = 0;
			do {
				charBuffer[pos++] = (char) b;
			} while (!isSpace(b = read()));

			return Double.parseDouble(new String(charBuffer, 0, pos));
		}

		public double nextDouble2() {
			byte b;
			while (isSpace(b = read()))
				;

			boolean negative = false;
			double result = b - '0';
			if (b == '-') {
				negative = true;
				result = 0;
			}

			while (isDigit(b = read()))
				result = (result * 10) + (b - '0');

			double d = 1;
			if (b == '.') {
				while (isDigit(b = read()))
					result += (b - '0') / (d *= 10);
			}

			return negative ? -result : result;
		}

		public int[] nextIntArray(int size) {
			int[] array = new int[size];
			for (int i = 0; i < size; i++)
				array[i] = nextInt();

			return array;
		}

		public long[] nextLongArray(int size) {
			long[] array = new long[size];
			for (int i = 0; i < size; i++)
				array[i] = nextLong();

			return array;
		}

		public int[][] nextInt2DArray(int Y, int X) {
			int[][] array = new int[Y][X];
			for (int y = 0; y < Y; y++)
				for (int x = 0; x < X; x++)
					array[y][x] = nextInt();

			return array;
		}

		public void print(char c) {
			write((byte) c);
		}

		public void print(String s) {
			for (int i = 0; i < s.length(); i++)
				write((byte) s.charAt(i));
		}

		public void print(int i) {
			if (i == 0) {
				write((byte) '0');
				return;
			}
			if (i == Integer.MIN_VALUE) {
				write((byte) '-');
				write((byte) '2');
				write((byte) '1');
				write((byte) '4');
				write((byte) '7');
				write((byte) '4');
				write((byte) '8');
				write((byte) '3');
				write((byte) '6');
				write((byte) '4');
				write((byte) '8');
				return;
			}

			if (i < 0) {
				write((byte) '-');
				i = -i;
			}

			int pos = 0;
			while (i > 0) {
				byteBuffer[pos++] = (byte) ((i % 10) + '0');
				i /= 10;
			}

			while (pos-- > 0)
				write(byteBuffer[pos]);
		}

		public void print(long l) {
			if (l == 0) {
				write((byte) '0');
				return;
			}
			if (l == Long.MIN_VALUE) {
				write((byte) '-');
				write((byte) '9');
				write((byte) '2');
				write((byte) '2');
				write((byte) '3');
				write((byte) '3');
				write((byte) '7');
				write((byte) '2');
				write((byte) '0');
				write((byte) '3');
				write((byte) '6');
				write((byte) '8');
				write((byte) '5');
				write((byte) '4');
				write((byte) '7');
				write((byte) '7');
				write((byte) '5');
				write((byte) '8');
				write((byte) '0');
				write((byte) '8');
				return;
			}

			if (l < 0) {
				write((byte) '-');
				l = -l;
			}

			int pos = 0;
			while (l > 0) {
				byteBuffer[pos++] = (byte) ((l % 10) + '0');
				l /= 10;
			}

			while (pos-- > 0)
				write(byteBuffer[pos]);
		}

		public void print(float f) {
			String sf = Float.toString(f);
			for (int i = 0; i < sf.length(); i++)
				write((byte) sf.charAt(i));
		}

		public void print(double d) {
			String sd = Double.toString(d);
			for (int i = 0; i < sd.length(); i++)
				write((byte) sd.charAt(i));
		}

		public void println(char c) {
			print(c);
			write((byte) '\n');
		}

		public void println(String s) {
			print(s);
			write((byte) '\n');
		}

		public void println(int i) {
			print(i);
			write((byte) '\n');
		}

		public void println(long l) {
			print(l);
			write((byte) '\n');
		}

		public void println(float f) {
			print(f);
			write((byte) '\n');
		}

		public void println(double d) {
			print(d);
			write((byte) '\n');
		}

		public void printf(String format, Object... args) {
			String s = String.format(format, args);
			for (int i = 0; i < s.length(); i++)
				write((byte) s.charAt(i));
		}

		public void fprint(char c) {
			print(c);
			flushBuffer();
		}

		public void fprint(String s) {
			print(s);
			flushBuffer();
		}

		public void fprint(int i) {
			print(i);
			flushBuffer();
		}

		public void fprint(long l) {
			print(l);
			flushBuffer();
		}

		public void fprint(float f) {
			print(f);
			flushBuffer();
		}

		public void fprint(double d) {
			print(d);
			flushBuffer();
		}

		public void fprintf(String format, Object... args) {
			printf(format, args);
			flushBuffer();
		}

		private byte read() {
			if (nextIn >= inLength) {
				if ((inLength = fill()) == EOF)
					return EOF;
				nextIn = 0;
			}

			return inBuffer[nextIn++];
		}

		private void write(byte b) {
			if (nextOut >= outBuffer.length)
				flushBuffer();

			outBuffer[nextOut++] = b;
		}

		private int fill() {
			try {
				return in.read(inBuffer, 0, inBuffer.length);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		public void flush() {
			if (nextOut == 0)
				return;

			flushBuffer();
		}

		private void flushBuffer() {
			try {
				out.write(outBuffer, 0, nextOut);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

			nextOut = 0;
		}

		public void close() {
			flush();
		}

		private boolean isDigit(byte b) {
			return b >= '0' && b <= '9';
		}

		private boolean isLine(byte b) {
			return b == '\n' || b == '\r' || b == EOF;
		}

		private boolean isSpace(byte b) {
			return b == ' ' || b == '\t' || b == '\n' || b == '\r' || b == '\f' || b == EOF;
		}
	}
}