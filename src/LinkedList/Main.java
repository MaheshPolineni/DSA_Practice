package LinkedList;

public class Main {
    static <G> void listOfElements(LinkList<G> list){
        Nodes<G> node=list.getHead();
        while(node!=null){
            System.out.println(node.getData());
            node=node.getNode();
        }
    }


    static <G> void printHeadTailAndSize(LinkList<G> list){
        System.out.println("Head : "+list.getHead());
        System.out.println("Tail : "+list.getTail());
        System.out.println("Size : "+list.getSize());
        listOfElements(list);
    }

    public static void main(String[] args) {
        LinkList<Integer> list=new LinkList<>();
        list.insert(10);
        list.insert(20);
        list.insert(40);
        list.insertAtBeginning(1);
        list.insertAtPosition(2,15);
        list.insertAtPosition(5,17);

        LinkList<String> list1=new LinkList<>();
        list1.insert("Mahesh");
        list1.insert("Good Morning");
        list1.insertAtBeginning("Hello,");

        listOfElements(list);
        System.out.println(list.retreiveAtPosition(4));

//        System.err.println(list1.searchAValue("Good Morning"));
//        System.out.println(list.getFirst());
//        System.out.println(list.getLast());
//        System.out.println(list1.getFirst());
//        System.out.println(list1.getLast());
//        printHeadTailAndSize(list);
//        printHeadTailAndSize(list1);

    }
}
