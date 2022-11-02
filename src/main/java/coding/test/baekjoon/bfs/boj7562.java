package coding.test.baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class boj7562 {

	int n;
	int[][] visited;

	int[] dx = {-1,-2,-2,-1,1,2,2,1};
	int[] dy = {-2,-1,1,2,2,1,-1,-2};

	int solution(int[] start, int[] end, int N){
		n = N;
		visited = new int[n][n];
		bfs(start, end);
		return visited[end[0]][end[1]] - 1;
	}

	void bfs(int[] start, int[] end){
		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		visited[start[0]][start[1]] = 1;
		while(!q.isEmpty()){
			int[] poll = q.poll();
			int x = poll[0];
			int y = poll[1];

			if(x == end[0] && y == end[1]) return;

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(isImpossible(nx,ny)) continue;
				if(visited[nx][ny] == 0){
					visited[nx][ny] = visited[x][y] + 1;
					q.add(new int[]{nx,ny});
				}
			}
		}
	}

	private boolean isImpossible(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= n || ny >= n;
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(new int[]{0,0}, new int[]{7,0}, 8),5);
		Assertions.assertEquals(solution(new int[]{0,0}, new int[]{30,50}, 100),28);
		Assertions.assertEquals(solution(new int[]{1,1}, new int[]{1,1}, 10),0);
	}

}
