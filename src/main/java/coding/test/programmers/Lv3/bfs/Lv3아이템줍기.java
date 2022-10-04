package coding.test.programmers.Lv3.bfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lv3아이템줍기 {

	int[][] map;

	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

		//1) map을 만든다. map 크기 두배로
		map= new int[101][101];

		for(int i=0; i<rectangle.length; i++){
			expand(2*rectangle[i][0], 2*rectangle[i][1], 2*rectangle[i][2], 2*rectangle[i][3]);
		}

		int answer = 0;
		return answer;
	}

	private void expand(int x1, int y1, int x2, int y2) {
		for (int i = 0; i < x2; i++) {

		}
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}},1, 3, 7, 8),17);
		Assertions.assertEquals(solution(new int[][]{{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}},9, 7, 6, 1),11);
		Assertions.assertEquals(solution(new int[][]{{1,1,5,7}},1 ,1 ,4 ,7),9);
		Assertions.assertEquals(solution(new int[][]{{2,1,7,5},{6,4,10,10}},3 ,1 ,7 ,10),15);
		Assertions.assertEquals(solution(new int[][]{{2,2,5,5},{1,3,6,4},{3,1,4,6}},1 ,4 ,6 ,33),10);
	}
}
