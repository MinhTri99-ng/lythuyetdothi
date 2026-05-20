package demo;

import java.io.IOException;

public class MainTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Graph vh = new UnGraph("C:\Users\laptop usa pro\Desktop\LeMinhTri_24130333_DH24DTD_Tuan8\src\demo\DTVH.txt");
//		Graph ch = new DiGraph("C:\Users\laptop usa pro\Desktop\LeMinhTri_24130333_DH24DTD_Tuan8\src\demo\DTCH.txt");
//		System.out.println("===DO THI VO HUONG===");
//		vh.printMatrix();
//		System.out.println("So dinh: " + vh.numVertices());
//		System.out.println("So canh: " + vh.numEdges());
//		
//		System.out.println("Bac cac dinh: ");
//		vh.printAllDeg();
//		int start = 2;
//		System.out.println("DFS ("+ (start+1) +")");
//		vh.DFS(start);
//		vh.reSetAll();
//		
//		System.out.println("DFSRe ("+(start+1)+")");
//		vh.reSetAll();
//		int[] path = vh.DFSRe(start);
//		vh.printPath(path);
//		
//		System.out.println("BFS ("+(start+1)+")");
//		vh.BFS(start);
//		
//		vh.reSetAll();
//		vh.connectedComponents();
//		
//		System.out.println("Duong di: ");
//		vh.reSetAll();
//		((UnGraph) vh).found = false;
//		((UnGraph) vh).pos = 0;
//		vh.findPath(0, 4);
//		System.out.println();
//		
//		
//		
//
//		System.out.println("\n===DO THI CO HUONG===");
//		ch.printMatrix();
//		System.out.println("So dinh: " + ch.numVertices());
//		System.out.println("So canh: " + ch.numEdges());
//		
//		System.out.println("Bac cac dinh: ");
//		ch.printAllDeg();
//		
//		System.out.println("DFS ("+(start+1)+")");
//		ch.DFS(start);
//		ch.reSetAll();
//		
//		System.out.println("DFSRe ("+(start+1)+")");
//		ch.printPath(ch.DFSRe(start));
//		
//		System.out.println("BFS ("+(start+1)+")");
//		ch.BFS(start);
//		
//		ch.reSetAll();
//		ch.connectedComponents();
//		
//		System.out.println("Duong di: ");
//		ch.reSetAll();
//		((DiGraph) ch).found = false;
//		((DiGraph) ch).pos = 0;
//		ch.findPath(0, 4);
//		System.out.println("-----------DO THI G2------------");
//		Graph g2 = new UnGraph("C:\Users\laptop usa pro\Desktop\LeMinhTri_24130333_DH24DTD_Tuan8\src\demo\G2.txt");
//		System.out.println("\nBFS Path (1->7): ");
//		g2.reSetAll();
//		g2.findPathBFS(0, 6);
//		
//		System.out.println("\nIs Bipartite: " + g2.isBipartite());
//		
//		System.out.println("\nIs Euler Graph: " + g2.isEulerGraph());
//			
//		System.out.println("\nIs Half Euler Graph: " + g2.isHalfEulerGraph());
//		
//		g2.reSetAll();
//		g2.findEulerCycle();  
//		
//		g2.reSetAll();
//		g2.findHamiltonCycle();
//		
//		g2.reSetAll();
//		g2.findEulerPath();
//		System.out.println();
//		
//		g2.reSetAll();
//		g2.findHamiltonPath();
//		
//		g2.removeEdge(0, 1);
//		g2.removeEdge(1, 2);                    
//		g2.reSetAll();
//		System.out.println("Spanning tree DFSRe");
//		g2.printMatrix(g2.spanningTreeDFSRe(0));
//		
//		g2.reSetAll();
//		System.out.println("Spanning tree BFS");
//		g2.printMatrix(g2.spanningTreeBFS(1));
//		
//		Graph h =  new UnGraph("C:\Users\laptop usa pro\Desktop\LeMinhTri_24130333_DH24DTD_Tuan8\src\demo\H.txt");
//		System.out.println("===DO THI H===");
//		System.out.println("---Cay khung Kruskal---");
//		h.kruskal();
//		
//		int start1 = 1;
//		System.out.println("---Cay khung Prim---");
//		h.prim(start1);
//		
//		Graph h1 = new UnGraph("C:\Users\laptop usa pro\Desktop\LeMinhTri_24130333_DH24DTD_Tuan8\src\demo\H1.txt");
//		h1.printMatrix();
//		h1.reSetAll();
//		System.out.println("======Dijkstra======");
//		h1.dijkstra(0);
//		
//		System.out.println("=======Bellman Ford======");
//		h1.algoBellmanFord(0);
		
		Graph g3 = new DiGraph("C:\\Users\\laptop usa pro\\Desktop\\LeMinhTri_24130333_DH24DTD_Tuan8\\src\\demo\\G3.txt");
		g3.printMatrix();
		System.out.println("=====FLOYD=====");
		g3.floyd();
		System.out.println("=====FLOYD MO RONG=====");
		g3.floydExpand();
    	Graph g3a = new UnGraph("C:\\Users\\laptop usa pro\\Desktop\\LeMinhTri_24130333_DH24DTD_Tuan8\\src\\demo\\G3A.txt");
		g3a.printMatrix();
		
	}


}
