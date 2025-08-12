import java.util.*;

class BFS {

    int vertices;
    int[][] adjmatrix;

    BFS() {

        adjmatrix = new int[][] {
                { 0, 1, 1, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 1, 1, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 1, 1, 0 },
                { 0, 1, 0, 0, 0, 0, 0, 1 },
                { 0, 1, 0, 0, 0, 0, 0, 1 },
                { 0, 0, 1, 0, 0, 0, 0, 1 },
                { 0, 0, 1, 0, 0, 0, 0, 1 },
                { 0, 0, 0, 1, 1, 1, 1, 0 }
        };
        vertices = adjmatrix.length;
    }

    public void bfs(int start) {
        int i = start;
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[vertices];
        System.out.print(i+" ");
        queue.add(i);
        visited[i] = 1;

        while (!queue.isEmpty()) {
            i = queue.remove();

            for (int j = 0; j < vertices; j++) {
                if (adjmatrix[i][j] == 1 && visited[j] == 0) {
                    queue.add(j);
                    visited[j] = 1;
                    System.out.print(j+" ");
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS obj = new BFS();
        obj.bfs(0);

    }
}