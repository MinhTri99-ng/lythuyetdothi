package demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DiGraph extends Graph {
    public DiGraph(String path) {
        super(path);
    }

    public DiGraph(int numberOfVertex, int[][] matrixAdj) {
        super(numberOfVertex, matrixAdj);
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (v1 >= 0 && v1 < numberOfVertex && v2 >= 0 && v2 < numberOfVertex) {
            matrixAdj[v1][v2] = 1;
        }
        System.out.println("Out of number of vertex");
        return;
    }

    @Override
    public void removeEdge(int v1, int v2) {
        if (v1 >= 0 && v1 < numberOfVertex && v2 >= 0 && v2 < numberOfVertex) {
            matrixAdj[v1][v2] = 0;
        }
        System.out.println("Out of number of vertex");
        return;
    }

    @Override
    public int deg(int v) {
        if (v < 0 || v >= numberOfVertex) {
            return -1;
        }
        return inDegree(v) + outDegree(v);
    }

    @Override
    public void printPath(int[] path) {
        super.printPath(path);
    }

    @Override
    public void reSetAll() {
        super.reSetAll();
    }

    @Override
    public int[] DFS(int startVertex) {
        return new int[0];
    }

    @Override
    public void DFS1(int startVertex) {

    }

    @Override
    public List DFS2(int startVertex) {
        return List.of();
    }

    @Override
    public ArrayList DFS3(int startVertex) {
        return null;
    }

    @Override
    public int[] DFS() {
        return new int[0];
    }

    @Override
    public int[] DFSRe(int startVertex) {
        return new int[0];
    }

    @Override
    public int[] DFSRe() {
        return new int[0];
    }

    @Override
    public int[] BFS(int startVertex) {
        return new int[0];
    }

    @Override
    public int[] BFS() {
        return new int[0];
    }

    @Override
    public void BFS2(int startVertex) {

    }

    @Override
    public void BFS2() {

    }

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public void connectedComponents() {

    }

    @Override
    public void findPath(int s, int t) {

    }

    @Override
    public void findPath2(int s, int t) {

    }

    @Override
    public void findPathBFS(int s, int t) {

    }

    @Override
    public boolean isBipartite() {
        return false;
    }

    @Override
    public boolean isEulerGraph() {
        return false;
    }

    @Override
    public boolean isHalfEulerGraph() {
        return false;
    }

    @Override
    public void findEulerCycle() {
        return ;
    }

    @Override
    public void findHamiltonPath() {
        return ;
    }

    @Override
    public void findHamiltonCycle() {
        return ;
    }

    @Override
    public void findEulerPath() {
        return ;
    }

    @Override
    public int[][] spanningTreeDFS(int start) {
        return new int[0][];
    }

    @Override
    public int[][] spanningTreeBFS(int start) {
        return new int[0][];
    }

    @Override
    public void addEdge(int v1, int v2, int[][] tree) {

    }

    @Override
    public int[][] spanningTreeBFSRe(int start) {
        return new int[0][];
    }

    @Override
    public int[][] spanningTreeDFSRe(int start) {
        return new int[0][];
    }

    @Override
    public void addEdge(int v1, int v2, int w, int[][] tree) {

    }

    @Override
    public void removeEdge(int v1, int v2, int w, int[][] tree) {

    }

    @Override
    public int[][] krukal() {
        return new int[0][];
    }

    @Override
    public int[][] prim(int start) {
        return new int[0][];
    }
}
