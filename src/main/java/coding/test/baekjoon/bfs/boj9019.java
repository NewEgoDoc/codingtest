package coding.test.baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class boj9019 {

	int start;
	int goal;

	String[] track;
	StringBuilder sb;

	String solution(int s, int g){
		start = s;
		goal = g;

		track = new String[10000];

		sb = new StringBuilder();

		bfs();

		return track[goal];
	}

	void bfs(){
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		track[start] = "";

		while(!q.isEmpty()){
			int poll = q.poll();
			if(poll == goal) return;

			int d = D(poll);
			if(track[d] == null) {
				track[d] = track[poll] + "D";
				q.add(d);
			}

			int s = S(poll);
			if(track[s] == null) {
				track[s] = track[poll] + "S";;
				q.add(s);
			}

			int l = L(poll);
			if(track[l] == null) {
				track[l] = track[poll] + "L";
				q.add(l);
			}

			int r = R(poll);
			if(track[r] == null) {
				track[r] = track[poll] + "R";
				q.add(r);
			}
		}
	}

	private int R(int num) {
		int thousandToTen = num / 10;
		int one = num % 10;

		return one*1000 + thousandToTen;
	}

	private int L(int num) {

		int thousand = num / 1000;
		int hundredToOne = num % 1000;

		return hundredToOne*10 + thousand;
	}

	private int S(int num) {
		int minusNum = num - 1;
		if(minusNum == 0) return 9999;
		return minusNum;
	}

	private int D(int num) {
		int doubleNum = (num * 2);

		if(doubleNum >= 10000) return (doubleNum % 10000);

		return doubleNum;
	}

	@Test
	void test(){
		Assertions.assertEquals(solution(1234,3412),"LL");
		Assertions.assertEquals(solution(1000,1),"L");
		Assertions.assertEquals(solution(1,16),"DDDD");
	}
}
