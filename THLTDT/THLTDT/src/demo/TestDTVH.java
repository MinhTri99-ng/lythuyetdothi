package demo;

import java.sql.PreparedStatement;

public class TestDTVH {
    public static void main(String[] args) {
        System.out.println("==========DO THI VO HUONG==========");
        Graph matrixVH = new UnGraph("E:\\THLTDTCT4\\src\\Euler.txt");
        Graph matrixVH2 = new UnGraph("E:\\THLTDTCT4\\src\\EulerG2");
        Graph matrixVH3 = new UnGraph("E:\\THLTDTCT4\\src\\Caybaotrum");
//        System.out.println("Ma tran vo huong BAN DAU");
//        matrixVH.printMatrix();
//        matrixVH.addEdge(11, 12);
//        System.out.println("Do thi sau khi them THAT BAI");
//        matrixVH.printMatrix();
//        matrixVH.addEdge(2, 0);
//        System.out.println("Do thi sau khi them THANH CONG");
//        matrixVH.printMatrix();
//        matrixVH.removeEdge(0, 0);
//        System.out.println("Do thi sau khi xoa THANH CONG");
//        matrixVH.printMatrix();
//
//        System.out.println("Bac cua mot dinh");
//        System.out.println(matrixVH.deg(2));
//
//        System.out.println("So dinh cua do thi");
//        System.out.println(matrixVH.numberOfVertex);
//        System.out.println("So canh cua do thi");
//        System.out.println(matrixVH.numEdges());
//        System.out.println("Tong bac cua do thi");
//        System.out.println(matrixVH.sumDeg());


        System.out.println("\n==========================");
        int start = 1;
//        System.out.println("DFS (" + (start + 1) +  ")");
//        matrixVH.DFS(start);
//        matrixVH.reSetAll();
//        System.out.println("DFSRe (" + (start + 1) +  ")");
//        matrixVH.printPath(matrixVH.DFSRe(start));
//
//        matrixVH.reSetAll();
//        System.out.println("BFS (" + (start + 1) +  ")");
//        matrixVH.BFS(start);
//        //if start =3 -> 4 1 3 2
//        //deg (1)3= deg+(2) deg-(1)
//
//        matrixVH.reSetAll();
//        System.out.println(matrixVH.isConnected()==true?"Do thi lien thong":"Do thi khong lien thong");
//
//        matrixVH.connectedComponents();
//        matrixVH.reSetAll();
//        matrixVH.findPath2(start, 3);

//        matrixVH.reSetAll();
//        matrixVH.findPathBFS(7,0);
//        System.out.println();
//        matrixVH.reSetAll();
////        matrixVH.removeEdge(7, 6);
//        matrixVH.printMatrix();
//        System.out.println(matrixVH.isBipartite() == true ? "Do thi luong phan" : "Do thi khong luong phan");
//
//        matrixVH.reSetAll();
//        System.out.println(matrixVH.isEulerGraph() == true ? "Do thi Euler" : "Khong la do thi Euler");
//
//        matrixVH.reSetAll();
//        System.out.println(matrixVH.isHalfEulerGraph() == true ? "Do thi nua Euler" : "Khong la do thi nua Euler");

//        matrixVH.reSetAll();
//        matrixVH.findEulerPath();
//
//        matrixVH2.reSetAll();
//        matrixVH2.findHamiltonCycle();
//        matrixVH2.findHamiltonPath();
        matrixVH3.spanningTreeBFS(start);
        matrixVH3.printMatrix();


    }
}
//VH 1-(2,3,4)  2-13   3-123  4-13
//CH 1->2  1->3  2->1 2->3  3->4

