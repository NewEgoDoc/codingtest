package coding.test.baekjoon.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class boj17086 {

	int n;
	int m;

	int[][] map;

	int[][] visited;

	int[] dx = {-1,1,0,0};
	int[] dy = {0,0,-1,1};

	int solution(int [][] sharks){
		n = sharks.length;
		m = sharks[0].length;

		map = sharks;

		visited = new int[n][m];

		List<int[]> sharkPoints = findSharks();

		bfs(sharkPoints);



		return findMax();
	}

	private int findMax() {
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(visited[i][j] > max) max = visited[i][j];
			}
		}

		return max;
	}

	private List<int[]> findSharks() {
		List<int[]> points = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] == 1) points.add(new int[]{i,j});
			}
		}
		return points;
	}

	void bfs(List<int[]> sharkPoints){
		Queue<int[]> q = new LinkedList<>();
		for (int[] point: sharkPoints) {
			visited[point[0]][point[1]] = 1;
			q.add(point);
		}

		while(!q.isEmpty()){
			int[] poll = q.poll();
			int x = poll[0];
			int y = poll[2];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(isImpossible(nx, ny)) continue;
				if(visited[nx][ny] > 0) continue;

				q.add(new int[]{nx,ny});
				visited[nx][ny] = visited[x][y] + 1;
			}

		}

	}

	private boolean isImpossible(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= n || ny >= m;
	}
	@Test
	void test(){
		Assertions.assertEquals(solution(new int[][]{
			{0, 0, 0, 1},
			{0, 1, 0, 0},
			{0, 0, 0, 0},
			{0, 0, 0, 1},
			{0, 0, 0, 0},
			{0, 1, 0, 0},
			{0, 0, 0, 1}
		}),2);
	}
}
