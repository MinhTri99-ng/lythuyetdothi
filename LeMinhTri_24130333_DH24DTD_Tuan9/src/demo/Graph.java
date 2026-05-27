package demo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public abstract class Graph {
	protected int numberOfVertexs;
	protected int[][] matrixAdj;
	protected int[] path;
	protected boolean[] visited;
	protected int[] pathDFS;
	protected int pos = 0;
	static final int maxValue = 9999;

	public Graph(String path) throws NumberFormatException, IOException {
		super();
		loadGraph(path);
	}

	public Graph() {
		super();
	}

	public boolean loadGraph(String pathFile) throws NumberFormatException, IOException {
		File f = new File(pathFile);
		if (f.exists() == false) {
			System.out.println("Not path file");
			return false;
		}
		FileReader reader = new FileReader(f);
		BufferedReader input = new BufferedReader(reader);
		this.numberOfVertexs = Integer.valueOf(input.readLine());
		this.matrixAdj = new int[numberOfVertexs][numberOfVertexs];
		String line = "";
		int row = 0;
		while ((line = input.readLine()) != null) {
			String[] items = line.split(" ");
			for (int i = 0; i < items.length; i++) {
				matrixAdj[row][i] = Integer.valueOf(items[i]);

			}
			row++;
		}
		return true;
	}

	public void printMatrix() {
		for (int i = 0; i < matrixAdj.length; i++) {
			for (int j = 0; j < matrixAdj[i].length; j++) {
				System.out.print(matrixAdj[i][j] + " ");
			}
			System.out.println();
		}
	}

	public abstract void addEdge(int v1, int v2);

	public abstract void removeEdge(int v1, int v2);

	public abstract int deg(int v);

	public int numVertices() {
		return numberOfVertexs;
	}

	public abstract int numEdges();

	public int sumDeg() {
		int total = 0;
		for (int i = 0; i < matrixAdj.length; i++) {
			total += deg(i);
		}
		return total;

	}

	public abstract void printAllDeg();

	public void printPath(int[] path) {
		for (int i = 0; i < path.length; i++) {
			System.out.println((path[i] + 1 + " "));
		}
		System.out.println();
	}

	public void reSetAll() {
		this.visited = new boolean[numberOfVertexs];
		Arrays.fill(visited, false);
	}

	public abstract int[] DFS(int startVertex);

	public abstract int[] DFSRe(int startVertex);

	public abstract void BFS(int startVertex);

	public abstract void BFS1(int start);

	public abstract void connectedComponents();

	public abstract boolean isConnected();

	public abstract void findPath(int s, int t);

	public abstract void findPathBFS(int s, int t);

	public abstract boolean isBipartite();

	public abstract boolean isEulerGraph();

	public abstract boolean isHalfEulerGraph();

	public abstract void findEulerCycle();

	public abstract void findEulerPath();

	public abstract void findHamiltonCycle();

	public abstract void findHamiltonPath();

	public abstract int[][] spanningTreeDFSRe(int start);

	public abstract int[][] spanningTreeDFS(int start);

	public abstract int[][] spanningTreeBFS(int start);

	public abstract void addEdge(int v1, int v2, int[][] tree);

	public void printMatrix(int[][] matrix) {
		if (matrix == null) {
			System.out.println("Matrix is null!");
			return;
		}

		System.out.println("Spanning Tree Matrix:");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {

				System.out.printf("%4d", matrix[i][j]);
			}
			System.out.println();
		}
	}

	public abstract int[][] kruskal();

	public abstract int[][] prim(int start);
	public abstract void dijkstra (int start);
	public abstract void dijkstraAB (int start, int end);
	public abstract void dijkstraABbyC (int start, int end, int mid);
	public abstract void algoBellmanFord (int start);
	public void printPathDijkstra (int[] P, int v) {
		if (P[v] == -1) {
			return;
		}
		printPathDijkstra(P, P[v]);
		System.out.print("->" + (v+1));
	}
	public abstract void floyd();
	public abstract void floydExpand();
	public void printMatrixW(int[][] W) {
		for (int i = 0; i < numberOfVertexs; i++) {
			for (int j = 0; j < numberOfVertexs; j++) {
				if (W[i][j] >= maxValue/2) {
					System.out.printf("%7s", "9999");
				} else {
					System.out.printf("%7d", W[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	public abstract void Warshall() ;

}