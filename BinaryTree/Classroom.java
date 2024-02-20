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

        public static int diameter(Node root){
            if(root==null){
                return 0;
            }

            int leftdia=diameter(root.left);
            int leftHi=height(root.left);
            int rightdia=diameter(root.right);
            int rightHi=height(root.right);

            return Math.max(leftHi+rightHi+1, Math.max(rightdia, leftdia));
        }

        public static class Info{
            int dia;
            int ht;
            Info(int dia, int ht){
                this.dia=dia;
                this.ht=ht;
            }
        }

        public static Info diameterMod(Node root){
            if(root==null){
                return new Info(0, 0);
            }

            Info leftInfo=diameterMod(root.left);
            Info rightInfo=diameterMod(root.right);

            return new Info(Math.max(leftInfo.ht+rightInfo.ht+1, Math.max(rightInfo.dia, leftInfo.dia)), Math.max(leftInfo.ht, rightInfo.ht)+1);
        }


        public static boolean isIdentical(Node root, Node subroot){
            if(root==null && subroot==null){
                return true;
            }else if(root==null || subroot==null || root.data!=subroot.data){
                return false;
            }

            if(!isIdentical(root.left, subroot.left)){
                return false;
            }
            if(!isIdentical(root.right, subroot.right)){
                return false;
            }

            return true;
        }
        public static boolean isSubtree(Node root, Node subroot){
            if(root==null){
                return false;
            }

            if(root.data==subroot.data){
                if(isIdentical(root,subroot)){
                    return true;
                }
            }

            return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
        }
    }

    public static class Info2{
        int idx;
        Node n;

        Info2(int idx, Node n){
            this.idx=idx;
            this.n=n;
        }
    }
    public static void topView(Node root){
        int max=0;
        int min=0;
        HashMap<Integer, Node> map=new HashMap<>();
        
        Queue<Info2> q=new LinkedList<>();
        q.add(new Info2(0, root));
        q.add(null);
        while(!q.isEmpty()){
            Info2 curr=q.remove();
            if(curr==null){
                if(!q.isEmpty()){
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.idx)){
                    map.put(curr.idx, curr.n);
                }
                if(curr.n.left!=null){
                    q.add(new Info2(curr.idx-1, curr.n.left));
                    min=Math.min(min, curr.idx-1);

                }
                if(curr.n.right!=null){
                    q.add(new Info2(curr.idx+1, curr.n.right));
                    max=Math.max(max, curr.idx+1);

                }
            }

           
        }

        for (int i=min; i<=max ; i++) {
            System.out.print(map.get(i).data+" "  );
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
        System.out.println(BinaryTree.diameter(root)); 
        System.out.println(BinaryTree.diameterMod(root).dia);
        
        Node nroot=new Node(1);
        nroot.left=new Node(2);
        nroot.right=new Node(3);
        nroot.left.left=new Node(4);
        nroot.left.right=new Node(5);
        nroot.right.left=new Node(6);
        nroot.right.right=new Node(7);

        Node subroot=new Node(2);
        subroot.left=new Node(4);
        subroot.right=new Node(5);
        System.out.println(BinaryTree.isSubtree(nroot, subroot));
       // System.out.println();
        topView(nroot);
    }
}
