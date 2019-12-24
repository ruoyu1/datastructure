package code.basic.datastructure.graph.create_graph.adjacency_list;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 链表+邻接表
 *
 * @author liu_ry@neusoft.com
 * @version 1.0.0
 * @date 2019/12/23 21:33
 * @since JDK1.8
 */
public class AdList {
    private List<VertexNode> vertexNodes;
    private int numNodes;

    public List<VertexNode> getVertexNodes() {
        return vertexNodes;
    }

    public void setVertexNodes(List<VertexNode> vertexNodes) {
        this.vertexNodes = vertexNodes;
    }

    public int getNumNodes() {
        return numNodes;
    }

    public void setNumNodes(int numNodes) {
        this.numNodes = numNodes;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public void setNumEdges(int numEdges) {
        this.numEdges = numEdges;
    }

    private int numEdges;

    void createAlgraph(AdList adList) {

        System.out.println("输入顶点(整数)：\n");
        Scanner scanner = new Scanner(System.in);
        numNodes = Integer.valueOf(scanner.next());
        adList.setNumNodes(numNodes);
        System.out.println("输入边数(整数)：\n");
        numEdges = Integer.valueOf(scanner.next());
        adList.setNumEdges(numEdges);
        adList.setVertexNodes(new LinkedList<>());
        //存储顶点
        for (int i = 0; i < numNodes; i++) {
            System.out.println(String.format("第%d/%d顶点结点", i, numNodes - 1));
            char data = scanner.next().charAt(0);
            VertexNode vertexNode = new VertexNode(data);
            adList.getVertexNodes().add(vertexNode);
        }
        //存储边表
        System.out.println(String.format("起始点（小于%d）,终点（小于%d）,权值（三者空格隔开）：", numNodes, numNodes));
        for (int j = 0; j < numEdges; j++) {
            System.out.println(String.format("第%d/%d边结点", j, numEdges - 1));
            String input = scanner.next();
            String[] inputs = input.split(",");
            int numNodesPosition = Integer.valueOf(inputs[0]);
            EdgeNode edgeNode = new EdgeNode(Integer.valueOf(inputs[1]), Integer.valueOf(inputs[2]), null);
            //头插法
            VertexNode vertexNode = adList.getVertexNodes().get(numNodesPosition);
            EdgeNode temp = vertexNode.getFirstEdge();
            vertexNode.setFirstEdge(edgeNode);
            edgeNode.setNext(temp);
            numNodesPosition = Integer.valueOf(inputs[1]);
            EdgeNode edgeNode2 = new EdgeNode(Integer.valueOf(inputs[0]), Integer.valueOf(inputs[2]), null);
            VertexNode vertexNode2 = adList.getVertexNodes().get(numNodesPosition);
            EdgeNode temp2 = vertexNode2.getFirstEdge();
            vertexNode2.setFirstEdge(edgeNode2);
            edgeNode.setNext(temp2);
        }
        //打印
        for (int i = 0; i < numNodes; i++) {
            System.out.print(adList.getVertexNodes().get(i));
        }

    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        AdList adList = new AdList();
        adList.createAlgraph(adList);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
