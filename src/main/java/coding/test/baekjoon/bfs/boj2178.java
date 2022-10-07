package coding.test.baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class boj2178 {

	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};

	int solution(int n, int m, int[][] maze) {
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] {0, 0});
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				System.out.println(nx + "," + ny);

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;

				if (visited[nx][ny] && maze[nx][ny] == 0)
					continue;

				visited[nx][ny] = true;
				maze[nx][ny] = maze[x][y] + 1;
				q.add(new int[] {nx, ny});
			}
		}

		return maze[n-1][m-1];
	}

	@Test
	void test() {
		Assertions.assertEquals(solution(4, 6, new int[][] {
			{1, 0, 1, 1, 1, 1},
			{1, 0, 1, 0, 1, 0},
			{1, 0, 1, 0, 1, 1},
			{1, 1, 1, 0, 1, 1},
		}), 15);
		// Assertions.assertEquals(solution(4, 6, new int[][] {
		// 	{1, 1, 0, 1, 1, 0},
		// 	{1, 1, 0, 1, 1, 0},
		// 	{1, 1, 1, 1, 1, 1},
		// 	{1, 1, 1, 1, 0, 1},
		// }), 9);
		// Assertions.assertEquals(solution(2, 25, new int[][] {
		// 	{1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
		// 	{1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1},
		// }), 38);
		// Assertions.assertEquals(solution(7, 7, new int[][] {
		// 	{1, 0, 1, 1, 1, 1, 1},
		// 	{1, 1, 1, 0, 0, 0, 1},
		// 	{1, 0, 0, 0, 0, 0, 1},
		// 	{1, 0, 0, 0, 0, 0, 1},
		// 	{1, 0, 0, 0, 0, 0, 1},
		// 	{1, 0, 0, 0, 0, 0, 1},
		// 	{1, 1, 1, 1, 1, 1, 1},
		// }), 13);

	}

}
