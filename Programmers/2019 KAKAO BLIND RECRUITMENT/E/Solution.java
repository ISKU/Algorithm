/*
 * Author: Minho Kim (ISKU)
 * Date: September 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://programmers.co.kr/learn/courses/30/lessons/42892
 */

import java.util.*;

class Solution {

	private Node[] nodes;
	private Integer[] xaxis, yaxis;
	private int iter;

	public int[][] solution(int[][] nodeinfo) {
		int ymax = Integer.MIN_VALUE;
		Node root = null;
		nodes = new Node[nodeinfo.length];
		for (int i = 0; i < nodeinfo.length; i++) {
			nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
			if (nodes[i].y > ymax) {
				ymax = nodes[i].y;
				root = nodes[i];
			}
		}
		Arrays.sort(nodes, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o1.x, o2.x);
			}
		});

		xaxis = compression(nodeinfo, 0);
		yaxis = compression(nodeinfo, 1);
		build(0, xaxis.length - 1, yaxis.length - 2, root);

		int[][] answer = new int[2][nodes.length];
		iter = 0;
		preorder(root, 0, answer);
		iter = 0;
		postorder(root, 1, answer);
		return answer;
	}

	private void build(int l, int r, int yidx, Node node) {
		if (yidx < 0)
			return;

		int y = yaxis[yidx];
		int xidx = Arrays.binarySearch(xaxis, node.x);

		node.left = findLeft(l, xidx, y);
		if (node.left != null)
			build(l, xidx, yidx - 1, node.left);

		node.right = findRight(xidx, r, y);
		if (node.right != null)
			build(xidx, r, yidx - 1, node.right);
	}

	private Node findLeft(int l, int r, int y) {
		for (int i = l; i < r; i++) {
			if (nodes[i].y != y)
				continue;
			return nodes[i];
		}
		return null;
	}

	private Node findRight(int l, int r, int y) {
		for (int i = l + 1; i <= r; i++) {
			if (nodes[i].y != y)
				continue;
			return nodes[i];
		}
		return null;
	}

	private Integer[] compression(int[][] nodeinfo, int idx) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nodeinfo.length; i++)
			set.add(nodeinfo[i][idx]);

		Integer[] axis = set.toArray(new Integer[set.size()]);
		Arrays.sort(axis);
		return axis;
	}

	private void preorder(Node node, int idx, int[][] answer) {
		if (node == null)
			return;
		answer[idx][iter++] = node.index;
		preorder(node.left, idx, answer);
		preorder(node.right, idx, answer);
	}

	private void postorder(Node node, int idx, int[][] answer) {
		if (node == null)
			return;
		postorder(node.left, idx, answer);
		postorder(node.right, idx, answer);
		answer[idx][iter++] = node.index;
	}

	private class Node {
		public int index;
		public int x, y;
		public Node left, right;

		public Node(int index, int x, int y) {
			this.index = index;
			this.x = x;
			this.y = y;
		}
	}
}