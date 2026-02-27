package Trees;

public class Tree {
    private Node root;

    public Node getNode() {
        return root;
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
            root = new Node(data);
            return;
        } else if (root.getLeft()==null) {
            root.setLeft(new Node(data));
            return;
        } else if (root.getRight()==null) {
            root.setRight(new Node(data));
            return;
        }
        Node left = root.getLeft();
        Node right = root.getRight();
        while(left.getLeft()==null || left.getRight()==null){
            if(left.getLeft()==null){
                left.setLeft(new Node(data));
                left = left.getLeft();
                return;
            }
            else {
                left.setRight(new Node(data));
                left = left.getRight();
                return;
            }
        }
        while(right.getLeft()==null || right.getRight()==null){
            if(right.getLeft()==null){
                right.setLeft(new Node(data));
                right = right.getLeft();
                return;
            }
            else {
                right.setRight(new Node(data));
                right = right.getRight();
                return;
            }
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        tree.insert(10);
        tree.insert(11);
        System.out.println(tree);
    }
}
