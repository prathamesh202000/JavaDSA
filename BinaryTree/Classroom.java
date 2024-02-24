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
        public static  void kthLevel(Node root, int k, int i){
            if (root==null) {
                return;
            }
            if (k==i) {
                System.out.print(root.data+" ");
            }

            kthLevel(root.left, k, i+1);
            kthLevel(root.right, k, i+1);
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

    public static boolean getPath(Node root, int n, ArrayList<Node> p){
       

        if(root==null){
            return false;
        }
        p.add(root);
        if(root.data==n){
            return true;
        }

        if(getPath(root.left, n, p) || getPath(root.right, n, p)){
            return true;
        }

        p.remove(p.size()-1);
        return false;

    }
    public static Node lca(Node root, int a, int b){
        ArrayList<Node> p1=new ArrayList<>();
        ArrayList<Node> p2=new ArrayList<>();

        getPath(root, a, p1);
        getPath(root, b, p2);
       
       
        int i=0;
        for( ;i<p1.size() && i<p2.size(); i++){
            if(p1.get(i)!=p2.get(i)){
                break;
            }
        }

        return p1.get(i-1);

    }

    public static Node lca2(Node root, int a, int b){
        if(root==null || root.data==a || root.data==b){
            return root;
        }

        Node leftLca=lca2(root.left, a, b);
        Node rightLca=lca2(root.right, a, b);

        if(leftLca==null){
            return rightLca;
        }        
        if(rightLca==null){
            return leftLca;
        }

        return root;
    }

    public static int lcaDist(Node root, int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftDist=lcaDist(root.left, n);
        int rightDist=lcaDist(root.right, n);

        if(leftDist==-1 && rightDist==-1){
            return -1;
        }else if(leftDist==-1){
            return rightDist+1;
        }else{
            return leftDist+1;
        }

    }

    public static int minDist(Node root, int a, int b){
        Node lca=lca2(root, a, b);
        int leftDist=lcaDist(lca, a);
        int rightDist=lcaDist(lca, b);

        return leftDist+rightDist;  
    }
    
    public static int KthAncestor(Node root, int n, int k){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }

        int leftAnc=KthAncestor(root.left, n, k);
        int rightAnc=KthAncestor(root.right, n, k);

        if(leftAnc==-1 && rightAnc==-1){
            return -1;
        }
        int max=Math.max(leftAnc, rightAnc);
        if(max+1==k){
            System.out.println(root.data);
        }
        return max+1;
    }

    public static int sumTree(Node root){
        if(root==null){
            return 0;
        }

       
        int leftChild=sumTree(root.left);
        int rightChild=sumTree(root.right);
        int curr=root.data;
        int newLeft=root.left==null?0:root.left.data;
        int newRight=root.right==null?0:root.right.data;

        root.data=newLeft+newRight+leftChild+rightChild;
        return curr;
    }

    public static boolean isUnivaluedTree(Node root){
        if(root==null){
            return true;
        }
        if(root.left!=null && root.data!=root.left.data){
            return false;
        }
        if(root.right!=null && root.data!=root.right.data){
            return false;
        }
        return isUnivaluedTree(root.left) && isUnivaluedTree(root.right);
    }

    public static Node deleteLeaves(Node root, int x){
        if(root==null){
            return null;
        }
        if(root.data==x && root.left==null && root.right==null){
            return null;
        }
        root.left=deleteLeaves(root.left, x);
        root.right=deleteLeaves(root.right, x);
        return root;
    }

    public static String printAllDuplicates(HashMap<String, Integer> map, Node root){
        if(root==null){
            return "";
        }

        String ans="(";
        ans+=printAllDuplicates(map, root.left);
        ans+=root.data;
        ans+=printAllDuplicates(map, root.right);
        ans+=")";

        if(map.get(ans)!=null && map.get(ans)==1){
            System.out.println(root.data);
        }

        if(map.containsKey(ans)){
            map.put(ans, map.get(ans)+1);
        }else{
            map.put(ans, 1);
        }

        return ans;

    }
    public static Node mirrorTree(Node root){
        if(root==null){
            return root;
        }
        Node left=mirrorTree(root.left);
        Node right=mirrorTree(root.right);
       
        root.left=right;
        root.right=left;
        return root;
    }
    public static int max=Integer.MIN_VALUE;
    public static int maxSumPath(Node root){
        if(root==null){
            return 0;
        }

        int left=maxSumPath(root.left);
        int right=maxSumPath(root.right);
        int maxSingle=Math.max(Math.max(left, right)+root.data, root.data);
        int maxTop=Math.max(maxSingle, left+right+root.data);
        max=Math.max(max, maxTop);

        return maxSingle;
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
        System.out.println();
        BinaryTree.kthLevel(nroot, 3, 1);
        System.out.println();
        System.out.println(lca(nroot, 6, 7).data);        
        System.err.println(lca2(nroot, 6, 7).data);
        System.out.println(minDist(nroot, 4, 6));
        KthAncestor(nroot, 4, 2);
        //System.out.println(sumTree(nroot));
        BinaryTree.levelOrder(nroot);
        Node same=new Node(1);
        same.left=new Node(1);
        same.right=new Node(1);
      
        System.out.println(isUnivaluedTree(same));
        mirrorTree(nroot);
        deleteLeaves(nroot, 6);
        BinaryTree.levelOrder(nroot);
        
        Node dup=new Node(1);
        dup.left=new Node(2);
        dup.right=new Node(3);
        dup.left.left=new Node(4);
        dup.right.left=new Node(2);
        dup.right.left.left=new Node(4);
        dup.right.right=new Node(4);
        HashMap<String, Integer> map=new HashMap<>();
        printAllDuplicates(map, dup);
        System.out.println(map);

        Node maxr=new Node(-10);
        maxr.left=new Node(9);
        maxr.right=new Node(20);
        maxr.right.left=new Node(15);
        maxr.right.right=new Node(7);

        maxSumPath(maxr);
        System.out.println(max);
    }
}
