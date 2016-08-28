/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.28
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2042
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int queries = input.nextInt() + input.nextInt();
		long[] elements = new long[size];

		for (int index = 0; index < size; index++)
			elements[index] = input.nextInt();

		SegmentTree segmentTree = new SegmentTree(size);
		segmentTree.build(elements);

		while (queries-- > 0) {
			if (input.nextInt() == 1) {
				int updateIndex = input.nextInt() - 1;
				int updateValue = input.nextInt();
				segmentTree.update(updateIndex, updateValue, elements);
				elements[updateIndex] = updateValue;
			} else
				System.out.println(segmentTree.getSum(input.nextInt() - 1, input.nextInt() - 1));
		}
	}

	private static class SegmentTree {

		private final int HEAD = 0;
		private final int START = 0;
		private final int END;

		private long[] tree;
		private int height;
		private int nodes;

		public SegmentTree(int size) {
			height = (int) (Math.ceil(Math.log(size) / Math.log(2)));
			nodes = 2 * (int) Math.pow(2, height) - 1;
			tree = new long[nodes];
			END = size - 1;
		}

		public void build(long[] elements) {
			buildTree(elements, START, END, HEAD);
		}

		public long getSum(int queryStart, int queryEnd) {
			return getSumTree(START, END, queryStart, queryEnd, HEAD);
		}

		public void update(int updateIndex, int updateValue, long[] elements) {
			long update = updateValue - elements[updateIndex];
			updateTree(START, END, updateIndex, update, HEAD);
		}

		private long buildTree(long[] elements, int startIndex, int endIndex, int current) {
			if (startIndex == endIndex) {
				tree[current] = elements[startIndex];
				return tree[current];
			}

			int mid = mid(startIndex, endIndex);
			tree[current] = buildTree(elements, startIndex, mid, left(current))
					+ buildTree(elements, mid + 1, endIndex, right(current));
			return tree[current];
		}

		private long getSumTree(int startIndex, int endIndex, int queryStart, int queryEnd, int current) {
			if (queryStart <= startIndex && queryEnd >= endIndex)
				return tree[current];

			if (endIndex < queryStart || startIndex > queryEnd)
				return 0;

			int mid = mid(startIndex, endIndex);
			return getSumTree(startIndex, mid, queryStart, queryEnd, left(current))
					+ getSumTree(mid + 1, endIndex, queryStart, queryEnd, right(current));
		}

		private void updateTree(int startIndex, int endIndex, int updateIndex, long update, int current) {
			if (updateIndex < startIndex || updateIndex > endIndex)
				return;

			tree[current] = tree[current] + update;
			if (startIndex != endIndex) {
				int mid = mid(startIndex, endIndex);
				updateTree(startIndex, mid, updateIndex, update, left(current));
				updateTree(mid + 1, endIndex, updateIndex, update, right(current));
			}
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