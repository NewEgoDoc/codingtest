package coding.test.programmers.Lv2.bfs;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lv2게임맵최단거리 {

	int[] dx = {0, 1, 0, -1};
	int[] dy = {-1, 0, 1, 0};

	int n;
	int m;
	int[][] visited;

	public int solution(int[][] maps) {
		n = maps.length;
		m = maps[0].length;

		visited = new int[n][m];

		bfs(maps);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();

		return visited[n-1][m-1] == 0? -1: visited[n-1][m-1];
	}

	private void bfs(int[][] maps) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{0,0});
		visited[0][0] = 1;

		while(!q.isEmpty()){
			int[] current = q.poll();
			int x = current[0];
			int y = current[1];

			for(int i = 0; i < 4; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx < 0 || nx > maps.length-1 || ny < 0 || ny > maps[0].length-1)
					continue;

				if(visited[nx][ny] == 0 && maps[nx][ny] == 1){
					visited[nx][ny] = visited[x][y] + 1;
					q.add(new int[]{nx, ny});
				}
			}
		}
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}),11);
		Assertions.assertEquals(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}),-1);
	}
}
