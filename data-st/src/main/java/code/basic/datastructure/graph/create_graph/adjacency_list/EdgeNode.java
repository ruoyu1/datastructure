package code.basic.datastructure.graph.create_graph.adjacency_list;

/**
 * 边表结点
 *
 * @author liu_ry@neusoft.com
 * @version 1.0.0
 * @date 2019/12/23 21:22
 * @since JDK1.8
 */
public class EdgeNode {
    /* 邻接点域，存储该顶点对应的下标 */
    private int adjvex;
    /* 权重 */
    private int weight ;
    /* 指向下一个邻接点 */
    private EdgeNode next;

    public EdgeNode(int adjvex, int weight, EdgeNode next) {
        this.adjvex = adjvex;
        this.weight = weight;
        this.next = next;
    }

    public int getAdjvex() {
        return adjvex;
    }

    public void setAdjvex(int adjvex) {
        this.adjvex = adjvex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public EdgeNode getNext() {
        return next;
    }

    public void setNext(EdgeNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "EdgeNode{" +
                "adjvex=" + adjvex +
                ", weight=" + weight +
                ", next=" + next +
                '}';
    }
}
