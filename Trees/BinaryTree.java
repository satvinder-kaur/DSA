import java.util.*;

public class BinaryTree {
    
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){         //Constructor of Node
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class bt{
        static int index=-1;

        public Node buildTree(int[] nodes){      //in preorder sequence 
            index++;

            if(nodes[index]==-1)
            return null;

            Node newNode=new Node(nodes[index]);
            newNode.left= buildTree(nodes);     //Building left subtree
            newNode.right=buildTree(nodes);     //Building right subtree

            return newNode;
        }
    }

    //DFS traversals of binary tree - preorder, inorder and postorder
    public static void preorder(Node root){   //T.C : O(n)
        if(root==null)
        return;

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);

    }

    public static void inorder(Node root){  //T.C : O(n)
        if(root==null)
        return;

        inorder(root.left);
        System.out.print(root.data+ " ");
        inorder(root.right);
    }

    public static void postorder(Node root){    //T.C : O(n)
        if(root==null)
        return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    //BFS traversal - level order traversal

    /*Consider a tree 
              1
          2       3
        4   5       6

        We want to print the elements level wise i.e.
        1
        2 3 
        4 5 6

        Algorithm:
        1.use queue for its fifo principle.
        2.insert root node along with a null. Null will be used to take ptr to next level
        3.read the current node.
        4.if it is not null then :- print the current node data and store its children in the queue.
        5.if itis null then use println() function to take it to next line and add null to the queue.
        6.if there is no element present after null simply wxit out of the loop

     */
    public static void levelOrder(Node root){   //T.C : O(n)
        if(root==null)
        return;

        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node current=q.remove();
           
            if(current==null){
                System.out.println();

                if(q.isEmpty())
                break;

                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(current.data+" ");
                
                if(current.left!=null)
                q.add(current.left);

                if(current.right!=null)
                q.add(current.right);
            }
        }
    }

    public static int countNode(Node root){     //T.C. : O(n)
        if(root==null)
        return 0;

        int leftNodes=countNode(root.left);
        int rightNodes=countNode(root.right);
        return leftNodes+rightNodes+1;
    }

    public static int sumOfNodes(Node root){
        if(root==null)
        return 0;

        int leftSum=sumOfNodes(root.left);
        int rightSum=sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    public static int height(Node root){
        if(root==null)
        return 0;

        int leftHeight=height(root.left);
        int rightHeight=height(root.right);

        return Math.max(leftHeight,rightHeight)+1;
    }

    //Diameter of a tree - No. of nodes in the longest path 
    /*
    there are two cases to calculate diameter of the tree 
    Case 1: passing through root

                *
            *       *
          *   *       *

    Nodes in longest path= 5

    Case 2 : not passing through root node

               *
            *     
          *  *
        *      *
      *
    *
  *
  Nodes in the longest path=8
 */

    //Approach 1
    public static int diameter(Node root){ //T.C.: O(n^2)
        if(root==null)
        return 0;

        int diam1=diameter(root.left);
        int diam2=diameter(root.right);
        int diam3=height(root.left)+height(root.right)+1;

        return Math.max(diam1,Math.max(diam2,diam3));
    }

    //Approach 2
    static class TreeInfo{
        int height;
        int diameter;

        TreeInfo(int height,int diameter){
            this.height=height;
            this.diameter=diameter;
        }
    }
    public static TreeInfo diameter2(Node root){        //T.C.: O(n)
        if(root==null)
        return new TreeInfo(0,0);

        TreeInfo left=diameter2(root.left);
        TreeInfo right=diameter2(root.right);

        int myHeight=Math.max(left.height,right.height)+1;

        int diam1=left.diameter;
        int diam2=right.diameter;
        int diam3=left.height+right.height+1;

        int myDiameter=Math.max(diam1,Math.max(diam2,diam3));

        return new TreeInfo(myHeight,myDiameter);
    }

    //If a tree is subtree of a tree
    //Leetcode : https://leetcode.com/problems/subtree-of-another-tree/ 


    public static void main(String[] args){
        int[] nodes={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        bt tree=new bt();
        Node root=tree.buildTree(nodes);
        System.out.println(root.data);
        levelOrder(root);
        System.out.println(diameter2(root).diameter);
    }
}
