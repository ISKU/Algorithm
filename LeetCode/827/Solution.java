/*
 * Author: Minho Kim (ISKU)
 * Date: November 14, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://leetcode.com/problems/making-a-large-island/
 */

class Solution {

	private final int[] dy = { 1, -1, 0, 0 };
	private final int[] dx = { 0, 0, 1, -1 };

	private int[][] map;
	private boolean[][] visited;

	private Map<Point, Integer> groupMap;
	private int[] count;
	private int Y, X, answer;

	public int largestIsland(int[][] grid) {
		map = grid;
		Y = map.length;
		X = map[0].length;
		groupMap = new HashMap<>();

		int groupNumber = 0;
		count = new int[2500];
		visited = new boolean[Y][X];
		for (int y = 0; y < Y; y++)
			for (int x = 0; x < X; x++)
				if (!visited[y][x] && map[y][x] == 1)
					dfs(y, x, groupNumber++);

		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				if (map[y][x] == 1)
					continue;

				Set<Integer> set = new HashSet<>();
				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (ny < 0 || ny >= Y || nx < 0 || nx >= X || map[ny][nx] == 0)
						continue;

					Point p = new Point(ny, nx);
					int group = groupMap.get(p);
					set.add(group);
				}

				int sum = 0;
				if (!set.isEmpty())
					for (int group : set)
						sum += count[group];

				answer = Math.max(answer, sum + 1);
			}
		}

		return answer;
	}

	private void dfs(int y, int x, int group) {
		visited[y][x] = true;
		groupMap.put(new Point(y, x), group);
		count[group]++;
		answer = Math.max(answer, count[group]);

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny >= Y || nx < 0 || nx >= X || visited[ny][nx] || map[ny][nx] == 0)
				continue;

			dfs(ny, nx, group);
		}
	}

	private class Point {
		public int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public int hashCode() {
			return y * 2500 + x;
		}

		@Override
		public boolean equals(Object o) {
			Point p = (Point) o;
			if (this.y == p.y && this.x == p.x)
				return true;
			return false;
		}
	}
}
