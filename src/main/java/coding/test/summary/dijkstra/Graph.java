package coding.test.summary.dijkstra;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Graph{

   class Node {
       int index;
       int cost;

       public Node(int index, int cost) {
           this.index = index;
           this.cost = cost;
       }

       @Override
       public String toString() {
           return "Node{" +
                   "index=" + index +
                   ", cost=" + cost +
                   '}';
       }
   }

   public int solution(int V, int E,int target){

       int start = 1;
       int[] distance = new int[E+1];
       for (int i = 0; i < distance.length; i++) {
           distance[i] = Integer.MAX_VALUE;
       }
       boolean[] visited = new boolean[E+1]; visited[0] = true;

       List<List<Node>> graph = new ArrayList<>();
       for (int i = 0; i < E+1; i++) {
           graph.add(new ArrayList<>());
       }
       graph.get(1).add(new Node(2,2));
       graph.get(1).add(new Node(3,5));
       graph.get(1).add(new Node(4,3));

       graph.get(2).add(new Node(3,7));
       graph.get(2).add(new Node(6,10));
       graph.get(2).add(new Node(1,2));

       graph.get(3).add(new Node(1,5));
       graph.get(3).add(new Node(2,7));
       graph.get(3).add(new Node(4,1));
       graph.get(3).add(new Node(5,2));
       graph.get(3).add(new Node(6,5));

       graph.get(4).add(new Node(3,1));
       graph.get(4).add(new Node(5,7));
       graph.get(4).add(new Node(1,3));

       graph.get(5).add(new Node(3,2));
       graph.get(5).add(new Node(4,7));
       graph.get(5).add(new Node(6,2));

       graph.get(6).add(new Node(2,10));
       graph.get(6).add(new Node(3,5));
       graph.get(6).add(new Node(5,2));

       for (int i = 0; i < E+1; i++) {
           System.out.println(i+":"+ graph.get(i));
       }

       dijkstra(start, distance, visited, graph);

       for (int i = 0; i < distance.length; i++) {
           System.out.print(distance[i] + " ");
       }
       System.out.println();

        return distance[target];
   }

    private void dijkstra(int start, int[] distance, boolean[] visited, List<List<Node>> graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (o1, o2)-> Integer.compare(o1.cost, o2.cost)
        );

        pq.offer(new Node(start, 0));
        distance[start]= 0;

        while(!pq.isEmpty()){
            Node currentNode = pq.poll();
            visited[currentNode.index] = true;

            for (int i = 0; i < graph.get(currentNode.index).size(); i++) {
                Node nextNode = graph.get(currentNode.index).get(i);
                if(distance[nextNode.index] > currentNode.cost + nextNode.cost){
                    distance[nextNode.index] = currentNode.cost+ nextNode.cost;
                    pq.offer(new Node(nextNode.index, distance[nextNode.index]));
                }
            }
        }
    }

    @Test
   public void test(){
       Assertions.assertEquals(solution(5,6,6),8);
   }

}
