package demo;

public class TestDTCH {
    public static void main(String[] args) {
        System.out.println("==========DO THI CO HUONG==========");
        Graph matrixCH = new DiGraph("E:\\THLTDTCT4\\src\\CH.txt");
        System.out.println("Ma tran co huong BAN DAU");
        matrixCH.printMatrix();

        matrixCH.addEdge(11, 12);
        System.out.println("Do thi sau khi them THAT BAI");
        matrixCH.printMatrix();
        matrixCH.addEdge(0, 0);
        System.out.println("Do thi sau khi them THANH CONG");
        matrixCH.printMatrix();
        matrixCH.removeEdge(0, 0);
        System.out.println("Do thi sau khi xoa THANH CONG");
        matrixCH.printMatrix();
        System.out.println("Bac cua mot dinh");
        System.out.println(matrixCH.deg(2));

        System.out.println("So dinh cua do thi");
        System.out.println(matrixCH.numberOfVertex);
        System.out.println("So canh cua do thi");
        System.out.println(matrixCH.numEdges());
        System.out.println("Tong bac cua do thi");
        System.out.println(matrixCH.sumDeg());


    }
}
