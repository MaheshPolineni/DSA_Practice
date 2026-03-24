package LinkedList;

public class LinkList<T> {
    private Nodes<T> tail;
    private Nodes<T> head;
    private int size=0;

    public void insert(T value){
        if(head==null){
            head=new Nodes<T>(value);
            tail=head;
            size+=1;
        }
        else{
            Nodes<T> node=head;
            while(node.getNode()!=null){
                node=node.getNode();
            }
            node.setNode(new Nodes<T>(value));
            tail=node.getNode();
            size+=1;
        }
    }

    public void insertAtBeginning(T value){
        if(head==null){
            head= new Nodes<T>(value);
            size+=1;
        }
        else{
            Nodes<T> node=new Nodes<T>(value);
            node.setNode(head);
            head=node;
            size+=1;
        }
    }

    public void insertAtPosition(int position,T value){
        if(position==1){
            insertAtBeginning(value);
            return;
        }
        int count=0;
        if(position>size){
            throw new RuntimeException("Array size is "+ size+", your position exceeds it");
        }
        Nodes<T> node=head;
        while(node.getNode()!=null && count<position-2){
            node=node.getNode();
            count++;
        }
        Nodes<T> newNode=node.getNode();
        node.setNode(new Nodes<>(value));
        node.getNode().setNode(newNode);
        size+=1;
    }

    public Object getFirst(){
        if(this.size==0){
            return -1;
        }
        return head.getData();
    }

    public Object getLast(){
        if(this.size==0){
            return -1;
        }
        return tail.getData();
    }

    public Object searchAValue(T value){
        Nodes<T> node=head;
        while(node!=null){
            if(node.getData().equals(value)){
                return value;
            }
            node=node.getNode();
        }
        return -1;
    }

    public Object retreiveAtPosition(int position){
        if(this.size<position){
            return -1;
        }
        if(position==1){
            return head.getData();
        }
        Nodes<T> node=head;
        Object data=0;
        for(int i=1;i<position;i++){
            node=node.getNode();
            if(i==position-1){
                data=node.getData();
            }
        }
        return data;
    }

    public Nodes<T> getTail() {
        return tail;
    }

    public void setTail(Nodes<T> tail) {
        this.tail = tail;
    }

    public Nodes<T> getHead() {
        return head;
    }

    public void setHead(Nodes<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
