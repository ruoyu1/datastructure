package code.basic.datastructure.graph.create_graph.adjacency_list;
/**
 * 顶点表结点
 *
 * @author liu_ry@neusoft.com
 * @date 2019/12/23 21:28
 * @version 1.0.0
 * @since JDK1.8
 */
public class VertexNode {
    private char data;
    private EdgeNode firstEdge;

    public VertexNode(char data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public EdgeNode getFirstEdge() {
        return firstEdge;
    }

    public void setFirstEdge(EdgeNode firstEdge) {
        this.firstEdge = firstEdge;
    }

    @Override
    public String toString() {
        return "VertexNode{" +
                "data=" + data +
                ", firstEdge=" + firstEdge +
                '}';
    }
}
