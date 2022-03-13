package coding.test.summary.dijkstra;

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
   }

   public int solution(int V, int E){

       int start = 0;
       int[] distance = new int[V+1];
       for (int i = 0; i < distance.length; i++) {
           distance[i] = Integer.MAX_VALUE;
       }

       List<List<Node>> graph = new ArrayList<>();
       for (int i = 0; i < V+1; i++) {
           graph.add(new ArrayList<>());
       }
       graph.get(1).add(new Node(2,2));
       graph.get(1).add(new Node(3,5));
       graph.get(1).add(new Node(4,3));

       graph.get(2).add(new Node(3,7));
       graph.get(2).add(new Node(6,10));
       graph.get(2).add(new Node(1,2));


        PriorityQueue<Node> pq = new PriorityQueue<>(
            (o1, o2)-> Integer.compare(o1.cost, o2.cost)
        );

        pq.offer(new Node(start, 0));
        distance[start]= 0;
        while(!pq.isEmpty()){
            Node currentNode = pq.poll();
            if (distance[currentNode.index] < currentNode.cost) {
                continue;
            }

            for (int i = 0; i < graph.get(currentNode.index).size(); i++) {
                Node nextNode = graph.get(currentNode.index).get(i);
                if(distance[nextNode.index] > currentNode.cost+ nextNode.cost){
                    distance[nextNode.index] = currentNode.cost+ nextNode.cost;
                    pq.offer(new Node(nextNode.index, distance[nextNode.index]));
                }
            }

        }

        return 0;
   }


}
