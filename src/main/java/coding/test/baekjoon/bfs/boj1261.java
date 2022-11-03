package coding.test.baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class boj1261 {
	int n;
	int m;
	int[][] map;
	int[][] visited;

	int[] dx = {-1,1,0,0};
	int[] dy = {0,0,-1,1};

	int solution(int M, int N, int[][] maze){
		n = N;
		m = M;
		map = maze;
		visited = new int[n][m];

		bfs();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(visited[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		return visited[n-1][m-1] -1;
	}

	void bfs(){
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{0,0});
		visited[0][0] = 1;

		while(!q.isEmpty()){
			int[] poll = q.poll();
			int x = poll[0];
			int y = poll[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				// System.out.println(nx + " " + ny);
				if(isImpossible(nx,ny)) continue;
				if(visited[nx][ny] > 0) {
					//
					continue;
				}
				visited[nx][ny] = visited[x][y] + map[nx][ny];
				q.add(new int[]{nx, ny});
			}
		}
	}

	private boolean isImpossible(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= n || ny >= m;
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(3,3,new int[][]{
			{0,1,1},
			{1,1,1},
			{1,1,0}
		}),3);
		// Assertions	.assertEquals(solution(4,2,new int[][]{
		// 	{0,0,0,1},
		// 	{1,0,0,0}
		// }),3);
		Assertions.assertEquals(solution(6,6,new int[][]{
			{0,0,1,1,1,1},
			{0,1,0,0,0,0},
			{0,0,1,1,1,1},
			{1,1,0,0,0,1},
			{0,1,1,0,1,0},
			{1,0,0,0,1,0}
		}),3);
	}
}
