package coding.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;


public class Solution3 {

    int[] visited;
    String[] lines;
    public int solution(String[] subway, int start, int end) {
        lines = subway;
        visited = new int[subway.length];
        Arrays.fill(visited, -1);

        bfs(start);

        return visited[findLinesFromString(end).get(0)];
    }

    private void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        int startLineNumber = findLinesFromString(start).get(0);
        q.offer(startLineNumber);
        visited[startLineNumber] = 0;

        while(!q.isEmpty()){
            int nowLineNumber = q.poll();
            int count = visited[nowLineNumber];
            String[] nowLine = lines[nowLineNumber].split(" ");

            for (String station: nowLine) {
                int intStation = Integer.parseInt(station);
                ArrayList<Integer> linesFound = findLinesFromString(intStation);
                for (int lineFound: linesFound){
                    if(visited[lineFound] == -1){
                        visited[lineFound] = count + 1;
                        q.offer(lineFound);
                    }
                }
            }
        }
    }

    private ArrayList<Integer> findLinesFromString(int station) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            if(lines[i].contains(String.valueOf(station))) {
                list.add(i);
            }
        }
        return list;
    }
//    List<ArrayList<Integer>> subwayList;
//    public int solution(String[] subway, int start, int end) {
//        /* 해당 subway */
//        subwayList = new ArrayList<>();
//        subwayList.add(null);
//        for (int i = 0; i < subway.length; i++) {
//            subwayList.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < subway.length; i++) {
//            String[] s = subway[i].split(" ");
//            for (String value : s) {
//                subwayList.get(i + 1).add(Integer.parseInt(value));
//            }
//        }
//
//        visited = new int[subway.length + 1];
//        Arrays.fill(visited, -1);
//
//        bfs(start);
//
//        return visited[findLines(end).get(0)];
//    }
//
//    private void bfs(int start) {
//        Queue<Integer> q = new LinkedList<>();
//        int startLineNumber = findLines(start).get(0);
//        visited[startLineNumber] = 0;
//        q.offer(startLineNumber);
//
//        while (!q.isEmpty()){
//            int lineNumber = q.poll();
//            int count = visited[lineNumber] + 1;
//            ArrayList<Integer> nowLine = subwayList.get(lineNumber);
//            for (int i = 0; i < nowLine.size(); i++) {
//                int station = nowLine.get(i);
//                List<Integer> linesFound = findLines(station);
//                for (int lineFound: linesFound){
//                    if(visited[lineFound] == -1){
//                        visited[lineFound] = count;
//                        q.offer(lineFound);
//                    }
//                }
//            }
//        }
//    }
//
//
//    private List<Integer> findLines(int station) {
//        List<Integer> subwayLines = new ArrayList<>();
//        for (int i = 1; i < subwayList.size(); i++) {
//            if(subwayList.get(i).contains(station)){
//                subwayLines.add(i);
//            }
//        }
//        return subwayLines;
//    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new String[]{
                "1 2 3 4 5 6 7 8",
                "2 11",
                "0 11 10",
                "3 17 19 12 13 9 14 15 10",
                "20 2 21"
        },1,9),1);
        Assertions.assertEquals(solution(new String[]{
                "1 2 3 4 5 6 7 8 9 10",
                "2 8"
        },1,10),0);
        Assertions.assertEquals(solution(new String[]{
                "0 1 2 3 4",
                "1 12 13 14"
        },2,12),1);
    }
}
//        SELECT
//        b.id as 'BRANCH_ID', b.name as 'BRANCH_NAME', IFNULL(sub.count, 0) as 'COUNT'
//        FROM BRANCHES b LEFT JOIN (SELECT s.employee_id, count(s.created_at) as COUNT, e.branch_id
//                FROM (SELECT * FROM SELLINGS WHERE car_id = 306) s JOIN EMPLOYEES e ON s.employee_id = e.id
//                GROUP BY branch_id) sub
//        ON b.id = sub.branch_id
//        ORDER BY id
