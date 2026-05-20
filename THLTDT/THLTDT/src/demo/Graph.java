package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Graph {
    protected int numberOfVertex;
    protected int[][] matrixAdj;
    private String path;
    protected boolean[] visited;
    protected int[] pathDFS;
    protected int maxValue = 9999;
    public Graph(String path) {
        this.path = path;
        loadGraph(path);
    }

    public Graph(int numberOfVertex, int[][] matrixAdj) {
        this.numberOfVertex = numberOfVertex;
        this.matrixAdj = matrixAdj;
    }

    public boolean loadGraph(String pathFile) {
        File f = new File(pathFile);
        if (f.exists() == false) {
            System.out.println("Not path file: " + pathFile);
            return false;
        }
        try {
            FileReader reader = new FileReader(f);
            BufferedReader input = new BufferedReader(reader);
            this.numberOfVertex = Integer.valueOf(input.readLine());
            this.matrixAdj = new int[numberOfVertex][numberOfVertex];
            String line = "";
            int rows = 0;
            while ((line = input.readLine()) != null) {
                String[] items = line.split(" ");
                for (int i = 0; i < items.length; i++) {
                    matrixAdj[rows][i] = Integer.valueOf(items[i]);
                }
                rows++;
            }
            return true;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error read file: " + e.getMessage());
            return false;
        }

    }

    public boolean loadGraphW(String pathFile) {
        File f = new File(pathFile);
        if (f.exists() == false) {
            System.out.println("Not path file: " + pathFile);
            return false;
        }
        try {
            FileReader reader = new FileReader(f);
            BufferedReader input = new BufferedReader(reader);
            this.numberOfVertex = Integer.valueOf(input.readLine());
            this.matrixAdj = new int[numberOfVertex][numberOfVertex];
            String line = "";
            int rows = 0;
            while ((line = input.readLine()) != null) {
                String[] items = line.split(" ");
                for (int i = 0; i < items.length; i++) {
                    int value = Integer.valueOf(items[i]);
                    if (value==0) {
                        matrixAdj[rows][i] = maxValue;
                    } else {
                        matrixAdj[rows][i] = value;
                    }
                }
                rows++;
            }
            return true;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error read file: " + e.getMessage());
            return false;
        }

    }
    public void printMatrix() {
        for (int i = 0; i < matrixAdj.length; i++) {
            for (int j = 0; j < matrixAdj[i].length; j++) {
                System.out.print(matrixAdj[i][j] + " ");
            }
            System.out.println();
        }
    }


    //Kiem tra don do thi (KHONG PHAI DA DO THI)
    public boolean checkValid() {
        if (matrixAdj == null || matrixAdj.length != numberOfVertex) {
            return false;
        }
        for (int i = 0; i < numberOfVertex; i++) {
            if (matrixAdj[i].length != numberOfVertex) {
                return false;
            }
            for (int j = 0; j < numberOfVertex; j++) {
                if (matrixAdj[i][j] != 0 && matrixAdj[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean checkUndirected() {
        if (!checkValid()) {
            return false;
        }
        for (int i = 0; i < numberOfVertex; i++) {
            for (int j = i + 1; j < numberOfVertex; j++) {
                if (matrixAdj[i][j] != matrixAdj[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public abstract void addEdge(int v1, int v2);
    public abstract void removeEdge(int v1, int v2);

    public int outDegree(int v) {
        if (v < 0 || v >= numberOfVertex) {
            System.out.println("Not valid degree");
            return -1;
        }
        int count = 0;
        for (int i = 0; i < numberOfVertex; i++) {
            if (matrixAdj[i][v] == 1) {
                count++;
            }
        }
        return count;
    }
    public int inDegree(int v) {
        if (v < 0 || v >= numberOfVertex) {
            System.out.println("Not valid degree");
            return -1;
        }
        int count = 0;
        for (int i = 0; i < numberOfVertex; i++) {
            if (matrixAdj[v][i] == 1) {
                count++;
            }
        }
        return count;
    }

    public abstract int deg(int v);

    public int numVertices() {
        return this.numberOfVertex;
    }

    public int numEdges() {
        int count = 0;
        for (int i = 0; i < numberOfVertex; i++) {
            for (int j = 0; j < numberOfVertex; j++) {
                if (matrixAdj[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
    public int sumDeg() {
        int totalSum = 0;
        for (int i = 0; i < numberOfVertex; i++) {
            totalSum += deg(i);
        }
        return totalSum;
    }

    //deg (3)3 = deg+(1) deg-(2)
    public void printPath(int[] path) {
        for (int i = 0; i < path.length; i++) {
            System.out.print((path[i] + 1) + " ");
        }
        System.out.println();
    }
    public void reSetAll() {
        this.visited = new boolean[numberOfVertex]; //fix
        for (int i = 0; i < numberOfVertex; i++) {
            this.visited[i] = false;
        }
    }

    public abstract int[] DFS(int startVertex);
    public abstract int[] DFS();
    public abstract void DFS1(int startVertex);
    public abstract List<Integer> DFS2(int startVertex);
    public abstract ArrayList DFS3(int startVertex);
    public abstract int[] DFSRe(int startVertex); //Dequy
    public abstract int[] DFSRe(); //Dequy khong tham so


    public abstract int[] BFS(int startVertex);
    public abstract int[] BFS();
    public abstract void BFS2(int startVertex);
    public abstract void BFS2();

    public abstract boolean isConnected();
    public abstract void connectedComponents();
    public abstract void findPath(int s, int t);
    public abstract void findPath2(int s, int t);
    public abstract void findPathBFS(int s, int t);

    public abstract boolean isBipartite();
    public abstract boolean isEulerGraph();
    public abstract boolean isHalfEulerGraph();

    public abstract void  findEulerCycle();
    public abstract void  findEulerPath();

    public abstract void  findHamiltonCycle();
    public abstract void  findHamiltonPath();

    public abstract int[][] spanningTreeDFS(int start);
    public abstract int[][] spanningTreeDFSRe(int start);

    public abstract int[][] spanningTreeBFS(int start);
    public abstract int[][] spanningTreeBFSRe(int start);

    public abstract void addEdge(int v1, int v2, int[][] tree);

    public abstract void addEdge(int v1, int v2, int w, int[][] tree);
    public abstract void removeEdge(int v1, int v2, int w, int[][] tree);

    public abstract int[][] krukal();
    public abstract int[][] prim(int start);
}
