/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11441
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int[] elements = new int[size];

		for (int index = 0; index < size; index++)
			elements[index] = input.nextInt();

		SegmentTree segmentTree = new SegmentTree(size);
		segmentTree.build(elements);

		int queries = input.nextInt();
		while (queries-- > 0)
			System.out.println(segmentTree.getSum(input.nextInt() - 1, input.nextInt() - 1));
	}

	private static class SegmentTree {

		private final int HEAD = 0;
		private final int START = 0;
		private final int END;

		private int[] tree;
		private int height;
		private int nodes;

		public SegmentTree(int size) {
			height = (int) (Math.ceil(Math.log(size) / Math.log(2)));
			nodes = 2 * (int) Math.pow(2, height) - 1;
			tree = new int[nodes];
			END = size - 1;
		}

		public void build(int[] elements) {
			buildTree(elements, START, END, HEAD);
		}

		public int getSum(int queryStart, int queryEnd) {
			return getSumTree(START, END, queryStart, queryEnd, HEAD);
		}

		private int buildTree(int[] elements, int startIndex, int endIndex, int current) {
			if (startIndex == endIndex) {
				tree[current] = elements[startIndex];
				return tree[current];
			}

			int mid = mid(startIndex, endIndex);
			tree[current] = buildTree(elements, startIndex, mid, left(current))
					+ buildTree(elements, mid + 1, endIndex, right(current));
			return tree[current];
		}

		private int getSumTree(int startIndex, int endIndex, int queryStart, int queryEnd, int current) {
			if (queryStart <= startIndex && queryEnd >= endIndex)
				return tree[current];

			if (endIndex < queryStart || startIndex > queryEnd)
				return 0;

			int mid = mid(startIndex, endIndex);
			return getSumTree(startIndex, mid, queryStart, queryEnd, left(current))
					+ getSumTree(mid + 1, endIndex, queryStart, queryEnd, right(current));
		}

		private int left(int parent) {
			return 2 * parent + 1;
		}

		private int right(int parent) {
			return 2 * parent + 2;
		}

		private int mid(int start, int end) {
			return (start + (end - start) / 2);
		}
	}
}