package coding.test.baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class boj2178 {
	int[][] map;
	boolean[][] visited;
	int N;
	int M;
	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};


	int solution(int n, int m, int[][] maze) {
		N = n;
		M = m;
		map = maze;
		visited = new boolean[n][m];

		bfs(new int[]{0,0});

		return maze[n-1][m-1];
	}

	private void bfs(int[] initialPoint) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(initialPoint);
		
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			visited[x][y] = true;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

				if (visited[nx][ny] || map[nx][ny] == 0) continue;

				visited[nx][ny] = true;
				map[nx][ny] = map[x][y] + 1;
				q.add(new int[] {nx, ny});
			}
		}
	}

	@Test
	void test() {
		Assertions.assertEquals(solution(4, 6, new int[][] {
			{1, 0, 1, 1, 1, 1},
			{1, 0, 1, 0, 1, 0},
			{1, 0, 1, 0, 1, 1},
			{1, 1, 1, 0, 1, 1},
		}), 15);
		Assertions.assertEquals(solution(4, 6, new int[][] {
			{1, 1, 0, 1, 1, 0},
			{1, 1, 0, 1, 1, 0},
			{1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 0, 1},
		}), 9);
		Assertions.assertEquals(solution(2, 25, new int[][] {
			{1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
			{1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1},
		}), 38);
		Assertions.assertEquals(solution(7, 7, new int[][] {
			{1, 0, 1, 1, 1, 1, 1},
			{1, 1, 1, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 1, 1},
		}), 13);

	}

}
