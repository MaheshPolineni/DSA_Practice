package Trees;
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

    public void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.getLeft());
        System.out.println(node.getValue());
        inOrder(node.getRight());
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
        return null;
    }

    public void bstInsert(Integer data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        bst(data,root);
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.bstInsert(4);
        tree.bstInsert(2);
        tree.bstInsert(3);
        tree.bstInsert(1);
        tree.bstInsert(5);
        tree.bstInsert(0);
        tree.bstInsert(6);
        System.out.println(tree);

    }
}
