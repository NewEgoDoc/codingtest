package coding.test.programmers.Lv3.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lv3여행경로 {

	boolean[] used;

	List<String> routes;

	public String[] solution(String[][] tickets) {

		used = new boolean[tickets.length];
		routes = new ArrayList<>();

		return dfs(tickets,0);
	}

	private String[] dfs(String[][] tickets, int index) {
		if(index == tickets.length){
			System.out.println("routes = " + routes);
			Collections.sort(routes);
			return routes.toArray(new String[0]);
		}

		for (int i = 0; i < tickets.length; i++) {
			if(!used[i]){
				if(routes.size() == 0){
					used[i] = true;
					routes.add(tickets[i][0]);
					routes.add(tickets[i][1]);
					dfs(tickets,index+1);
					routes.remove(routes.size()-1);
					routes.remove(routes.size()-1);
					used[i] = false;
				} else {
					if(routes.get(routes.size() - 1).equals(tickets[i][0])){
						used[i] = true;
						routes.add(tickets[i][1]);
						dfs(tickets,index+1);
						routes.remove(routes.size()-1);
						used[i] = false;
					}
				}
			}
		}

		return new String[0];
	}

	@Test
	void test(){
		// Assertions.assertArrayEquals(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}),new String[]{"ICN", "JFK", "HND", "IAD"});
		Assertions.assertArrayEquals(solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}),new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"});
	}
}
