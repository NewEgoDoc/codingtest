package coding.test.programmers.Lv3.bfs;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lv3카드짝맞추기 {

	int[] dx = {1,-1,0,0};
	int[] dy = {0,0,1,-1};


	//최대 2번으로 방향과 칸수를 지정하여 찾을 수 있다!
	public int solution(int[][] board, int r, int c) {
		int answer = 0;

		boolean[][] visited = new boolean[4][4];
		setVisited(board, visited);

		Queue<int[]> q = new LinkedList<>();

		if(board[r][c] != 0)  q.offer(new int[]{r,c});



		while(!q.isEmpty()){
			int[] now = q.poll();

			for (int i = 0; i < 4; i++) {

				answer++;

				for (int j = 0; j < 4; j++) {
					int nx = now[0];
					int ny = now[1];

					int x = nx + dx[i]*j;
					int y = ny + dy[i]*j;

					if(x >= 0 && y >= 0 && x <= 4 && y <= 4){
						if(!visited[x][y] && board[x][y] > 0){
							//stop


						}
					}
				}
			}

		}

		return answer;
	}

	private void setVisited(int[][] board, boolean[][] visited) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if(board[i][j] == 0) visited[i][j] = true;
			}
		}
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(new int[][]{{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}},1,0),14);
		Assertions.assertEquals(solution(new int[][]{{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}},0,1),16);
	}
}
