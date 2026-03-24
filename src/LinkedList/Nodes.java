package LinkedList;

public class Nodes<G> {
    private G data;
    private Nodes<G> node;

    public Nodes(G data){
        this.data=data;
    }

    public Nodes(G data,Nodes<G> node){
        this.data=data;
        this.node=node;
    }

    public Nodes<G> getNode() {
        return node;
    }

    public void setNode(Nodes<G> node) {
        this.node = node;
    }

    public G getData() {
        return data;
    }

    public void setData(G data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Nodes{" +
                "data=" + data +
                ", node=" + node +
                '}';
    }
}

