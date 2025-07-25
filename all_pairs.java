/* All Pairs Shortest Paths problem solution using Floyd’s Algorithm (Dynamic 
Programming Approach) */

import java.util.*;

class AllPairSP {
    int vertices = 4;
    int adjmatrix[][];

    //class constructor
    public AllPairSP() {
        //original graph
        adjmatrix = new int[][] {
            // -1 = no direct edge/path
            {0,   5,  -1, 10},          
            {-1,  0,   3, -1},
            {-1, -1,   0,  1},
            {-1, -1,  -1,  0}
        };
    }

    // Initialize dist matrix as a copy of adjmatrix
    // so we can perform updates (shortest paths) without modifying the original graph
    public void distMatrix() {
        int dist[][] = new int[vertices][vertices];

        // Initialize distance matrix
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (adjmatrix[i][j] == -1 && i != j) {
                    dist[i][j] = Integer.MAX_VALUE; //for infinity 
                } else {
                    dist[i][j] = adjmatrix[i][j];
                }
            }
        }

        // Floyd's logic to calc min dist
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Output
        System.out.println("All Pairs Shortest Path Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (dist[i][j] == Integer.MAX_VALUE)
                    System.out.print("-1 ");
                else
                    System.out.print(" "+dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AllPairSP obj = new AllPairSP();
        obj.distMatrix();
    }
}


// yt link
// https://youtu.be/oNI0rf2P9gE?si=DpRR_snKR4jzffG-