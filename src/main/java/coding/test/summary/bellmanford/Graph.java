package coding.test.summary.bellmanford;

public class Graph {

    class Edge {
        int src, dest, weight;
        Edge()
        {
            src = dest = weight = 0;
        }
    };

    int V, E;
    Edge edge[];

    Graph(int v, int e)// vertex(정점), edge(간선) 수를 정하는 생성자
    {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    /**
     *
     * 3. 시간 복잡도
     *
     * 벨만 포드 알고리즘은 정점의 개수 (V-1)만큼 반복하면서 모든 간선의 edge relaxation을 수행한다.
     * 그렇기 때문에 V * E (모든 간선의 개수)로 O(VE)의 시간 복잡도를 가진다.
     */
    void BellmanFord(Graph graph, int src)
    {
        int V = graph.V, E = graph.E;

        //initialize single source
        //시작점으로 하는 정점을 0으로 하고 나머지는 int의 최대값
        int dist[] = new int[V];
        for (int i = 0; i < V; ++i) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        for (int i = 1; i < V; ++i) {// 정점은 하나가 정해졌으므로 (정점의개수 -1) 만큼 돌면서
            for (int j = 0; j < E; ++j) {// 간선을 돌며, relaxation 을 진행
                int u = graph.edge[j].src; // 간선정보(출발지)
                int v = graph.edge[j].dest;// 간선정보(도착점)
                int weight = graph.edge[j].weight;// 간선정보(가중치)
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                // 간선 정보가 가진 시작점의 distance 값이 무한대가 아니면서,
                // 출발지 distance 값에 가중치를 더한값이 도착점의 distance 값 보다 작다면
                    dist[v] = dist[u] + weight;//도착점의 distance 값을 update
            }
        }

        for (int j = 0; j < E; ++j) {// 마지막으로 모든 간선을 돌며 relaxation 진행
            int u = graph.edge[j].src;
            int v = graph.edge[j].dest;
            int weight = graph.edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
            // V-1 만큼 반복하여 모든 정점을 고려한 최단 거리를 찾았음에도 더 짧은 경로가 있다는 것은
            // 음수의 사이클이 존재한다는 의미이다.
                System.out.println("Graph contains negative weight cycle");
                return;// 최단경로 찾는 의미가 없음으로 종료;
            }
        }
        printArr(dist, V);
    }

    // A utility function used to print the solution
    void printArr(int dist[], int V)
    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    // Driver method to test above function
    public static void main(String[] args)
    {
        int V = 5; // Number of vertices in graph
        int E = 8; // Number of edges in graph

        Graph graph = new Graph(V, E);

        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        // add edge 1-4 (or B-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;

        graph.BellmanFord(graph, 0);
    }
}
