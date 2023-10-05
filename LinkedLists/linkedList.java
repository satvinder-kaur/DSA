class linkedList{
    static Node head;
    int size;

    linkedList(){
        size=0;
    }

    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
     
    //******************************************* ADDITION OF NODES *******************************************
    //Addition of new node in the beginning
    public void addFirst(int data){
        size++;
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    //Appending new node to the linked list
    public void addLast(int data){
        size++;
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    //Addition of node at given position
    public void addMiddle(int position,int data){
        Node newNode=new Node(data);
        if(position==1){
            addFirst(data);
            return;
        }
        if(position>1 && position<=size){
            int count=1;
            Node temp=head;

            while(count<position-1 && temp.next!=null){
                temp=temp.next;
                System.out.println("Reached : "+temp.data);
                count++;
            }
            newNode.next=temp.next;
            temp.next=newNode;
            size++;
        }
    }

    //******************************************* REMOVAL OF NODES *******************************************
    //REmoving first node
    public void removeFirst(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        head=head.next;
        size--;
    }

    //Removing last node
    public void removeLast(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node temp=head;
        while(temp.next.next!=null)
        temp=temp.next;

        temp.next=null;
        size--;
    }

    //Removing node from specific position
    public void removeMiddle(int position){
        if(position<=0 || position>size){
            System.out.println("Invalid Index");
            return;
        }
        if(position==1)
        removeFirst();

        if(position>1 && position<=size){
            Node temp=head;
            int count=1;
            while(count<position-1 && temp.next!=null){
                temp=temp.next;
                count++;
            }
            temp.next=temp.next.next;
            size--;
        }
    }
    
    //******************************************* PRINT LIST, SIZE OF LIST, REVERSE LIST *******************************************

    public void printList(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node current=head;
        while(current!=null){
            System.out.print(current.data + "->");
            current=current.next;
        }
        System.out.println("NULL");
    }

    public void sizeList(){
        System.out.println("Size of list is : "+size);
    }

    public void reverse(){
        if(head==null||head.next==null)
        return;

        Node prevNode,current,nextNode;
        
        prevNode=head;
        current=prevNode.next;
        nextNode=current.next;

        prevNode.next=null;
        current.next=prevNode;

        while(nextNode!=null){
            prevNode=current;
            current=nextNode;
            nextNode=nextNode.next;
            current.next=prevNode;
        }
        head=current;        
    }


    public static void main(String args[]){
        linkedList list=new linkedList();
        // Node head=new Node();
        list.addFirst(10);
        list.addFirst(20);
        list.addLast(50);
        list.addLast(60);
        list.addLast(70);
        list.printList();
        list.removeMiddle(3);
        list.printList();
        list.sizeList();
        list.reverse();  
        list.printList();  



    }
}