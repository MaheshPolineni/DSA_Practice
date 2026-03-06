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

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(4);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        tree.insert(0);
        tree.postOrder(tree.root);
    }
}
