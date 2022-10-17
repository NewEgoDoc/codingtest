package coding.test.baekjoon.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.junit.jupiter.api.Assertions;
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

		count = 0;
		matrix = map;
		n = map.length;
		r = map[0].length;

		visited = new boolean[n][r];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < r; j++) {
				bfs(new int[]{i,j});
			}
		}

		return count;
	}

	private void bfs(int[] point) {
		if(matrix[point[0]][point[1]] == '.') {
			visited[point[0]][point[1]] = true;
			return;
		}

		Queue<int[]> q = new LinkedList<>();
		List<int[]> track = new ArrayList<>();
		q.add(point);
		visited[point[0]][point[1]] = true;
		track.add(point);
		System.out.println("track = " + matrix[point[0]][point[1]]);


		while(!q.isEmpty()){

			int[] poll = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];
				//System.out.println(nx + "," + ny);

				if(nx < 0 || ny < 0 || nx >= n || ny >= r) continue;

				if(matrix[point[0]][point[1]] != matrix[nx][ny] || visited[nx][ny]) continue;

				track.add(new int[]{nx,ny});
				q.add(new int[]{nx,ny});
				visited[nx][ny] = true;
			}

		}

		if(track.size() >= 4){
			pop(track);
			bringDown();
			visited = new boolean[n][r];
		}

	}

	private void bringDown() {
		for(int c = 0 ; c < r ; ++c) {
			for(int sr = n-1 ; sr >= 0 ; --sr) {
				if(matrix[sr][c] == '.') {
					for(int nr = sr - 1 ; nr >= 0 ; --nr) {
						if(matrix[nr][c] != '.') {
							matrix[sr][c] = matrix[nr][c];
							matrix[nr][c] = '.';
							break;
						}
					}
				}
			}
		}
	}

	private void pop(List<int[]> track) {
		for (int[] point :
			track) {
			matrix[point[0]][point[1]] = '.';
		}
		count++;
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(new char[][]{
				{'.','.','.','.','.','.'},
				{'.','.','.','.','.','.'},
				{'.','.','.','.','.','.'},
				{'.','.','.','.','.','.'},
				{'.','.','.','.','.','.'},
				{'.','.','.','.','.','.'},
				{'.','.','.','.','.','.'},
				{'.','.','.','.','.','.'},
				{'.','Y','.','.','.','.'},
				{'.','Y','G','.','.','.'},
				{'R','R','Y','G','.','.'},
				{'R','R','Y','G','G','.'}
		}),3);
	}
}
