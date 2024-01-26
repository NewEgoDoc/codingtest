package coding.test.y2024;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Lv3수레움직이기 {

	int[][] map;
	int[][] redVisited;
	int[][] blueVisited;

	int[] dx = {1, -1, 0, 0};
	int[] dy = {0, 0, 1, -1};

	int n;
	int m;
	int[] redStartPoint;
	int[] redEndPoint;
	int[] blueStartPoint;
	int[] blueEndPoint;
	public int solution(int[][] maze) {
		int answer = 0;
		map = maze;
		n = maze.length;
		m = maze[0].length;
		redVisited = new int[n][m];
		blueVisited = new int[n][m];

		redStartPoint = new int[2];
		redEndPoint = new int[2];
		blueStartPoint = new int[2];
		blueEndPoint = new int[2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(maze[i][j] == 1){
					redStartPoint = new int[]{i,j};
					continue;
				}

				if(maze[i][j] == 2){
					blueStartPoint = new int[]{i,j};
					continue;
				}

				if(maze[i][j] == 3){
					redEndPoint = new int[]{i,j};
					continue;
				}

				if(maze[i][j] == 4){
					blueEndPoint = new int[]{i,j};
					continue;
				}
			}
		}

		redBFS(redStartPoint);


		return answer;
	}

	public void redBFS(int[] start){
		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		redVisited[start[0]][start[1]] = 1;

		while(!q.isEmpty()){
			int[] poll = q.poll();
			int x = poll[0];
			int y = poll[1];

			

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(!(nx <= 0 && ny <= 0 && nx >= n && ny >= m) && (redVisited[nx][ny] == 0) && (map[nx][ny] == 5)) {

					continue;
				}

				redVisited[nx][ny] = redVisited[x][y] + 1;
				q.add(new int[]{nx, ny});
			}
		}

	}


	@Test
	public void test(){
		assertEquals(new int[][]{{1, 4}, {0, 0}, {2, 3}}, 3);
		assertEquals(new int[][]{{1, 0, 2}, {0, 0, 0}, {5, 0 ,5}, {4, 0, 3}}, 7);
		assertEquals(new int[][]{{1, 5}, {2, 5}, {4, 5}, {3, 5}}, 0);
		assertEquals(new int[][]{{4, 1, 2, 3}}, 0);
	}
}
