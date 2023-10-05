public class doubleLL {
    Node head;
    int size;
    public static class Node{
        int data;
        Node prev;
        Node next;
        Node(int data){
            this.data=data;
            this.prev=null;
            this.next=null;
        }
    }

    void addFirst(int data){        //T.C. : O(1)
        Node newNode=new Node(data);
        if(head==null){
            newNode.next=head;
           // head.prev=newNode;
            head=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
        
        
    }
    void addLast(int data){         //T.C. : O(n)
        Node newNode=new Node(data);
        if(head==null){
            addFirst(data);
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.prev=temp;
    }

    void printForward(){
        if(head==null)
        return;
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.print("Null");
    }
    void printBackward(){
        if(head==null)
        return;

        Node temp=head;
        while(temp.next!=null)
        temp=temp.next;

        while(temp!=head.prev){
            System.out.print(temp.data+" -> ");
            temp=temp.prev;
        }
        System.out.print("null");
    }

    public static void main(String args[]){
        doubleLL list=new doubleLL();
        list.addFirst(10);
        list.addFirst(5);
        list.addLast(55);
        list.printForward();
        System.out.println();
        list.printBackward();
    }





}
