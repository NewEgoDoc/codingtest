package coding.test.programmers.Lv2.bfs;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class boj4963 {

	int n;
	int m;

	int[][] visited;

	int[][] map;

	int[] dx = {-1,1,0,0,-1,1,-1,1};
	int[] dy = {0,0,-1,1,-1,1,1,-1};

	int count;

	int solution(int[][] islands){

		count = 0;

		n = islands.length;
		m = islands[0].length;
		visited = new int[n][m];
		map = islands;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0 && visited[i][j] == 0) {
					count++;
					bfs(i, j);
				}
			}
		}

		return count;
	}

	private void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{i,j});

		while(!q.isEmpty()){
			int[] poll = q.poll();
			int x = poll[0];
			int y = poll[1];

			for (int k = 0; k < 8; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if(isNotPossiblePosition(nx, ny)) continue;
				if(map[nx][ny] == 0) continue;
				if(visited[nx][ny] == 0){
					visited[nx][ny] = count;
					q.add(new int[]{nx,ny});
				}
			}
		}
	}

	private boolean isNotPossiblePosition(int nx, int ny) {
		return (nx < 0 || ny < 0 || nx >= n || ny >= m);
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(new int[][]{{0}}),0);
		Assertions.assertEquals(solution(new int[][]{{0, 1}, {1, 0}}),1);
		Assertions.assertEquals(solution(new int[][]{{1, 1, 1}, {1, 1, 1}}),1);
		Assertions.assertEquals(solution(new int[][]{
			{1, 0, 1, 0, 0},
			{1, 0, 0, 0, 0},
			{1, 0, 1, 0, 1},
			{1, 0, 0, 1, 0}
		}),3);
		Assertions.assertEquals(solution(new int[][]{
			{1, 1, 1, 0, 1},
			{1, 0, 1, 0, 1},
			{1, 0, 1, 0, 1},
			{1, 0, 1, 1, 1},
		}),1);
		Assertions.assertEquals(solution(new int[][]{
			{1, 0, 1, 0, 1},
			{0, 0, 0, 0, 0},
			{1, 0, 1, 0, 1},
			{0, 0, 0, 0, 0},
			{1, 0, 1, 0, 1}
		}),9);



	}

}
