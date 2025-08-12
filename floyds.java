import java.util.*;

class FloydsWarshall {
    int vertices;
    int adjmatrix[][];
    int dist[][];
    int INF = Integer.MAX_VALUE;

    public FloydsWarshall() {
        vertices = 3;
        adjmatrix = new int[][] {
                { 0, 4, 11 },
                { 6, 0, 2 },
                { 3, INF, 0 }
        };
        dist = new int[vertices][vertices];
    }

    public void floyds() {

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                dist[i][j] = adjmatrix[i][j];
            }
        }

        System.out.println("Dist matrix:");
        display();

        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
            System.out.println("APSP Matrix k:"+k);
            display();
        }

    }

    public void display() {

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (dist[i][j] == Integer.MAX_VALUE)
                    System.out.print("INF\t");
                else
                    System.out.print(dist[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FloydsWarshall obj = new FloydsWarshall();
        obj.floyds();
    }
}

// yt link
// https://youtu.be/oNI0rf2P9gE?si=DpRR_snKR4jzffG-