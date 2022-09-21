package coding.test.trial.no1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

public class Fourth {

	int[][] matrix;
	int N;
	public int solution(int n, int s, int a, int b, int[][] fares) {
		N = n;
		matrix = new int[N+1][N+1];

		for (int i = 0; i < fares.length; i++) {
			int x = fares[i][0];
			int y = fares[i][1];
			int cost = fares[i][2];
			matrix[x][y] = cost;
			matrix[y][x] = cost;
		}

		int[] distanceFromS = dijkstra(s);
		int[] distanceFromB = dijkstra(b);
		int[] distanceFromA = dijkstra(a);

		int sab = distanceFromS[a] + distanceFromA[b];
		int sba = distanceFromS[b] + distanceFromB[a];

		return Math.min(sab, sba);
	}

	private int[] dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		boolean visited[] = new boolean[N + 1];
		visited[0] = true;
		
		pq.offer(new int[]{0,start});
		visited[start] = true;
		// while (!pq.isEmpty()){
		//
		// }


		return null;
	}

	@Test
	void test(){
		Map<String, Integer> courseCount = new HashMap<>();
		final Integer a = courseCount.get('a');
		System.out.println("a = " + a);
	}
}
