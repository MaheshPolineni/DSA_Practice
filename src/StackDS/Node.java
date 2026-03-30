package StackDS;

public class Node {
    private int data;
    private Node pointer;

    public Node(int data, Node pointer) {
        this.data = data;
        this.pointer = pointer;
    }

    public int getData() {
        return this.data;
    }

    public Node getPointer() {
        return this.pointer;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setPointer(Node pointer) {
        this.pointer = pointer;
    }
}
