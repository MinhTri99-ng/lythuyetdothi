package demo;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DiGraph extends Graph {

	public DiGraph() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DiGraph(String path) throws NumberFormatException, IOException {
		super(path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addEdge(int v1, int v2) {
		// TODO Auto-generated method stub
		if (v1 < 0 || v1 >= numberOfVertexs || v2 < 0 || v2 >= numberOfVertexs) {
			System.out.println("out of numberOfVertexs");
			return;
		}
		matrixAdj[v1][v2] = 1;

	}

	@Override
	public int deg(int v) {
		// TODO Auto-generated method stub
		return degPlus(v) + degSub(v);

	}

	@Override
	public int numEdges() {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < numberOfVertexs; i++) {
			for (int j = i; j < numberOfVertexs; j++) {
				if (matrixAdj[i][j] != 0) {
					count++;
				}

			}

		}
		return count;
	}

	@Override
	public void printAllDeg() {
		// TODO Auto-generated method stub
		for (int i = 0; i < numberOfVertexs; i++) {
			System.out.println("deg(" + (i + 1) + ") = " + deg(i) + ": deg+ = " + degPlus(i) + ", deg- = " + degSub(i));
		}

	}

	private int degSub(int v) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < numberOfVertexs; i++) {
			if (matrixAdj[i][v] != 0)
				count++;
		}
		return count;
	}

	private int degPlus(int v) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < numberOfVertexs; i++) {
			if (matrixAdj[v][i] != 0)
				count++;
		}
		return count;
	}

	@Override
	public int[] DFS(int startVertex) {
		// TODO Auto-generated method stub
		reSetAll();
		int[] result = new int[numberOfVertexs];
		Stack<Integer> st = new Stack<>();
		st.push(startVertex);
		visited[startVertex] = true;
		int pos = 0;
		while (!st.isEmpty()) {
			int u = st.pop();
			result[pos] = u;
			pos++;
			for (int i = numberOfVertexs - 1; i >= 0; i--) {
				if (matrixAdj[u][i] > 0 && visited[i] == false) {
					st.push(i);
					visited[i] = true;
				}

			}
		}
		printPath(result);
		return result;
	}

	@Override
	public int[] DFSRe(int startVertex) {
		// TODO Auto-generated method stub
		if (visited == null || pos == 0) {
			reSetAll();
			pathDFS = new int[numberOfVertexs];
			pos = 0;
		}

		visited[startVertex] = true;
		pathDFS[pos++] = startVertex;

		for (int i = 0; i < numberOfVertexs; i++) {
			if (matrixAdj[startVertex][i] > 0 && !visited[i]) {
				DFSRe(i);
			}
		}

		return pathDFS;
	}

	@Override
	public void BFS(int startVertex) {
		// TODO Auto-generated method stub
	    reSetAll();
	    Queue<Integer> queue = new LinkedList<>();
	    queue.add(startVertex);
	    visited[startVertex] = true;

	    while (!queue.isEmpty()) {
	        int u = queue.remove();
	        System.out.print((u + 1) + " ");

	        for (int i = 0; i < numberOfVertexs; i++) {
	            if (matrixAdj[u][i] > 0 && !visited[i]) {
	                queue.add(i);
	                visited[i] = true;
	            }
	        }
	    }
	}

	@Override
	public void removeEdge(int v1, int v2) {
		// TODO Auto-generated method stub
		if(v1 < 0 || v1 >= numberOfVertexs || v2 < 0 || v2 >= numberOfVertexs) {
			System.out.println("out of numberOfVertexs");
			return;
		}
		matrixAdj[v1][v2] = 0;
	}

	@Override
	public void connectedComponents() {
		// TODO Auto-generated method stub
		reSetAll();
	    int count = 0;

	    for (int i = 0; i < numberOfVertexs; i++) {
	        if (!visited[i]) {
	            count++;
	            pos = 0;
	            DFSRe(i);

	            System.out.print("Thanh phan lien thong thu " + count + ": ");
	            for (int j = 0; j < pos; j++) {
	                System.out.print((pathDFS[j] + 1) + " ");
	            }
	            System.out.println();
	        }
	    }
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		reSetAll();
	    BFS(0);

	    for (int i = 0; i < numberOfVertexs; i++) {
	        if (!visited[i]) return false;
	    }
	    return true;
	}
	boolean found = false;

	@Override
	public void findPath(int s, int t) {
	    visited[s] = true;
	    System.out.print((s + 1) + " ");

	    if (s == t) {
	        found = true;
	        return;
	    }

	    for (int i = 0; i < numberOfVertexs; i++) {
	        if (matrixAdj[s][i] > 0 && !visited[i] && !found) {
	            findPath(i, t);
	        }
	    }
	}

	@Override
	public void findPathBFS(int s, int t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isBipartite() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEulerGraph() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHalfEulerGraph() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void findEulerCycle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findHamiltonCycle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void BFS1(int start) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findEulerPath() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findHamiltonPath() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[][] spanningTreeDFSRe(int start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[][] spanningTreeDFS(int start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[][] spanningTreeBFS(int start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEdge(int v1, int v2, int[][] tree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[][] kruskal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[][] prim(int start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dijkstra(int start) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dijkstraAB(int start, int end) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dijkstraABbyC(int start, int end, int mid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void algoBellmanFord(int start) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void floyd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void floydExpand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Warshall() {
		// TODO Auto-generated method stub
		
	}
}
