package BinaryTree;
import java.util.*;
public class Classroom {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }

    public static class BinaryTree{
        public static int idx=-1;
        public static Node treeBuilder(int[] nodes){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            Node newNode=new Node(nodes[idx]);
            newNode.left=treeBuilder(nodes);
            newNode.right=treeBuilder(nodes);

            return newNode;
        }

        public static void preOrder(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root){
            if(root==null){
                return;
            }
            
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

        public static void postOrder(Node root){
            if(root==null){
                return;
            }
            
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }

        public static void levelOrder(Node root){
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node curr=q.remove();
                if(curr==null){
                    System.out.println();
                    if(!q.isEmpty()){
                        q.add(null);
                    }
                }else{
                System.out.print(curr.data+" ");
                if(curr.left!=null){
                    q.add(curr.left);
                } 
                if(curr.right!=null){
                    q.add(curr.right);
                }    
            }
            }
        }

        public static int height(Node root){
            if(root==null){
                return 0;
            }

            return Math.max(height(root.left), height(root.right))+1;
        }

        public static int nodesCount(Node root){
            if(root==null){
                return 0;
            }

            return nodesCount(root.left)+nodesCount(root.right)+1;
        }

        public static int nodesSum(Node root){
            if(root==null){
                return 0;
            }

            return nodesSum(root.left)+nodesSum(root.right)+root.data;
        }
    }

  
    public static void main(String[] args) {
        int[] nodes={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root=BinaryTree.treeBuilder(nodes);
        BinaryTree.preOrder(root);
        System.out.println();
        BinaryTree.inOrder(root);
        System.out.println();
        BinaryTree.postOrder(root);
        System.out.println();
        BinaryTree.levelOrder(root);
        System.out.println(BinaryTree.nodesCount(root));
        System.err.println(BinaryTree.height(root));
        System.out.println(BinaryTree.nodesSum(root));
        
    }
}
