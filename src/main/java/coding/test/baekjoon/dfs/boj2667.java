package coding.test.baekjoon.dfs;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class boj2667 {

	int[][] map;
	boolean[][] visited;
	int n;
	int count;

	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};

	List<Integer> list;

	int[] solution(int N, int[][] m) {
		n = N;
		map = m;
		visited = new boolean[n][n];
		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					count = 1;
					list.add(dfs(i, j));
				}
			}
		}
		return makeAnswerArray();
	}

	private int[] makeAnswerArray() {
		int[] answer = new int[list.size() + 1];
		answer[0] = list.size();
		for (int i = 0; i < list.size(); i++) {
			answer[i+1] = list.get(i);
		}
		return answer;
	}

	private int dfs(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n)
				continue;
			if (visited[nx][ny] || map[nx][ny] == 0)
				continue;

			dfs(nx, ny);
			++count;
		}

		return count;
	}

	@Test
	void test() {
		Assertions.assertArrayEquals(solution(7,
			new int[][] {
				{0, 1, 1, 0, 1, 0, 0},
				{0, 1, 1, 0, 1, 0, 1},
				{1, 1, 1, 0, 1, 0, 1},
				{0, 0, 0, 0, 1, 1, 1},
				{0, 1, 0, 0, 0, 0, 0},
				{0, 1, 1, 1, 1, 1, 0},
				{0, 1, 1, 1, 0, 0, 0}}),
			new int[] {3, 7, 8, 9});
	}
}
