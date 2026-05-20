package demo;

import java.util.*;

public class UnGraph extends Graph {
    int pos = 0;
    int[] x;

    public UnGraph(String path) {
        super(path);
        pathDFS = new int[numberOfVertex];
    }

    public UnGraph(int numberOfVertex, int[][] matrixAdj) {
        super(numberOfVertex, matrixAdj);
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (v1 < 0 || v1 >= numberOfVertex || v2 < 0 || v2 >= numberOfVertex) {
            System.out.println("Out of numberOfvertex");
            return;
        }
        matrixAdj[v1][v2] = matrixAdj[v2][v1] = 1;
    }

    @Override
    public void removeEdge(int v1, int v2) {
        if (v1 >= 0 && v1 < numberOfVertex && v2 >= 0 && v2 < numberOfVertex) {
            matrixAdj[v1][v2] = matrixAdj[v2][v1] = 0;
        }
        System.out.println("Out of number of vertex");
    }

    @Override
    public int deg(int v) {
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

        if (matrixAdj[v][v] == 1) {
            count++;
        }
        return count;
    }

    @Override
    public int numEdges() {
        int count = 0;
        for (int i = 0; i < numberOfVertex; i++) {
            for (int j = i; j < numberOfVertex; j++) {
                if (matrixAdj[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public void printPath(int[] path) {
        super.printPath(path);
    }

    @Override
    public int[] DFS(int startVertex) {
        reSetAll();
        int[] result = new int[numberOfVertex];
        Stack<Integer> st = new Stack<>();
        st.push(startVertex);
        visited[startVertex] = true;
        int pos = 0;
        while (!st.isEmpty()) {
            int u = st.pop();
            result[pos] = u;
            pos++;
            for (int i = numberOfVertex - 1; i >= 0; i--) {
                if (matrixAdj[u][i] > 0 && !visited[i]) {
                    st.push(i);
                    visited[i] = true;
                }
            }
        }
        printPath(result);
        return result;
    }

    @Override
    public void DFS1(int startVertex) {
        DFS(startVertex);
    }

    @Override
    public List<Integer> DFS2(int startVertex) {
        reSetAll();
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);
        visited[startVertex] = true;
        while (!stack.isEmpty()) {
            int u = stack.pop();
            list.add(u);
            for (int i = numberOfVertex - 1; i >= 0; i--) {
                if (matrixAdj[u][i] > 0 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }

            }
        }
        return list;
    }

    @Override
    public ArrayList<Integer> DFS3(int startVertex) {
        return (ArrayList<Integer>) DFS2(startVertex);
    }

    @Override
    public int[] DFS() {
        reSetAll();
        int[] result = new int[numberOfVertex];
        int index = 0;
        for (int i = 0; i < numberOfVertex; i++) {
            if (!visited[i]) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                visited[i] = true;
                while (!stack.isEmpty()) {
                    int u = stack.pop();
                    result[index] = u;
                    index++;
                    for (int j = numberOfVertex - 1; j >= 0; j--) {
                        if (matrixAdj[u][j] > 0 && !visited[j]) {
                            stack.push(j);
                            visited[j] = true;
                        }

                    }
                }
            }
        }
        return result;
    }

    @Override
    public int[] DFSRe(int startVertex) {
        if (pathDFS == null || pathDFS.length != numberOfVertex) {
            pathDFS = new int[numberOfVertex];
            pos = 0;
            reSetAll();
        }

        visited[startVertex] = true;
        pathDFS[pos] = startVertex;
        pos++;
        for (int i = 0; i < numberOfVertex; i++) {
            if (matrixAdj[startVertex][i] > 0 && !visited[i]) {
                DFSRe(i);
            }
        }
        return pathDFS;
    }

    @Override
    public int[] DFSRe() {
        reSetAll();
        pathDFS = new int[numberOfVertex];
        pos = 0;
        for (int i = 0; i < numberOfVertex; i++) {
            if (!visited[i]) {
                DFSRe(i);
            }
        }
        return pathDFS;
    }

    @Override
    public void BFS2(int startVertex) {
        reSetAll();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        visited[startVertex] = true;
        while (!queue.isEmpty()) {
            int u = queue.remove();
            System.out.print((u + 1) + " ");
            for (int i = 0; i < numberOfVertex; i++) {
                if (matrixAdj[u][i] > 0 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    @Override
    public void BFS2() {
        reSetAll();
        for (int i = 0; i < numberOfVertex; i++) {
            if (!visited[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int u = queue.remove();
                    System.out.print((u + 1) + " ");
                    for (int j = 0; j < numberOfVertex; j++) {
                        if (matrixAdj[u][j] > 0 && !visited[j]) {
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        System.out.println();
    }

    @Override
    public int[] BFS(int startVertex) {
        reSetAll();
        int[] result = new int[numberOfVertex];
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        visited[startVertex] = true;
        while (!queue.isEmpty()) {
            int u = queue.remove();
            result[index] = u;
            index++;
            for (int i = 0; i < numberOfVertex; i++) {
                if (matrixAdj[u][i] > 0 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return result;
    }

    @Override
    public int[] BFS() {
        reSetAll();
        int[] result = new int[numberOfVertex];
        int index = 0;
        for (int i = 0; i < numberOfVertex; i++) {
            if (!visited[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int u = queue.remove();
                    result[index] = u;
                    index++;
                    for (int j = 0; j < numberOfVertex; j++) {
                        if (matrixAdj[u][j] > 0 && !visited[j]) {
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        return result;
    }


    @Override
    public boolean isConnected() {
        reSetAll();
        BFS(0);
        for (int i = 0; i < numberOfVertex; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void connectedComponents() {
        int count = 0;
        int[] index = new int[numberOfVertex];
        Arrays.fill(index, -1);
        for (int i = 0; i < numberOfVertex; i++) {
            if (!visited[i]) {
                count++;
                index[i] = count;
                DFSRe(i);
                for (int j = 0; j < numberOfVertex; j++) {
                    if (visited[j] && index[j] == -1) {
                        index[j] = count;
                    }
                }
            }
        }
        for (int i = 1; i <= count; i++) {
            System.out.println("Thanh phan lien thong thu " + i + " gom cac dinh: ");
            for (int j = 0; j < numberOfVertex; j++) {
                if (index[j] == i) {
                    System.out.print((j + 1) + " ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public void findPath(int s, int t) {
        reSetAll();
        int[] parent = new int[numberOfVertex];
        for (int i = 0; i < numberOfVertex; i++) {
            parent[i] = -1;
        }
        //Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        boolean found = false;
        while (!queue.isEmpty()) {
            int u = queue.remove();
            if (u == t) {
                found = true;
                break;
            }
            for (int i = 0; i < numberOfVertex; i++) {
                if (matrixAdj[u][i] > 0 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    parent[i] = u;
                }
            }
        }
        if (!found) {
            System.out.println("Khong co duong di tu " + (s + 1) + " toi " + (t + 1));
            return;
        }

        Stack<Integer> path = new Stack<>();
        int current = t;
        while (current != -1 && current != s) {
            path.push(current);
            current = parent[current];
        }
        path.push(s);

        System.out.print("Duong di tu " + (s + 1) + " toi " + (t + 1) + ": ");
        while (!path.isEmpty()) {
            System.out.print(path.pop() + 1);
            if (!path.isEmpty())
                System.out.print(" --> ");
        }
        System.out.println();
    }

    @Override
    public void findPath2(int s, int t) {
        visited[s] = true;
        System.out.print((s + 1) + " ");
        for (int i = 0; i < numberOfVertex; i++) {
            if (matrixAdj[s][i] > 0 && !visited[i]) {
                if (i == t) {
                    System.out.print((t + 1) + " ");
                    return;
                } else {
                    findPath2(i, t);
                    return;
                }
            }
        }
    }


    @Override
    // Quick: findPath(s, t);
    public void findPathBFS(int s, int t) {
        visited[s] = true;
        System.out.print((s + 1) + " ");
        if (matrixAdj[s][t] > 0 || s == t) {
            System.out.print((t + 1) + " ");
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int x = queue.remove();
            for (int i = 0; i < numberOfVertex; i++) {
                if (matrixAdj[x][i] > 0 && visited[i] == false) {
                    visited[i] = true;
                    queue.add(i);
                    System.out.print((i + 1) + " ");
                    if (i == t) {
                        return;
                    }
                }
            }
        }
    }

    @Override
    public boolean isBipartite() {
        int[] color = new int[numberOfVertex];
        Arrays.fill(color, -1);

        int v = 0;
        int colorOne = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            int x = queue.remove();
            if (color[x] == -1) {
                color[x] = colorOne;
            }
            for (int i = 0; i < numberOfVertex; i++) {
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
        if (isConnected() == false) {
            return false;
        }
        for (int i = 0; i < numberOfVertex; i++) {
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
        } else if (isEulerGraph() == true) {
            return true;
        }
        int numberOfDegreeOdd = 0, numberOfDegreeEven = 0;
        for (int i = 0; i < numberOfDegreeOdd; i++) {
            if (deg(i) % 2 != 0) {
                numberOfDegreeOdd++;
            } else {
                numberOfDegreeEven++;
            }
        }
        return numberOfDegreeEven == 2 && numberOfDegreeEven == numberOfVertex - 2;
    }

    @Override
    public void findEulerCycle() {
        if (!isEulerGraph()) {
            System.out.println("Khong co chu trinh");
            return;
        }
        Stack<Integer> st = new Stack<>();
        List<Integer> EC = new ArrayList<>();
        int start = 0;
        int[][] tempUsingRemoveEdfes = matrixAdj;
        boolean foundX = false;
        st.push(start);
        while (!st.isEmpty()) {
            int x = st.peek();
            for (int i = 0; i < numberOfVertex; i++) {
                if (tempUsingRemoveEdfes[x][i] > 0) {
                    foundX = true;
                    st.push(i);
                    tempUsingRemoveEdfes[x][i] = tempUsingRemoveEdfes[i][x] = 0;
                    break;
                } else {
                    foundX = false;
                }
            }
            if (!foundX) {
                int y = st.pop();
                EC.add(y);
            }
        }
        printPathEnd(EC);
    }

    @Override
    public void findEulerPath() {
        if (isEulerGraph() == false && isHalfEulerGraph() == false) {
            System.out.println("Do thi khong co duong di Euler.");
            return;
        }
        int start = 0;
        for (int i = 0; i < numberOfVertex; i++) {
            if (deg(i) % 2 != 0) {
                start = i;
                break;
            }
        }
        int[][] temp = matrixAdj;
        Stack<Integer> st = new Stack<>();
        List<Integer> EC = new ArrayList<>();

        st.push(start);
        while (!st.isEmpty()) {
            int x = st.peek();
            boolean found = false;
            for (int i = 0; i < numberOfVertex; i++) {
                if (temp[x][i] > 0) {
                    st.push(i);
                    temp[x][i] = temp[i][x] = 0;
                    found = true;
                    break;
                }
            }
            if (found == false) {
                EC.add(st.pop());
            }
        }
        printPathEnd(EC);
    }


    private void printPathEnd(List<Integer> EC) {
        System.out.println("Chu trinh Euler:");

        // Vì thuật toán add theo kiểu ngược → cần đảo lại
        Collections.reverse(EC);

        for (int i = 0; i < EC.size(); i++) {
            System.out.print(EC.get(i) + 1);
            if (i != EC.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    @Override
    public void findHamiltonCycle() {
        if (!isConnected()) {
            System.out.println("Do thi khong lien thong -> khong co chu trinh H");
            return;
        }
        for (int i = 0; i < numberOfVertex; i++) {
            if (deg(i) < 2) {
                System.out.println("Do thi khong co chu trinh H");
                return;
            }
        }
        x = new int[numberOfVertex];
        Arrays.fill(x, -1);
        reSetAll();

        int start = 0;
        x[0] = start;
        visited[start] = true;

        expand(1);
        System.out.println(Arrays.toString(x));
        for (int i = 0; i < x.length; i++) {
            if (x[i] == -1) {
                System.out.println("Khong co chu trinh H vi dinh khop");
                return;
            }
        }


    }

    private void expand(int i) {
        for (int j = 0; j < numberOfVertex; j++) {
            if (matrixAdj[x[i - 1]][j] > 0 && visited[j] == false) {
                x[i] = j;
                if (i < numberOfVertex) {
                    visited[j] = true;
                    expand(i + 1);
                    visited[j] = false;
                } else {
                    if (matrixAdj[x[i]][x[0]] > 0) {
                        printPath(x); //printCycle();
                    }
                }
            }
        }
    }

    @Override
    public void findHamiltonPath() {
        if (isConnected() == false) {
            System.out.println("Do thi khong lien thong -> khong co duong di Hamilton");
            return;
        }

        // Thử xuất phát từ từng đỉnh một
        for (int start = 0; start < numberOfVertex; start++) {
            reSetAll();
            int[] pathH = new int[numberOfVertex];
            Arrays.fill(pathH, -1);
            pathH[0] = start;
            visited[start] = true;

            if (expandHamiltonPath(1, pathH)) {
                return; // Dừng lại khi tìm thấy đường đi đầu tiên
            }
        }
        System.out.println("Khong tim thay duong di Hamilton.");
    }

    private boolean expandHamiltonPath(int pos, int[] pathH) {
        if (pos == numberOfVertex) {
            System.out.print("Duong di Hamilton: ");
            for (int i = 0; i < numberOfVertex; i++) {
                System.out.print((pathH[i] + 1));
                if (i < numberOfVertex - 1) System.out.print(" -> ");
            }
            System.out.println();
            return true;
        }

        for (int v = 0; v < numberOfVertex; v++) {
            if (matrixAdj[pathH[pos - 1]][v] > 0 && visited[v] == false) {
                pathH[pos] = v;
                visited[v] = true;

                if (expandHamiltonPath(pos + 1, pathH)) {
                    return true;
                }

                // Backtrack
                visited[v] = false;
                pathH[pos] = -1;
            }
        }
        return false;
    }

    @Override
    public int[][] spanningTreeDFS(int start) {
        if (isConnected() == false) {
            System.out.println("Do thi khong lien thong, khong tim duoc cay bao trum");
            return null;
        }
        reSetAll();
        int[][] tree = new int[numberOfVertex][numberOfVertex];
        Stack<int[]> st = new Stack<>();
        st.push(new int[]{start, -1});
        System.out.println("Thu tu them canh (DFS): ");

        while (!st.isEmpty()) {
            int[] pop = st.pop();
            int u = pop[0];
            int parent = pop[1];

            if (visited[u] == false) {
                visited[u] = true;

                if (parent != -1) {
                    addEdge(parent, u, tree);
                    System.out.println((parent + 1) + " -> " + (u + 1));
                }

                for (int i = numberOfVertex; i >= 0; i--) {
                    if (matrixAdj[u][i] > 0 && visited[i] == false) {
                        st.push(new int[]{i, u});
                    }

                }
            }
        }
        return tree;
    }

    @Override
    public int[][] spanningTreeDFSRe(int start) {
        if (isConnected() == false) {
            System.out.println("Do thi khpng lien thong, khong tim duoc cay bao trum");
            return null;
        }
        reSetAll();
        int[][] tree = new int[numberOfVertex][numberOfVertex];
        System.out.println("Thu tu them canh (DFSRe): ");
        visitTree(start, tree, visited);
        return tree;
    }


    @Override
    public int[][] spanningTreeBFS(int start) {
        if (isConnected() == false) {
            System.out.println("Do thi khong lien thong, khong tim thay cay bao trum");
            return null;
        }
        reSetAll();
        int[][] tree = new int[numberOfVertex][numberOfVertex];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;
        System.out.println("Thu tu them canh {BFS): ");

        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int i = 0; i < numberOfVertex; i++) {
                if (matrixAdj[u][i] > 0 && visited[i] == false) {
                    addEdge(u, i, tree);
                    visited[i] = true;
                    System.out.println((u + 1) + " -> " + (i + 1));
                    queue.add(i);
                }
            }
        }
        return tree;
    }

    @Override
    public int[][] spanningTreeBFSRe(int start) {
        if (isConnected() == false) {
            System.out.println("Do thi khong lien thong, khong tim thay cay bao trum");
            return null;
        }
        reSetAll();
        int[][] tree = new int[numberOfVertex][numberOfVertex];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;
        System.out.println("Thu tu them canh (BFSRe): ");
        BFSTreeHelper(queue, tree);
        return tree;
    }

    @Override
    public void addEdge(int v1, int v2, int[][] tree) {
        if (v1 >= 0 && v1 < numberOfVertex && v2 >= 0 && v2 < numberOfVertex) {
            tree[v1][v2] = tree[v2][v1] = 1;
        } else {
            System.out.println("Lable vertex is not correct");
        }
    }

    private void visitTree(int i, int[][] temp, boolean[] trackInTree) {
        trackInTree[i] = true;
        for (int j = 0; j < numberOfVertex; j++) {
            if (matrixAdj[i][j] > 0 && trackInTree[j] == false) {
                addEdge(i, j, temp);
                System.out.println((i + 1) + " -> " + (j + 1));
                visitTree(j, temp, trackInTree);
            }
        }
    }

    private void BFSTreeHelper(Queue<Integer> queue, int[][] tree) {
        if (queue.isEmpty()) {
            return;
        }
        int u = queue.remove();
        for (int i = 0; i < numberOfVertex; i++) {
            if (matrixAdj[u][i] > 0 && visited[i] == false) {
                visited[i] = true;
                addEdge(u, i, tree);
                System.out.println((u + 1) + " -> " + (i + 1));
                queue.add(i);
            }
        }
        BFSTreeHelper(queue, tree);
    }

    @Override
    public void addEdge(int v1, int v2, int w, int[][] tree) {
        if (v1 >= 0 && v1 < numberOfVertex && v2 >= 0 && v2 < numberOfVertex) {
            tree[v1][v2] = tree[v2][v1] = w;
        } else {
            System.out.println("Lable vertex is not correct");
        }
    }

    @Override
    public void removeEdge(int v1, int v2, int w, int[][] tree) {
        if (v1 >= 0 && v1 < numberOfVertex && v2 >= 0 && v2 < numberOfVertex) {
            tree[v1][v2] = tree[v2][v1] = maxValue;
        } else {
            System.out.println("Lable vertex is not correct");
        }
    }

    @Override
    public int[][] krukal() {
//        if (isConnected() == false) {
//            System.out.println("Do thi khong lien thong");
//            return null;
//        }
//        int[][] tree = new int[numberOfVertex][numberOfVertex];
//        int countEdges = 0;
//        int weightTree = 0;
//        List<Edges> list = new ArrayList<>();
//
//        for (int i = 0; i < numberOfVertex; i++) {
//            for (int j = i + 1; j < numberOfVertex; j++) {
//                if (matrixAdj[i][j] > 0 && matrixAdj[i][j] != maxValue) {
//                    list.add(new Edges(i, j, matrixAdj[i][j]));
//                }
//            }
//        }
//
//        list.sort((e1, e2) -> Integer.compare(e1.getW(), e2.getW()));
//
//        int[] preV = new int[numberOfVertex];
//        for (int i = 0; i < numberOfVertex; i++) {
//            preV[i] = i;
//            for (Edges edges : list) {
//                if (preV[edges.getX()] != preV[edges.getY()]) {
//                    addEdge(edges.getX(), edges.getY(), edges.getW(), tree);
//                    edges.toString();
//                    countEdges++;
//                    weightTree += edges.getW();
//
//                    int v = pre[edges.getY()];
//                    for (int k = 0; k < numberOfVertex; k++) {
//                        if (pre[k] == v) ;
//                        pre[k] = pre[edges.getX()];
//                    }
//                    if (countEdges == numberOfVertex - 1) return k;
//                } else {
//                    edges.getY() edges.getX()
//                }
//            }
//
//        }
        return new int[0][];
    }

    public int[][] kruskall() {
        if (isConnected() == false) {
            System.out.println("Do thi khong lien thong");
            return null;
        }
        int[][] treeMST = new int[numberOfVertex][numberOfVertex];
        int countEdges =0;
        int weightTreeMST =0;
        List<Edges> list = new ArrayList<>();
        for (int i = 0; i < numberOfVertex; i++) {
            for (int j = i+1; j < numberOfVertex; j++) {
                if (matrixAdj[i][j] > 0 && matrixAdj[i][j] != maxValue) {
                    list.add(new Edges(i,j,matrixAdj[i][j]));
                }
            }
        }
        list.sort((e1, e2) -> Integer.compare(e1.getW(), e2.getW()));
        int[] preV = new int[numberOfVertex];
        for (int i = 0; i < preV.length; i++) {
            preV[i]=i;
        }
        for (Edges e : list) {
            if ( preV[e.getX()] != preV[e.getY()]) {
                addEdge(e.getX(), e.getY(),e.getW(), treeMST);
                System.out.println(e.toString());
                countEdges++;
                weightTreeMST += e.getW();
                int v = preV[e.getY()];
                for (int i = 0; i < numberOfVertex; i++) {
                    if (preV[i]==v) {
                        preV[i]=preV[e.getX()];

                    }
                }
                if (countEdges==numberOfVertex-1) break;
        } else {
                System.out.println(e.toString() + "-> Tao chu trinh");
            }
    }
        System.out.println("Tree Kruskal");
        printMatrix(treeMST);
        System.out.println("Weght: "+ weightTreeMST);
        return treeMST;
    }


    //v.T     E.kê    E.T.min (zic,zac    W.T       V.G
    //                             0        123456789
    //                           0+3=3        23456789
    //                             0        123456789
    //                             0        123456789
    //                             0        123456789
    //                             0        123456789
    @Override
    public int[][] prim(int start) {
        if (isConnected()==false) {
            System.out.println("Do thi khong lien thong");
            return null;
        }
        int[][] tree = new int[numberOfVertex][numberOfVertex];
        int countVex = 0;
        int w =0;
        boolean[] booleansInTree = new boolean[numberOfVertex];
        while (countVex < numberOfVertex-1) {
            int minE = countVex;
            int x =-1, y=-1;
            for (int i = 0; i < numberOfVertex; i++) {
                if (booleansInTree[i]==true) {
                    for (int j = 0; j < numberOfVertex; j++) {
                        if (matrixAdj[i][j] > 0 && matrixAdj[i][j] != maxValue && booleansInTree[i]==false && matrixAdj[i][j] <minE) {
                            minE=maxValue[i][j];
                            x = i;
                            y = j;
                            addEdge(x,y,minE,tree);
                            w++;
                            booleansInTree[y]=true;
                        }
                    }
                }
            }
        }
        return tree;
    }

    public int[][] prim2(int start) {
        if (isConnected()==false) {
            System.out.println("Do thi khong lien thong");
            return null;
        }
        int[][] treeMST = new int[numberOfVertex][numberOfVertex];
        int countVertexs=0;
        int weightTree =0;
        boolean[] trackInTree = new boolean[numberOfVertex];
        trackInTree[start]=true;
        while (countVertexs < numberOfVertex -1) {
            int minE = maxValue;
            int x =-1, y=-1;
            for (int i = 0; i < numberOfVertex; i++) {
                if (trackInTree[i]==true) {
                    for (int j = 0; j <numberOfVertex; j++) {
                        if (matrixAdj[i][j] >0 && matrixAdj[i][j] != maxValue<minE && trackInTree[j]==false) {
                            minE = maxValue[i][j];
                            x=i;
                            y=j;
                        }
                    }
                }
            }
            addEdge(x,y,minE,treeMST);
            System.out.println("(" + (x+1) +", " + (y+1) +")-"+ minE);
            countVertexs++;
            weightTree+=minE;
            trackInTree[i]=true;
        }
        System.out.println("tree prim");
        printMatrix(treeMST);
        System.out.println("weght:" + weightTree);
        return treeMST;
    }
}
