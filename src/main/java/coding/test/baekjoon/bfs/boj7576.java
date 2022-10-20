package coding.test.baekjoon.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class boj7576 {

	int n;
	int m;
	int[][] box;
	int[][] visited;

	int[] dx = {-1,1,0,0};
	int[] dy = {0,0,-1,1};

	int solution(int N, int M, int [][] tomato){
		n = N;
		m = M;

		box = tomato;
		visited = new int[m][n];

		List<int[]> startPoints = findStart();
		if(startPoints.size() == 0) return -1;

		bfs(startPoints);

		return findAnswer() -1;
	}

	private int findAnswer() {
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(visited[i][j] == 0) return 0;
				if(max < visited[i][j]) max = visited[i][j];
			}
		}
		return max;
	}

	private List<int[]> findStart() {
		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(box[i][j] == 1) list.add(new int[]{i,j});
			}
		}
		return list;
	}

	void bfs(List<int[]> points){
		Queue<int[]> q = new LinkedList<>();

		for (int[] point: points) {
			q.offer(point);
			visited[point[0]][point[1]] = 1;
		}

		checkNoTomato();

		while(!q.isEmpty()){
			int[] poll = q.poll();
			int x = poll[0];
			int y = poll[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(isImpossible(nx, ny)) continue;
				if(visited[nx][ny] > 0)  continue;

				q.add(new int[]{nx, ny});
				visited[nx][ny] = visited[x][y] + 1;
			}
		}

	}

	private void checkNoTomato() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(box[i][j] == -1) visited[i][j] = 1;
			}
		}
	}

	private boolean isImpossible(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= m || ny >= n;
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(6,4,new int[][]{
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 1}
		}),8);
		Assertions.assertEquals(solution(6,4,new int[][]{
			{0, -1, 0, 0, 0, 0},
			{-1, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 1}
		}),-1);
		Assertions.assertEquals(solution(6,4,new int[][]{
			{1, -1, 0, 0, 0, 0},
			{0, -1, 0, 0, 0, 0},
			{0, 0 ,0 ,0 ,-1, 0},
			{0, 0 ,0 ,0 ,-1, 1}
		}),6);
		Assertions.assertEquals(solution(5,5,new int[][]{
			{-1, 1, 0, 0, 0},
			{0, -1, -1, -1, 0},
			{0, -1, -1, -1, 0},
			{0, -1, -1, -1, 0},
			{0, 0, 0, 0, 0}
		}),14);
		Assertions.assertEquals(solution(2,2,new int[][]{
			{1 ,-1},
			{-1, 1}
		}),0);
	}
}
