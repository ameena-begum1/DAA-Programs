class DFS {
    static int vertices;
    static int visited[];
    int adjmatrix[][];

    DFS() {
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
        visited = new int[vertices];

    }

    public void dfs(int start) {
        visited[start] = 1;
        System.out.print(start + " ");
        for (int i = 0; i < vertices; i++) {
            if (adjmatrix[start][i] == 1 && visited[i] == 0) {
                dfs(i);
            }
        }

    }

    public static void main(String[] args) {
        DFS obj = new DFS();
        obj.dfs(0);

        boolean connected = true;
        for (int i = 0; i < vertices; i++) {
            if (visited[i] == 0) {
                connected = false;
                break;
            }
        }

        if (connected) {
            System.out.println("The graph is connected");
        } else {
            System.out.println("The graph is not connected");
        }
    }
}