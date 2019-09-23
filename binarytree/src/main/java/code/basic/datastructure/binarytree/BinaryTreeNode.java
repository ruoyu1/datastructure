package code.basic.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author karen liu
 */
public class BinaryTreeNode<Data> {
    private BinaryTreeNode<Data> leftNode;
    private Data data;
    private BinaryTreeNode<Data> rightNode;

    public BinaryTreeNode<Data> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode<Data> leftNode) {
        this.leftNode = leftNode;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public BinaryTreeNode<Data> getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode<Data> rightNode) {
        this.rightNode = rightNode;
    }

    public BinaryTreeNode(Data data) {
        this.data = data;
    }

    public BinaryTreeNode() {
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "leftNode=" + leftNode +
                ", data=" + data +
                ", rightNode=" + rightNode +
                '}';
    }

    /**
     * 层序遍历:从上往下逐层遍历数据
     *
     * @param nodedatas 存放遍历结果
     * @param root      根结点
     * @param <Data>    任意数据类型
     * @return 遍历序列
     */
    private static <Data> List<Data> levelTravel(List<Data> nodedatas, BinaryTreeNode<Data> root) {
        ArrayList<BinaryTreeNode<Data>> levelNodes = new ArrayList<>();
        levelNodes.add(root);
        return levelTravel(new ArrayList<>(), levelNodes);
    }

    private static <Data> List<Data> levelTravel(List<Data> nodedatas, List<BinaryTreeNode<Data>> levelNodes) {
        if (levelNodes.size() == 0) {
            return nodedatas;
        }
        List<BinaryTreeNode<Data>> nextLevel = new ArrayList<>();
        levelNodes.forEach(node -> {
            nodedatas.add(node.getData());
            if (node.getLeftNode() != null) {
                nextLevel.add(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                nextLevel.add(node.getRightNode());
            }
        });
        return levelTravel(nodedatas, nextLevel);
    }

    /**
     * 前序遍历：根-左-右
     *
     * @param nodedatas 存放遍历结果
     * @param node      二叉树上的结点
     * @param <Data>    抽象数据类型
     * @return 结点数据序列
     */
    private static <Data> List<Data> preOrderTravel(List<Data> nodedatas, BinaryTreeNode<Data> node) {
        if (node == null) {
            return nodedatas;
        }
        nodedatas.add(node.getData());
        nodedatas = preOrderTravel(nodedatas, node.getLeftNode());
        nodedatas = preOrderTravel(nodedatas, node.getRightNode());
        return nodedatas;
    }

    /**
     * 后序遍历：左-右-根
     *
     * @param nodedatas 存放遍历结果
     * @param node      二叉树上的结点
     * @param <Data>    抽象数据类型
     * @return 结点数据序列
     */
    private static <Data> List<Data> postOrderTravel(List<Data> nodedatas, BinaryTreeNode<Data> node) {
        if (node == null) {
            return nodedatas;
        }
        nodedatas = postOrderTravel(nodedatas, node.getLeftNode());
        nodedatas = postOrderTravel(nodedatas, node.getRightNode());
        nodedatas.add(node.getData());
        return nodedatas;
    }

    /**
     * 中序遍历：左-根-右
     *
     * @param nodedatas 存放遍历结果
     * @param node      二叉树上的结点
     * @param <Data>    抽象数据类型
     * @return 结点数据序列
     */
    private static <Data> List<Data> inOrderTravel(List<Data> nodedatas, BinaryTreeNode<Data> node) {
        if (node == null) {
            return nodedatas;
        }
        nodedatas = postOrderTravel(nodedatas, node.getLeftNode());
        nodedatas.add(node.getData());
        nodedatas = postOrderTravel(nodedatas, node.getRightNode());
        return nodedatas;
    }

    /**
     * 层序扩展遍历
     *
     * @param nodedatas 存放遍历结果
     * @param root      根结点
     * @param <Data>    任意数据类型
     * @return 遍历序列
     */
    private static <Data> List<Data> levelExpansionTravel(List<Data> nodedatas, BinaryTreeNode<Data> root) {
        ArrayList<BinaryTreeNode<Data>> levelNodes = new ArrayList<>();
        levelNodes.add(root);
        return levelExpansionTravel(new ArrayList<>(), levelNodes);
    }

    private static <Data> List<Data> levelExpansionTravel(List<Data> nodedatas, List<BinaryTreeNode<Data>> levelNodes) {
        if (levelNodes.size() == 0) {
            return nodedatas;
        }
        List<BinaryTreeNode<Data>> nextLevel = new ArrayList<>();
        for (BinaryTreeNode<Data> node : levelNodes) {
            if (node == null) {
                nodedatas.add(null);
            } else {
                nodedatas.add(node.getData());
                nextLevel.add(node.getLeftNode());
                nextLevel.add(node.getRightNode());
            }
        }
        return levelExpansionTravel(nodedatas, nextLevel);
    }

    /**
     * 前序扩展遍历：根-左-右
     * <p>遇到 null 也会添加到遍历序列中，遍历的是原二叉树的扩展二叉树
     *
     * @param nodedatas 存放遍历结果
     * @param node      二叉树上的结点
     * @param <Data>    抽象数据类型
     * @return 结点数据序列
     */
    private static <Data> List<Data> preOrderExpansionTravel(List<Data> nodedatas, BinaryTreeNode<Data> node) {
        if (node == null) {
            nodedatas.add(null);
            return nodedatas;
        }
        nodedatas.add(node.getData());
        nodedatas = preOrderExpansionTravel(nodedatas, node.getLeftNode());
        nodedatas = preOrderExpansionTravel(nodedatas, node.getRightNode());
        return nodedatas;
    }

    /**
     * 后序扩展遍历：左-右-根
     * <p>遇到 null 也会添加到遍历序列中，遍历的是原二叉树的扩展二叉树
     *
     * @param nodedatas 存放遍历结果
     * @param node      二叉树上的结点
     * @param <Data>    抽象数据类型
     * @return 结点数据序列
     */
    private static <Data> List<Data> postOrderExpansionTravel(List<Data> nodedatas, BinaryTreeNode<Data> node) {
        if (node == null) {
            nodedatas.add(null);
            return nodedatas;
        }
        nodedatas = postOrderExpansionTravel(nodedatas, node.getLeftNode());
        nodedatas = postOrderExpansionTravel(nodedatas, node.getRightNode());
        nodedatas.add(node.getData());
        return nodedatas;
    }

    /**
     * 中序扩展遍历：左-根-右
     * <p>遇到 null 也会添加到遍历序列中，也就是说遍历的是原二叉树的扩展二叉树
     *
     * @param nodedatas 存放遍历结果
     * @param node      二叉树上的结点
     * @param <Data>    抽象数据类型
     * @return 结点数据序列
     */
    private static <Data> List<Data> inOrderExpansionTravel(List<Data> nodedatas, BinaryTreeNode<Data> node) {
        if (node == null) {
            nodedatas.add(null);
            return nodedatas;
        }
        nodedatas = inOrderExpansionTravel(nodedatas, node.getLeftNode());
        nodedatas.add(node.getData());
        nodedatas = inOrderExpansionTravel(nodedatas, node.getRightNode());
        return nodedatas;
    }

    /**
     * 给定前序扩展遍历序列创建二叉树
     *
     * @param nodedatas 存放遍历结果
     * @param node      新建的二叉树结点
     * @param <Data>    任意数据类型
     * @return 二叉树的根
     */
    private static <Data> BinaryTreeNode<Data> preOrderCreate(List<Data> nodedatas, BinaryTreeNode<Data> node) {
        if (nodedatas.get(0) == null) {
            nodedatas.remove(0);
            return node;
        }
        node.setData(nodedatas.get(0));
        nodedatas.remove(0);
        node.setLeftNode(preOrderCreate(nodedatas, new BinaryTreeNode<>()));
        node.setRightNode(preOrderCreate(nodedatas, new BinaryTreeNode<>()));
        return node;
    }

    /**
     * 获取二叉树的深度
     *
     * @param rootNode 二叉树根结点
     * @param <Data>   任意数据类型
     * @return 二叉树深度
     */
    private static <Data> int getDepth(BinaryTreeNode<Data> rootNode) {
        int depth = 0;
        List<BinaryTreeNode<Data>> node = new ArrayList<>();
        node.add(rootNode);
        return getDepth(node, depth);
    }

    private static <Data> int getDepth(List<BinaryTreeNode<Data>> nodes, int depth) {
        if (nodes.size() == 0) {
            return depth;
        }
        List<BinaryTreeNode<Data>> nextLevel = new ArrayList<>();
        for (BinaryTreeNode<Data> node : nodes) {
            if (node.getLeftNode() != null) {
                nextLevel.add(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                nextLevel.add(node.getRightNode());
            }
        }
        return getDepth(nextLevel, depth + 1);
    }

    /**
     * 竖向打印二叉树
     *
     * @param rootNode 二叉树根结点
     * @param <Data>   任意数据类型
     */
    private static <Data> void printBinaryTreeVt(BinaryTreeNode<Data> rootNode) {
        //求二叉树的深度
        int depth = getDepth(rootNode);
        //求二叉树层次扩展遍历结果
        List<Data> levelExpansionTravel = levelExpansionTravel(new ArrayList<>(), rootNode);
        //根据深度计算应该预留出的位置
        List<List<String>> str = new ArrayList<>();
        int length = (int) Math.round(Math.pow(2, depth) - 1);
        System.out.println(printBinaryTreeVt(levelExpansionTravel, new ArrayList<Integer>(), length, str, 1));
    }

    private static <Data> List<List<String>> printBinaryTreeVt(List<Data> levelExpansionTravel, ArrayList<Integer> lastLevelPosition, int branchLength, List<List<String>> str, int levelNum) {
        System.out.println(str);
        //本层的数据数量（包括为null的）
        int dataNum = (int) Math.round(Math.pow(2, levelNum) - 1);
        //在层次遍历序列的起始位置
        int dataStartPositon = (int) Math.pow(2, levelNum) - 2;
        if (levelExpansionTravel.size() == dataStartPositon) {
            return str;
        }
        List<String> levelStr = new ArrayList<>(7);
        levelStr.add(" ");
        levelStr.add(" ");
        levelStr.add(" ");
        levelStr.add(" ");levelStr.add(" ");levelStr.add(" ");
        levelStr.add(" ");

        ArrayList<Integer> newLevelPosition = new ArrayList<>(7);
        if (lastLevelPosition.size() == 0) {
            //向下取整
            double diff = (double) branchLength / 2 - 0.5;
            levelStr.set((int) Math.round(diff), levelExpansionTravel.get(dataStartPositon).toString());
            newLevelPosition.add((int) Math.round(diff));
        } else {
            for (int position : lastLevelPosition) {
                //向上取整
                double diff = (double) branchLength / 2 + 0.5;
                int newPosition = position - (int) Math.round(diff);
                levelStr.set(newPosition, levelExpansionTravel.get(dataStartPositon).toString());
                newLevelPosition.add(newPosition);
                //下移一个数据位置
                dataStartPositon = dataStartPositon + 1;
                newPosition = position + (int) Math.round(diff);
                levelStr.set(newPosition, levelExpansionTravel.get(dataStartPositon).toString());
                newLevelPosition.add(newPosition);

            }
            str.add(levelStr);
              }
        //层序遍历数据
        //需要知道基准位置链表，
        //需要知道分支的长度
        //String 二维数组存放结果

        return printBinaryTreeVt(levelExpansionTravel, newLevelPosition, Math.round((branchLength - 1) / 2), str, levelNum + 1);

    }

    /**
     * .......a
     * ..../   \
     * ..b      c
     * ./
     * d
     *
     * @param args not used
     */
    public static void main(String[] args) {
        BinaryTreeNode<String> a = new BinaryTreeNode<>("A");
        BinaryTreeNode<String> b = new BinaryTreeNode<>("B");
        BinaryTreeNode<String> c = new BinaryTreeNode<>("C");
        BinaryTreeNode<String> d = new BinaryTreeNode<>("D");

        a.setLeftNode(b);
        a.setRightNode(c);
        b.setLeftNode(d);

        printBinaryTreeVt(a);
        System.out.println(a);
        //层序遍历 A-B-C-D
        List<String> binaryTreeNodesData0 = levelTravel(new ArrayList<>(), a);
        System.out.println(String.format("二叉树层序遍历:%s", binaryTreeNodesData0));
        //前序遍历 A-B-D-C
        List<String> binaryTreeNodesData1 = preOrderTravel(new ArrayList<>(), a);
        System.out.println(String.format("二叉树前序遍历:%s", binaryTreeNodesData1));
        //中序遍历 D-B-A-C
        List<String> binaryTreeNodesData2 = inOrderTravel(new ArrayList<>(), a);
        System.out.println(String.format("二叉树中序遍历:%s", binaryTreeNodesData2));
        //后序遍历 D-B-C-A
        List<String> binaryTreeNodesData3 = postOrderTravel(new ArrayList<>(), a);
        System.out.println(String.format("二叉树后序遍历:%s", binaryTreeNodesData3));
        //中序扩展遍历 A-B-C-D-#-#-#-#
        List<String> binaryTreeNodesData7 = levelExpansionTravel(new ArrayList<>(), a);
        System.out.println(String.format("二叉树层序扩展遍历:%s", binaryTreeNodesData7));
        //前序扩展遍历 A-B-D-#-#-C-#-#
        List<String> binaryTreeNodesData4 = preOrderExpansionTravel(new ArrayList<>(), a);
        System.out.println(String.format("二叉树前序扩展遍历:%s", binaryTreeNodesData4));
        //中序扩展遍历 D-B-A-C
        List<String> binaryTreeNodesData5 = inOrderExpansionTravel(new ArrayList<>(), a);
        System.out.println(String.format("二叉树中序扩展遍历:%s", binaryTreeNodesData5));
        //后序扩展遍历 D-B-C-A
        List<String> binaryTreeNodesData6 = postOrderExpansionTravel(new ArrayList<>(), a);
        System.out.println(String.format("二叉树后序扩展遍历:%s", binaryTreeNodesData6));
        BinaryTreeNode<String> a_ = preOrderCreate(binaryTreeNodesData4, new BinaryTreeNode<>());

        System.out.println(String.format("二叉树深度:%s", getDepth(a)));
    }
}
