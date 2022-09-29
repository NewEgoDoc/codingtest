package coding.test.programmers.Lv3.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lv3여행경로 {

	boolean[] used;

	List<String> routes;

	List<String> routeList;

	StringBuilder sb = new StringBuilder();

	public String[] solution(String[][] tickets) {

		routeList = new ArrayList<>();
		used = new boolean[tickets.length];
		routes = new ArrayList<>();
		routes.add("ICN");

		dfs(tickets,0);

		Collections.sort(routeList);

		return routeList.get(0).split(" ");

	}

	private void dfs(String[][] tickets, int index) {
		if(index == tickets.length){
			for (String str: routes) {
				sb.append(str+" ");
			}
			routeList.add(sb.toString());
			sb.delete(0,sb.length());
		}

		for (int i = 0; i < tickets.length; i++) {
			if(!used[i]){
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

	@Test
	void test(){
		Assertions.assertArrayEquals(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}),new String[]{"ICN", "JFK", "HND", "IAD"});
		Assertions.assertArrayEquals(solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}),new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"});
	}
}
