/*
 * Author: Minho Kim (ISKU)
 * Date: August 10, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11932
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Integer>[] tree;
	private static Node[] pst;
	private static Integer[] set;
	private static int[][] parent;
	private static int[] weight, height;
	private static boolean[] visited;
	private static int H;

	private static void solve() {
		int N = io.nextInt();
		int M = io.nextInt();

		TreeSet<Integer> tempSet = new TreeSet<Integer>();
		weight = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			weight[i] = io.nextInt();
			tempSet.add(weight[i]);
		}
		set = tempSet.toArray(new Integer[tempSet.size()]);

		tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			tree[i] = new ArrayList<Integer>();
		for (int i = 1; i < N; i++) {
			int u = io.nextInt();
			int v = io.nextInt();
			tree[u].add(v);
			tree[v].add(u);
		}

		pst = new Node[N + 1];
		pst[0] = new Node(0, null, null);
		pst[0].left = pst[0].right = pst[0];

		H = (int) Math.ceil(Math.log(N) / Math.log(2));
		parent = new int[N + 1][H + 1];
		height = new int[N + 1];
		visited = new boolean[N + 1];
		dfs(1, 0, 0);
		for (int h = 1; h <= H; h++)
			for (int v = 1; v <= N; v++)
				parent[v][h] = parent[parent[v][h - 1]][h - 1];

		while (M-- > 0) {
			int X = io.nextInt();
			int Y = io.nextInt();
			int K = io.nextInt();

			int lca = lca(X, Y);
			int kw = set[query(1, set.length, pst[X], pst[Y], pst[lca], pst[parent[lca][0]], K) - 1];
			io.println(kw);
		}
	}

	private static int query(int l, int r, Node x, Node y, Node lca, Node plca, int K) {
		if (l == r)
			return l;

		int count = x.left.c + y.left.c - lca.left.c - plca.left.c;
		int mid = (l + r) / 2;

		if (count >= K)
			return query(l, mid, x.left, y.left, lca.left, plca.left, K);
		else
			return query(mid + 1, r, x.right, y.right, lca.right, plca.right, K - count);
	}

	private static int lca(int u, int v) {
		if (height[u] > height[v])
			return lca(v, u);

		for (int h = H; h >= 0; h--)
			if (height[v] - height[u] >= (1 << h))
				v = parent[v][h];

		if (u == v)
			return u;

		for (int h = H; h >= 0; h--) {
			if (parent[u][h] != parent[v][h]) {
				u = parent[u][h];
				v = parent[v][h];
			}
		}

		return parent[u][0];
	}

	private static void dfs(int u, int p, int h) {
		visited[u] = true;
		height[u] = h;
		pst[u] = pst[p].update(1, set.length, Arrays.binarySearch(set, weight[u]) + 1);

		for (int v : tree[u]) {
			if (!visited[v]) {
				parent[v][0] = u;
				dfs(v, u, h + 1);
			}
		}
	}

	private static class Node {
		public int c;
		public Node left, right;

		public Node(int v, Node left, Node right) {
			this.c = v;
			this.left = left;
			this.right = right;
		}

		public Node update(int l, int r, int i) {
			if (i < l || r < i)
				return this;
			if (l == r)
				return new Node(c + 1, null, null);

			int mid = (l + r) / 2;
			return new Node(this.c + 1, this.left.update(l, mid, i), this.right.update(mid + 1, r, i));
		}
	}

	private static FastIO io;

	public static void main(String... args) {
		io = new FastIO(System.in, System.out);
		solve();
		io.close();
	}

	/**
	 * https://github.com/ISKU/FastIO-Java
	 * 
	 * @author Minho Kim <minho.kim093@gmail.com>
	 */
	private static class FastIO {

		public static final int DEFAULT_BUFFER_SIZE = 65536;
		public static final int DEFAULT_INTEGER_SIZE = 10;
		public static final int DEFAULT_LONG_SIZE = 19;
		public static final int DEFAULT_WORD_SIZE = 256;
		public static final int DEFAULT_LINE_SIZE = 1024;
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
			byte b;
			while (isSpace(b = read()))
				;

			return (char) b;
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

		public char[] nextToCharArray() {
			byte b;
			while (isSpace(b = read()))
				;

			int pos = 0;
			do {
				charBuffer[pos++] = (char) b;
			} while (!isSpace(b = read()));

			char[] array = new char[pos];
			System.arraycopy(charBuffer, 0, array, 0, pos);
			return array;
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

		public void printls(char c) {
			print(c);
			write((byte) ' ');
		}

		public void printls(String s) {
			print(s);
			write((byte) ' ');
		}

		public void printls(int i) {
			print(i);
			write((byte) ' ');
		}

		public void printls(long l) {
			print(l);
			write((byte) ' ');
		}

		public void printls(float f) {
			print(f);
			write((byte) ' ');
		}

		public void printls(double d) {
			print(d);
			write((byte) ' ');
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