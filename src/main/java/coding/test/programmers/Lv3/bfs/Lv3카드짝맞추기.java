package coding.test.programmers.Lv3.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lv3카드짝맞추기 {

	int[] dx = {1,-1,0,0};
	int[] dy = {0,0,1,-1};


	//최대 2번으로 방향과 칸수를 지정하여 찾을 수 있다!
	public int solution(int[][] board, int r, int c) {
		int answer = 0;

		int[][] cBoard = copyBoard(board);

		for (int x = 1; x <= 6; x++) {

			List<int[]> list = new ArrayList<>();

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if(cBoard[i][j] == x){
						list.add(new int[]{i,j});
					}
				}
			}

			//현재 위치에서 list의 첫번째 점까지의 거리 구해야함

			//bfs를 통해 해당 캐릭터가 있는 위치에서 다음 '동일한' 캐릭터가 있는 위치까지의 거리 구하기
			bfs(cBoard, list);



		}



		return answer;
	}

	private void bfs(int[][] cBoard, List<int[]> list) {
		final int[] start = list.get(0);
		final int[] end = list.get(1);

		int[][] visited = new int[4][4];
		Queue<int[]> q = new LinkedList<>();
		q.add(start);

		while (!q.isEmpty()){
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

				}
			}

		}




	}

	private int[][] copyBoard(int[][] board) {
		int[][] cBoard = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				cBoard[i][j] = board[i][j];
			}
		}
		return cBoard;
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(new int[][]{{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}},1,0),14);
		Assertions.assertEquals(solution(new int[][]{{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}},0,1),16);
	}
}
