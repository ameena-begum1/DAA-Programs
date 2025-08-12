// import java.util.*;

// class SingleSourceSP {
//     int vertices = 6;
//     int[][] cost; 
//     int[] dist; 
//     boolean[] visited; 

//     public SingleSourceSP() {
//         cost = new int[][] {
//                 // -1 for no direct path
//                 { 0, 50, 45, 10, -1, -1 },
//                 { -1, 0, 10, 15, -1, -1 },
//                 { -1, -1, 0, -1, 30, -1 },
//                 { 20, -1, -1, 0, 15, -1 },
//                 { -1, 20, 35, -1, 0, -1 },
//                 { -1, -1, -1, -1, 3,  0 }
//         };
//     }

//     //Dijkstra logic
//     public void dijkstra(int source) {
//         dist = new int[vertices];
//         visited = new boolean[vertices];
//         int INF = Integer.MAX_VALUE; // for no direct path mark it as infinity

//         // To store the order of final nodes
//         int[] order = new int[vertices];
//         int orderIdx = 0;

//         for (int i = 0; i < vertices; i++) {
//             if (cost[source][i] == -1 && i != source) {
//                 dist[i] = INF;
//             } else {
//                 dist[i] = cost[source][i]; // add direct path from source to i in dist array
//             }
//             visited[i] = false; // no vertex is visited
//         }

//         dist[source] = 0; // path starts from here
//         visited[source] = true; // mark start vertex as visited

//         // Add source to order
//         order[orderIdx++] = source;

//         // choose the next unvisited vertex that has the smallest distance from the source
//         for (int step = 1; step <= vertices - 1; step++) { // run the logic vertices - 1 times, source is already done
//             int u = -1;
//             int min = INF;

//             for (int i = 0; i < vertices; i++) {
//                 if (!visited[i] && dist[i] < min) {
//                     min = dist[i];
//                     u = i;
//                 }
//             }

//             if (u == -1)
//                 break;
//             visited[u] = true; // mark u as visited
//             order[orderIdx++] = u;

//             // update if there is shortest distance to the neighbor
//             for (int v = 0; v < vertices; v++) {
//                 if (!visited[v] && cost[u][v] != -1 && dist[u] != INF &&
//                         dist[u] + cost[u][v] < dist[v]) {
//                     dist[v] = dist[u] + cost[u][v];
//                 }
//             }
//         }

//         // Output
//         System.out.println("Final costs from source " + (source + 1) + ":");
//         for (int i = 0; i < vertices; i++) {
//             if (dist[i] == INF)
//                 System.out.println("To " + (i + 1) + " -> -1");
//             else
//                 System.out.println("To " + (i + 1) + " -> " + dist[i]);
//         }
//         System.out.print("\nThe Shortest path is: " + (source + 1));
//         for (int i = 1; i < orderIdx; i++) {
//             System.out.print(" -> " + (order[i] + 1));
//         }
//         System.out.println();

//     }

//     public static void main(String[] args) {
//         SingleSourceSP obj = new SingleSourceSP();
//         obj.dijkstra(5);
//     }
// }

// // //yt link
// // //https://youtu.be/XB4MIexjvY0?si=Xj5JQIMAMiL1T_kY (concept)

class Dijkstra {

    int vertices;
    boolean[] visited;
    int[] dist;
    int[][] cost;
    int INF = Integer.MAX_VALUE;

    Dijkstra() {
        cost = new int[][] {
                { 0, 50, 45, 10, INF, INF },
                { INF, 0, 10, 15, INF, INF },
                { INF, INF, 0, INF, 30, INF },
                { 20, INF, INF, 0, 15, INF },
                { INF, 20, 35, INF, 0, INF },
                { INF, INF, INF, INF, 3, 0 }
        };

        vertices = cost.length;
        visited = new boolean[vertices];
        dist = new int[vertices];
    }

    public void dikstra(int source) {

        for (int i = 0; i < vertices; i++) {
            dist[i] = cost[source][i];
            visited[i] = false;
        }

        visited[source] = true;
        dist[source] = 0;

        for (int i = 1; i < vertices; i++) {
            int u = -1;
            int min = INF;

            for (int j = 0; j < vertices; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }
            if (u == -1)
                break;

            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && cost[u][v] != INF) {
                    if (dist[v] > dist[u] + cost[u][v]) {
                        dist[v] = dist[u] + cost[u][v];
                    }
                }
            }
        }

    }

    public void display() {
        System.out.println("Single Source Shortest Path costs:");
        for (int i = 0; i < vertices; i++) {
            if (dist[i] == INF) {
                System.out.print("INF\t");
            } else {
                System.out.print(dist[i] + "\t");
            }
        }

    }

    public static void main(String[] args) {

        Dijkstra obj = new Dijkstra();
        obj.dikstra(0);
        obj.display();

    }
}