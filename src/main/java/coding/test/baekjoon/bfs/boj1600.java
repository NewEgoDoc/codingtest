package coding.test.baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class boj1600 {
	int k;
	int w;
	int h;

	int[][] matrix;
	int[][] visited;

	int[] mx = {1,-1,0,0};
	int[] my = {0,0,-1,1};

	int[] hx = {2,1,2,1,-2,-1,-2,-1};
	int[] hy = {-1,-2,1,2,-1,-2,1,2};


	int solution(int K, int[][] map){
		k = K;
		h = map.length;
		w = map[0].length;
		matrix = map;
		visited = new int[h][w];

		bfs(new int[]{0,0});

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(" " + visited[i][j]);
			}
			System.out.println();
		}
		return visited[h-1][w-1];
	}

	private void bfs(int[] point) {
		Queue<int[]> q = new LinkedList<>();
		q.add(point);

		while(!q.isEmpty()){
			int[] poll = q.poll();

			int x = poll[0];
			int y = poll[1];

			System.out.println(x + " " + y);

			if(x == h -1 && y == w -1){
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + mx[i];
				int ny = y + my[i];

				if(isImpossible(nx, ny)) continue;
				if(visited[nx][ny] > 0 || matrix[nx][ny] == 1) continue;

				q.add(new int[]{nx, ny});
				visited[nx][ny] = visited[x][y] + 1;
			}

			if(k == 0){
				continue;
			}

			for (int i = 0; i < 6; i++) {

				int nx = x + hx[i];
				int ny = y + hy[i];

				if(isImpossible(nx, ny)) continue;
				if(visited[nx][ny] > 0 || matrix[nx][ny] == 1) continue;

				++k;
				q.add(new int[]{nx, ny});
				visited[nx][ny] = visited[x][y] + 1;

			}
		}



	}

	private boolean isImpossible(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= h || ny >= w;
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(1, new int[][]{
			{0, 0, 0, 0},
			{1, 0, 0, 0},
			{0, 0, 1, 0},
			{0, 1, 0, 0}
		}), 4);

		Assertions.assertEquals(solution(2, new int[][]{
			{0, 0, 1, 1, 0},
			{0, 0, 1, 1, 0}
		}), 2);
	}

}
