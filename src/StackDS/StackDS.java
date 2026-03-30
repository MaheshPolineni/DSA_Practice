package StackDS;
import LinkedList.LinkList;

public class StackDS {
private int size = 0;
private Node top;


public void push(int number){
    if(size==0){
        top = new Node(number,null);
    }
    else{
        top = new Node(number,top);
    }
    size+=1;
}
public int peek(){
    if(size == 0){
        return -1;
    }
    else
        return top.getData();
}

public int pop(){
    if(size == 0){
        return -1;
    }
    else {
        size-=1;
        int value = top.getData();
        top = top.getPointer();
        return value;
    }
}

public int size(){
    return size;
}

public boolean isEmpty(){
    if(size == 0)
        return true;
    else
        return false;
}
public void clear(){
    size = 0;
    top = null;
}

public void display(){
    if(size == 0){
        System.out.println("null");
        return;
    }
    Node temp =top;
    while(temp!=null){
        System.out.println(temp.getData());
        temp = temp.getPointer();
    }
}

public static void main(String[] args){
    StackDS stack = new StackDS();
    System.out.println(stack.isEmpty());
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);
    System.out.println(stack.peek());
    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.size());
    stack.display();
    stack.clear();
    System.out.println(stack.size());
    System.out.println(stack.pop());
    System.out.println(stack.peek());
}
}
