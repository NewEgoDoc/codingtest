package coding.test.programmers.Lv2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lv2배달 {
	int[][] matrix;
	public int solution(int N, int[][] road, int K) {
		matrix = new int[N][N];
		for (int[] line: road) {
			int x = line[0];
			int y = line[1];
			int edge = line[2];

			matrix[x-1][y-1] = edge;
			matrix[y-1][x-1] = edge;
		}

		for (int[] line: road) {
			int x = line[0];
			int y = line[1];
			int edge = line[2];

			matrix[x-1][y-1] = Math.min(matrix[x - 1][y - 1], edge);
			matrix[y-1][x-1] = Math.min(matrix[y - 1][x - 1], edge);
		}

		int answer = dijkstra(N,K);

		return answer;
	}

	private int dijkstra(int n, int k) {
		int[] distances = new int[n];
		Arrays.fill(distances,Integer.MAX_VALUE);
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		boolean[] visited = new boolean[n];

		distances[0] = 0;

		pq.offer(new int[]{0,0});

		while (!pq.isEmpty()){
			int[] cur = pq.poll();
			int index = cur[1];

			if(visited[index]) continue;

			visited[index] = true;

			for (int i = 0; i < n; i++) {
				if(matrix[index][i] == 0){
					continue;
				}
				if(distances[index] + matrix[index][i] < distances[i]){
					distances[i] = distances[index] + matrix[index][i];
					pq.add(new int[]{distances[i], i});
				}
			}
		}

		int count = 0;
		// System.out.println();
		for (int distance: distances) {
			// System.out.print(" " + distance);
			if(distance <= k) count++;
		}
		// System.out.println();

		return count;
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(5,new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}},3),4);
		Assertions.assertEquals(solution(6,new int[][]{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}},4),4);
	}
}
