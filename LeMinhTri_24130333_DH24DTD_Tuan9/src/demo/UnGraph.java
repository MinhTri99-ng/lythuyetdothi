package demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class UnGraph extends Graph {

	public UnGraph() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnGraph(String path) throws NumberFormatException, IOException {
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
		matrixAdj[v2][v1] = 1;

	}

	@Override
	public int deg(int v) {
		// TODO Auto-generated method stub
		int deg = 0;
		for (int i = 0; i < matrixAdj.length; i++) {
			if (matrixAdj[v][i] != 0) {
				deg++;
			}
		}
		return deg;
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
		for (int i = 0; i < matrixAdj.length; i++) {
			System.out.println("deg(" + (i + 1) + ") = " + deg(i));

		}
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
				if (matrixAdj[u][i] > 0 && visited[i] == false) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}

	}

	@Override
	public void BFS1(int start) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.add(start);
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (int i = 0; i < numberOfVertexs; i++) {
				if (matrixAdj[u][i] > 0 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}

	}

	@Override
	public void removeEdge(int v1, int v2) {
		// TODO Auto-generated method stub
		matrixAdj[v1][v2] = 0;
		matrixAdj[v2][v1] = 0;

	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		reSetAll();
		BFS1(0);
		for (int i = 0; i < numberOfVertexs; i++) {
			if (visited[i] == false) {
				return false;
			}

		}
		return true;
	}

	@Override
	public void connectedComponents() {
		// TODO Auto-generated method stub
		reSetAll();
		int count = 0;
		int[] index = new int[numberOfVertexs];
		Arrays.fill(index, -1);
		for (int i = 0; i < numberOfVertexs; i++) {
			if (visited[i] == false) {
				count++;
				index[i] = count;
				pos = 0;
				pathDFS = new int[numberOfVertexs];
				DFSRe(i);
				for (int j = 0; j < numberOfVertexs; j++) {
					if (visited[j] == true && index[j] == -1) {
						index[j] = count;
					}

				}
			}

		}
		for (int i = 1; i <= count; i++) {
			System.out.print("Thanh phan lien thong thu " + i + " gom cac dinh: ");
			for (int j = 0; j < numberOfVertexs; j++) {
				if (index[j] == i) {
					System.out.print((j + 1) + " ");
				}
			}
			System.out.println();
		}
	}

	boolean found = false;

	@Override
	public void findPath(int s, int t) {
		// TODO Auto-generated method stub
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
		reSetAll();

		int[] parent = new int[numberOfVertexs];
		Arrays.fill(parent, -1);

		Queue<Integer> queue = new LinkedList<>();
		visited[s] = true;
		queue.add(s);

		while (!queue.isEmpty()) {
			int u = queue.poll();

			if (u == t)
				break;

			for (int i = 0; i < numberOfVertexs; i++) {
				if (matrixAdj[u][i] > 0 && !visited[i]) {
					visited[i] = true;
					parent[i] = u;
					queue.add(i);
				}
			}
		}
		if (!visited[t]) {
			System.out.println("Khong co duong di");
			return;
		}

		List<Integer> path = new ArrayList<>();
		for (int v = t; v != -1; v = parent[v]) {
			path.add(0, v);
		}

		for (int v : path) {
			System.out.print((v + 1) + " ");
		}
	}

	@Override
	public boolean isBipartite() {
		// TODO Auto-generated method stub
		int[] color = new int[numberOfVertexs];
		Arrays.fill(color, -1);
		int v = 0;
		int colorOne = 1;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		while (!queue.isEmpty()) {
			int x = queue.remove();
			if (color[x] == -1) {
				color[x] = colorOne;
			}
			for (int i = 0; i < numberOfVertexs; i++) {
				if (matrixAdj[x][i] > 0) {
					if (color[i] == -1) {
						color[i] = 1 - color[x];
						queue.add(i);
					} else if (color[i] == color[x]) {
						return false;
					}
				}
			}
		}
		return true;
	}

	@Override
	public boolean isEulerGraph() {
		// TODO Auto-generated method stub
		if (isConnected() == false) {
			return false;
		}
		for (int i = 0; i < numberOfVertexs; i++) {
			if (deg(i) % 2 != 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isHalfEulerGraph() {
		if (isConnected() == false) {
			return false;
		}

		int numberOfDegreeOdd = 0, numberOfDegreeEven = 0;
		for (int i = 0; i < numberOfVertexs; i++) {
			if (deg(i) % 2 != 0) {
				numberOfDegreeOdd++;
			} else {
				numberOfDegreeEven++;
			}
		}

		return numberOfDegreeOdd == 2 && numberOfDegreeEven == numberOfVertexs - 2;
	}

	@Override
	public void findEulerCycle() {
		// TODO Auto-generated method stub
		if (isEulerGraph() == false) {
			System.out.println("Do thi khong co chu trinh Euler");
			return;
		}
		Stack<Integer> st = new Stack<>();
		List<Integer> EC = new ArrayList<Integer>();
		int start = 0;
		int[][] tmpRemove = new int[numberOfVertexs][numberOfVertexs];
		for (int i = 0; i < numberOfVertexs; i++) {
			tmpRemove[i] = Arrays.copyOf(matrixAdj[i], numberOfVertexs);
		}
		boolean foundX = false;
		st.push(start);
		while (!st.isEmpty()) {
			int x = st.peek();
			for (int i = 0; i < numberOfVertexs; i++) {
				if (tmpRemove[x][i] > 0) {
					foundX = true;
					st.push(i);
					tmpRemove[x][i] = tmpRemove[i][x] = 0;
					break;

				} else {
					foundX = false;
				}
			}
			if (foundX == false) {
				int y = st.pop();
				EC.add(y);
			}
		}
		printPathEnd(EC);
	}

	private void printPathEnd(List<Integer> i) {
		// TODO Auto-generated method stub
		if (i == null || i.isEmpty()) {
			System.out.println("Khong co duong di");
			return;
		}
		System.out.println("\nDuong di: ");
		for (int j = 0; j < i.size(); j++) {
			System.out.print(i.get(j) + 1);
			if (j < i.size() - 1) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}

	@Override
	public void findEulerPath() {
		// TODO Auto-generated method stub
		if (!isConnected()) {
			System.out.println("Do thi khong lien thong");
			return;
		}
		int start = 0;
		int odd = 0;
		for (int i = 0; i < numberOfVertexs; i++) {
			if (deg(i) % 2 != 0) {
				odd++;
				start = i;
			}
		}
		if (odd != 0 && odd != 2) {
			System.out.println("Khong co duong di Euler");
			return;
		}
		int[][] tmp = new int[numberOfVertexs][numberOfVertexs];
		for (int i = 0; i < numberOfVertexs; i++) {
			tmp[i] = Arrays.copyOf(matrixAdj[i], numberOfVertexs);
		}
		Stack<Integer> st = new Stack<>();
		List<Integer> path = new ArrayList<>();
		st.push(start);
		while (!st.isEmpty()) {
			int u = st.peek();
			boolean found = false;
			for (int i = 0; i < numberOfVertexs; i++) {
				if (tmp[u][i] > 0) {
					st.push(i);
					tmp[u][i] = tmp[i][u] = 0;
					found = true;
					break;
				}
			}
			if (!found) {
				path.add(st.pop());
			}
		}
		System.out.println("Duong di Euler:");
		for (int v : path) {
			System.out.print((v + 1) + " ");
		}
	}

	int[] x;

	@Override
	public void findHamiltonCycle() {
		if (isConnected() == false) {
			System.out.println("Do thi khong lien thong -> khong co chu trinh H");
			return;
		}
		for (int i = 0; i < numberOfVertexs; i++) {
			if (deg(i) < 2) {
				System.out.println("Do thi khong co chu trinh");
				return;
			}
		}
		foundHamilton = false;
		for (int start = 0; start < numberOfVertexs; start++) {
			x = new int[numberOfVertexs];
			Arrays.fill(x, -1);
			reSetAll();
			x[0] = start;
			visited[start] = true;
			expand(1);
			if (foundHamilton)
				return;
		}
		System.out.println("Khong co chu trinh H");
	}

	boolean foundHamilton = false;

	private void expand(int i) {
		if (foundHamilton)
			return;
		for (int j = 0; j < numberOfVertexs; j++) {
			if (matrixAdj[x[i - 1]][j] > 0 && visited[j] == false) {
				x[i] = j;
				if (i < numberOfVertexs - 1) {
					visited[j] = true;
					expand(i + 1);
					visited[j] = false;
					x[i] = -1;
				} else {
					if (matrixAdj[x[i]][x[0]] > 0) {
						printCycle(x);
						foundHamilton = true;
						return;
					}
				}
			}
		}
	}

	private void printCycle(int[] x) {
		// TODO Auto-generated method stub
		if (x == null || x.length == 0) {
			System.out.println("Khong co chu trinh");
			return;
		}
		System.out.println("Chu trinh: ");
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + 1);
			if (i < x.length - 1) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}

	int[] pathH;
	boolean foundHPath = false;

	@Override
	public void findHamiltonPath() {
		// TODO Auto-generated method stub
		foundHPath = false;
		for (int start = 0; start < numberOfVertexs; start++) {
			pathH = new int[numberOfVertexs];
			Arrays.fill(pathH, -1);
			reSetAll();
			pathH[0] = start;
			visited[start] = true;
			expandH(1);
			if (foundHPath)
				return;
		}
		System.out.println("Khong co duong di Hamilton");
	}

	private void expandH(int i) {
		if (foundHPath)
			return;
		for (int j = 0; j < numberOfVertexs; j++) {
			if (matrixAdj[pathH[i - 1]][j] > 0 && !visited[j]) {
				pathH[i] = j;
				if (i < numberOfVertexs - 1) {
					visited[j] = true;
					expandH(i + 1);
					visited[j] = false;
					pathH[i] = -1;
				} else {
					printHamiltonPath(pathH);
					foundHPath = true;
					return;
				}
			}
		}
	}

	private void printHamiltonPath(int[] path) {
		System.out.println("Duong di Hamilton:");
		for (int v : path) {
			System.out.print((v + 1) + " ");
		}
		System.out.println();
	}

	@Override
	public int[][] spanningTreeDFSRe(int start) {
		// TODO Auto-generated method stub
		if (isConnected() == false) {
			System.out.println("Not found spanning tree");
			return null;
		}
		reSetAll();
		int[][] tree = new int[numberOfVertexs][numberOfVertexs];
		visitTree(start, tree, visited);
		return tree;
	}

	private int[][] visitTree(int i, int[][] temp, boolean[] trackInTree) {
		trackInTree[i] = true;
		for (int j = 0; j < trackInTree.length; j++) {
			if (matrixAdj[i][j] > 0 && trackInTree[j] == false) {
				addEdge(i, j, temp);
				System.out.println(i + " -> " + j);
				visitTree(j, temp, trackInTree);
			}
		}
		return temp;
	}

	@Override
	public int[][] spanningTreeDFS(int start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[][] spanningTreeBFS(int start) {
		// TODO Auto-generated method stub
		if (isConnected() == false) {
			System.out.println("Not found spanning tree");
			return null;
		}
		reSetAll();
		int[][] tree = new int[numberOfVertexs][numberOfVertexs];
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.add(start);
		while (!queue.isEmpty()) {
			int x = queue.remove();
			for (int i = 0; i < tree.length; i++) {
				if (matrixAdj[x][i] > 0 && visited[i] == false) {
					System.out.println(x + "->" + i);
					addEdge(x, i, tree);
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		return tree;
	}

	@Override
	public void addEdge(int v1, int v2, int[][] tree) {
		// TODO Auto-generated method stub
		if (v1 >= 0 && v1 < numberOfVertexs && v2 >= 0 && v2 <= numberOfVertexs) {
			tree[v1][v2] = tree[v2][v2] = 1;
		} else {
			System.out.println();
			return;
		}

	}

	@Override
	public int[][] kruskal() {
		// TODO Auto-generated method stub
		if (isConnected() == false) {
			System.out.println("Do thi khong lien thong");
			return null;
		}
		int[][] treeMST = new int[numberOfVertexs][numberOfVertexs];
		int countEdges = 0;
		int weightTree = 0;
		List<Edges> list = new ArrayList<>();
		for (int i = 0; i < numberOfVertexs; i++) {
			for (int j = i + 1; j < numberOfVertexs; j++) {
				if (matrixAdj[i][j] > 0 && matrixAdj[i][j] != Integer.MAX_VALUE) {
					list.add(new Edges(i, j, matrixAdj[i][j]));
				}

			}

		}
		list.sort((e1, e2) -> Integer.compare(e1.getW(), e2.getW()));
		int[] preV = new int[numberOfVertexs];
		for (int i = 0; i < preV.length; i++) {
			preV[i] = i;
		}
		for (Edges e : list) {
			if (preV[e.getX()] != preV[e.getY()]) {
				addEdge(e.getX(), e.getY(), e.getW(), treeMST);
				System.out.println("(" + (e.getX() + 1) + "," + (e.getY() + 1) + ") = " + e.getW());
				countEdges++;
				weightTree += e.getW();
				int v = preV[e.getY()];
				for (int i = 0; i < numberOfVertexs; i++) {
					if (preV[i] == v) {
						preV[i] = preV[e.getX()];
					}

				}
				if (countEdges == numberOfVertexs - 1)
					break;

			} else {
				System.out.println(e.toString() + "-> Tao chu trinh");
			}
		}
		System.out.println("Tree Kruskal");
		printMatrix(treeMST);
		System.out.println("weight: " + weightTree);
		return treeMST;
	}

	private void addEdge(int x, int y, int w, int[][] treeMST) {
		// TODO Auto-generated method stub
		treeMST[x][y] = w;
		treeMST[y][x] = w;
	}

	@Override
	public int[][] prim(int start) {
		// TODO Auto-generated method stub
		if (isConnected() == false) {
			System.out.println("Do thi khong lien thong");
			return null;
		}
		int[][] treeMST = new int[numberOfVertexs][numberOfVertexs];
		int countVex = 0;
		int totalWeight = 0;
		boolean[] visited = new boolean[numberOfVertexs];
		visited[start] = true;
		countVex = 1;
		while (countVex < numberOfVertexs) {
			int minEdg = Integer.MAX_VALUE;
			int x = -1;
			int y = -1;
			for (int i = 0; i < numberOfVertexs; i++) {
				if (visited[i] == true) {
					for (int j = 0; j < numberOfVertexs; j++) {
						if (!visited[j] && matrixAdj[i][j] > 0 && matrixAdj[i][j] != Integer.MAX_VALUE
								&& matrixAdj[i][j] < minEdg) {
							minEdg = matrixAdj[i][j];
							x = i;
							y = j;

						}
					}
				}
			}
			addEdge(x, y, minEdg, treeMST);
			System.out.println("(" + (x + 1) + "," + (y + 1) + ") = " + minEdg);
			countVex++;
			totalWeight += minEdg;
			visited[y] = true;
		}
		System.out.println("Tree prim");
		printMatrix(treeMST);
		System.out.println("Weight: " + totalWeight);
		return treeMST;
	}

	@Override
	public void dijkstra(int start) {
		// TODO Auto-generated method stub
		if (isConnected() == false) {
			System.out.println("Do thi khong lien thong");
			return;
		}
		for (int i = 0; i < numberOfVertexs; i++) {
			for (int j = 0; j < numberOfVertexs; j++) {
				if (matrixAdj[i][j] < 0) {
					System.out.println("Do thi co trong so canh la so am");
					return;
				}
			}
		}
		boolean[] R = new boolean[numberOfVertexs];
		int[] L = new int[numberOfVertexs];
		int[] P = new int[numberOfVertexs];
		for (int i = 0; i < P.length; i++) {
			L[i] = Integer.MAX_VALUE;
			P[i] = -1;

		}
		L[start] = 0;
		int countSelect = 0;
		while (countSelect < numberOfVertexs - 1) {
			int v = -1;
			int minL = Integer.MAX_VALUE;
			for (int i = 0; i < numberOfVertexs; i++) {
				if (L[i] < minL && R[i] == false) {
					minL = L[i];
					v = i;
				}
			}
			for (int j = 0; j < numberOfVertexs; j++) {
				if (matrixAdj[v][j] > 0 && matrixAdj[v][j] != Integer.MAX_VALUE) {
					if (L[j] > L[v] + matrixAdj[v][j] && R[j] == false) {
						L[j] = L[v] + matrixAdj[v][j];
						P[j] = v;
					}
				}

			}
			countSelect++;
			R[v] = true;
		}
		for (int i = 0; i < numberOfVertexs; i++) {
			System.out.println("Duong di tu " + (start + 1) + " toi " + (i + 1));
			System.out.print((start + 1));
			printPathDijkstra(P, i);
			System.out.println("\tkhoang cach: " + L[i] + "\n");
		}
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
		if (isConnected() == false) {
			System.out.println("Do thi khong lien thong");
			return;
		}
		boolean stop = false;
		int[] L = new int[numberOfVertexs];
		int[] P = new int[numberOfVertexs];
		for (int i = 0; i < P.length; i++) {
			L[i] = Integer.MAX_VALUE;
			P[i] = -1;
		}
		L[start] = 0;
		int k = 0;
		while (!stop) {
			k++;
			stop = true;
			for (int i = 0; i < numberOfVertexs; i++) {
				for (int j = 0; j < numberOfVertexs; j++) {
					if (matrixAdj[i][j] != 0 && matrixAdj[i][j] != Integer.MAX_VALUE) {
						if (L[j] > L[i] + matrixAdj[i][j]) {
							L[j] = L[i] + matrixAdj[i][j];
							P[j] = i;
							stop = false;
						}
					}

				}

			}
			if (k == numberOfVertexs - 1) {
				if (stop == false) {
					stop = true;
					System.out.println("Do thi co chu trinh am");
					return;
				}
			}
		}
		for (int i = 0; i < numberOfVertexs; i++) {
			System.out.println("Duong di tu " + (start + 1) + " toi " + (i + 1));
			System.out.print((start + 1));
			printPathDijkstra(P, i);
			System.out.println("\tkhoang cach: " + L[i] + "\n");
		}

	}
	public boolean checkCycle(int[][] W) {
		for (int i = 0; i < numberOfVertexs; i++) {
			if (W[i][i] < 0) {
				System.out.println("Do thi co chu trinh am tai dinh: ");
				return true;
			}
		}
		return false;
	}

	@Override
	public void floyd(){
		int[][] w=new int[numberOfVertexs][numberOfVertexs];
		 if(checkCycle(w)==false) {
			 return;
		 }
		 for(int i=0;i<numberOfVertexs;i++) {
			 for(int j=0;j<numberOfVertexs;j++) {
				w[i][j]=matrixAdj[i][j];
			 }
			 
		 }
		 for(int k=0;k<numberOfVertexs;k++) {
		 for(int i=0;i<numberOfVertexs;i++) {
			 for(int j=0;j<numberOfVertexs;j++) {
				 if(w[i][j]>w[i][k]+w[k][i]) {
					 w[i][j]=w[i][k]+w[k][j];
				 }
			 }
		 }
		 System.out.println("(W"+(k+1)+")");
		 printMatrix(w);
		}}

	@Override
	public void floydExpand() {
		// TODO Auto-generated method stub
		int[][] W = new int[numberOfVertexs][numberOfVertexs];

		if (checkCycle(W) == false) {
			return;
		}
		int[][] P = new int[numberOfVertexs][numberOfVertexs];
		for (int i = 0; i < numberOfVertexs; i++) {
			for (int j = 0; j < numberOfVertexs; j++) {
				if (i == j) {
					W[i][j] = 0;
					P[i][j] = -1;
				} else if (matrixAdj[i][j] == 0) {
					W[i][j] = maxValue;
					P[i][j] = -1;
				} else {
					W[i][j] = matrixAdj[i][j];
					P[i][j] = j;
				}
			}

		}
		for (int k = 0; k < numberOfVertexs; k++) {
			for (int i = 0; i < numberOfVertexs; i++) {
				for (int j = 0; j < numberOfVertexs; j++) {
					if (W[i][j] > W[i][k] + W[k][j]) {
						W[i][j] = W[i][k] + W[k][j];
						P[i][j] = k;
					}

				}

			}
			System.out.println("(W" + (k + 1) + ")");
			printMatrix(W);
			System.out.println("(P" + (k + 1) + ")");
			printMatrix(P);
		}
	}
}
