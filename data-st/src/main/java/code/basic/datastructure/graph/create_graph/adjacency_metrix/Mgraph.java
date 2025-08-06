package code.basic.datastructure.graph.create_graph.adjacency_metrix;

import java.util.Scanner;

/**
 *
 * 无向图---结点数组+邻接矩阵存储方案
 * <p>时间复杂度：O(n + n^2 +e),其中对邻接矩阵的初始化耗费了O(n^2)的时间
 * <p>对于稀疏邻接矩阵而言，会造成空间的浪费
 *
 * @author liu_ry@neusoft.com
 * @version 1.0.0
 * @since JDK1.8
 */
public class Mgraph {
    private char[] nodes;
    private int[][] connects;
    private int numNodes;
    private int numConnects;
    private int INFINITY = 10000;

    public void createMgragh() {
        int i, j, k, w;
        System.out.println("输入顶点(整数)：\n");
        Scanner scanner = new Scanner(System.in);
        numNodes = Integer.valueOf(scanner.next());
        nodes = new char[numNodes];
        connects = new int[numNodes][numNodes];
        System.out.println("输入边数(整数)：\n");
        numConnects = Integer.valueOf(scanner.next());

        //存储结点
        for (i = 0; i < numNodes; i++) {
            System.out.println("输入结点字符：\n");
            nodes[i] = scanner.next().charAt(0);
        }
        //初始化关系
        for (i = 0; i < numNodes; i++) {
            for (j = 0; j < numNodes; j++) {
                if (i == j) {
                    connects[i][j] = 0;
                }
                connects[i][j] = INFINITY;
            }
        }
        //设置结点关系
        System.out.println(String.format("行（小于%d）,列（小于%d）,权值（三者空格隔开）：", numNodes, numNodes));
        for (i = 0; i < numConnects; i++) {
            System.out.println(String.format("第%d/%d条边", i, numConnects - 1));
            String input = scanner.next();
            String[] inputs = input.split(",");
            System.out.println(inputs.length);
            connects[Integer.valueOf(inputs[0])][Integer.valueOf(inputs[1])] = Integer.valueOf(inputs[2]);
            connects[Integer.valueOf(inputs[1])][Integer.valueOf(inputs[0])] = Integer.valueOf(inputs[2]);
        }
        /*//打印
        for (i = 0; i < numNodes; i++) {
            for (j = 0; j < numNodes; j++) {
                System.out.print(connects[i][j] + "  ");
            }
            System.out.print("\n");
        }*/

    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new Mgraph().createMgragh();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
