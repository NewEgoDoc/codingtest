package coding.test.baekjoon.bfs;

import java.util.Stack;

import org.junit.jupiter.api.Test;

public class boj11559 {
	
	int n;
	int r;
	
	boolean[][] visited;
	
	int[] dx = {-1,1,0,0};
	int[] dy = {0,0,-1,1};

	int count;

	char[][] matrix;

	int solution(char[][] map){

		matrix = map;
		n = map.length;
		r = map[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < r; j++) {

			}
		}
		
		dfs();
		
		return 0;
	}

	private void dfs(int[] point) {
		
		visited[point[0]][point[1]] = true;

		for (int i = 0; i < 4; i++) {
			int nx = point[0] + dx[i];
			int ny = point[1] + dy[i];

			if(nx < 0 || ny < 0 || nx >= n || ny >= r) continue;

			if(matrix[nx][ny] == '.' || visited[nx][ny]) continue;

			dfs(new int[]{nx, ny});


		}
		
	}

	@Test
	void test(){
		
	}
}
