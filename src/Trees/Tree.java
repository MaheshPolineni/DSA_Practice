package Trees;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
public class Tree {
    private Node root;
    final private Queue<Node> queue = new ArrayDeque<>();
    private Node currentNode = this.root;

    public Node getNode() {
        return root;
    }

    public void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.getValue());
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    public void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.println(node.getValue());
    }

    public void inOrder(Node node, ArrayList<Integer> list){
        if(node == null){
            return;
        }
        inOrder(node.getLeft(),list);
        list.add(node.getValue());
        inOrder(node.getRight(),list);
    }

    public void bfs(Node node){
        Node currentNode = node;
        Queue<Node> queue = new ArrayDeque<>();
        while(currentNode!=null) {
            System.out.println(currentNode.getValue());
            if(currentNode.getLeft()!=null)
                queue.offer(currentNode.getLeft());
            if(currentNode.getRight()!=null)
                queue.offer(currentNode.getRight());
            currentNode = queue.poll();
        }


    }

    public void setNode(Node node) {
        this.root = node;
    }



    @Override
    public String toString() {
        return "Tree{" +
                "node=" + root +
                '}';
    }
    public void insert(Integer data){
        if(this.root==null){
            this.root = new Node(data);
            currentNode = this.root;
            return;
        }
        if(this.currentNode.getLeft()==null || this.currentNode.getRight()==null){
            if(this.currentNode.getLeft()==null) {
                this.currentNode.setLeft(new Node(data));
                return;
            }
            if(this.currentNode.getRight()==null){
                this.currentNode.setRight(new Node(data));
            }
        }
        this.queue.offer(currentNode.getLeft());
        this.queue.offer(currentNode.getRight());
        this.currentNode = queue.poll();
    }

    public Node bst(Integer data, Node node){
        if(node == null){
            return node = new Node(data);
        }
        if(node.getValue()>data){
           node.setLeft(bst(data,node.getLeft()));
            return node;
        }
        if(node.getValue()<data){
           node.setRight(bst(data,node.getRight()));
            return node;
        }
        return node;
    }

    public void bstInsert(Integer data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        bst(data,root);
    }

    public Node findNode(Node node, Integer value){
        Node currentNode = node;
        while(currentNode!=null){
            if(value<=currentNode.getValue()){
                if(value== currentNode.getValue()){
                    return currentNode;
                }
                else{
                    currentNode = currentNode.getLeft();
                    continue;
                }
            }
            if(value> currentNode.getValue()){
                if(value == currentNode.getValue()){
                    return currentNode;
                }
                else{
                    currentNode=currentNode.getRight();
                }
            }
        }
        return null;
    }

    public Integer successor(Node node, ArrayList<Integer> list){
        inOrder(node, list);
        if(list.indexOf(node.getValue())==list.size()-1 || !(list.contains(node.getValue()))){
            return -1;
        }
        return list.get(list.indexOf(node.getValue())+1);
    }

//    public Integer inOrderSuccessor(Node node, Integer value){
//        if(node==null){
//            return -1;
//        }
//        ArrayList<Integer> list = new ArrayList<>();
//        Node currentNode = node;
//        while(currentNode!=null) {
//            if (value <= currentNode.getValue()) {
//                if (value == currentNode.getValue()) {
//                    return successor(currentNode,list);
//                } else {
//                    currentNode = currentNode.getLeft();
//                    continue;
//                }
//            }
//                if(value>currentNode.getValue()){
//                    currentNode = currentNode.getRight();
//                }
//        }
//        return  -1;
//    }
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.getLeft());
        int right = height(root.getRight());

        return 1 + Math.max(left, right);
    }

    public void deleteNode(Node node,Integer value){
        Node currentNode = node;
        Node parent = null;
        while(currentNode!=null) {
            if(currentNode.getValue()==value){
                break;
            }
            if(value< currentNode.getValue()){
                parent = currentNode;
                currentNode=currentNode.getLeft();
                continue;
            }
            if(value> currentNode.getValue()){
                parent = currentNode;
                currentNode = currentNode.getRight();
            }
        }
        if (currentNode.getRight() == null && currentNode.getLeft() == null) {
            if(parent.getLeft()!=null && parent.getLeft().getValue()==value){
                parent.setLeft(null);
                return;
            }
            else if(parent.getRight()!=null && parent.getRight().getValue()==value) {
                parent.setRight(null);
                return;
            }
        }

        if((currentNode.getRight()!=null && currentNode.getLeft()==null) || (currentNode.getRight()==null && currentNode.getLeft()!=null)){
            if(currentNode.getRight()!=null){
                if(parent.getLeft().getValue()==value){
                    parent.setLeft(currentNode.getRight());
                    return;
                }
                else if(parent.getRight().getValue()==value) {
                    parent.setRight(currentNode.getRight());
                    return;
                }
            }
            if(currentNode.getLeft()!=null){
                if(parent.getLeft().getValue()==value){
                    parent.setLeft(currentNode.getLeft());
                    return;
                }
                else if(parent.getRight().getValue()==value) {
                    parent.setRight(currentNode.getLeft());
                    return;
                }
            }

        }
        System.out.println(node);
    }






    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.bstInsert(50);
        tree.bstInsert(20);
        tree.bstInsert(70);
        tree.bstInsert(30);
        tree.bstInsert(40);
        tree.bstInsert(60);
        tree.bstInsert(80);
        tree.bstInsert(25);
        tree.bstInsert(35);
        tree.bstInsert(65);
        ArrayList<Integer> inOrderList = new ArrayList<>();
        System.out.print(Tree.height(tree.root));
        System.out.println(tree);
        tree.deleteNode(tree.root, 20);
    }
}
