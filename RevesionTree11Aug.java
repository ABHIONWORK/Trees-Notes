
import java.util.LinkedList;
import java.util.Queue;

public class RevesionTree11Aug {

    public static  class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;


        }

    }


     public static class Binaryyyy{
            static int idx = -1;

            public static Node buildTree(int arr[]){
                idx++;

                if(arr[idx] == -1){
                    return null;
                }

                Node currNode  = new Node(arr[idx]);

                currNode.left = buildTree(arr);
                currNode.right = buildTree(arr);

                return currNode;

            }
        }

        public static void PrintPreorder(Node root){
            if(root == null) return;
            System.out.println(root.val);
            PrintPreorder(root.left);
            PrintPreorder(root.right);

        }

        public static int CountNode(Node root){
            if(root == null){
                return 0;

            }


            int lc = CountNode(root.left);
            int rc = CountNode(root.right);

            int tc = (lc + rc) + 1;
            return tc;

        }


        public static int MaxLevelSum (Node root){
            int level = 1;
            int maxsum = 0;
            Queue<Node> q = new LinkedList<>();


            q.offer(root);
            int currlevel = 0;
            while(!q.isEmpty()){
                int currSum = 0;
                int sz = q.size();
                //  currSum += q.remove().val ; 
                
                for(int i = 0; i<sz; i++){
                    Node curr = q.remove();
                    currSum+=curr.val;
                    if(curr.left!=null ){
                        q.add(curr.left);
                    }
    
                    if(curr.right!=null){
                        q.add(curr.right);
                    }
                }

                if(currSum > maxsum){
                    maxsum = currSum;
                    currlevel = level;
                }

                level++;
            }



            return  currlevel;




        }


        //Deriving height of the tree function for diameter finding

        // public static int height(Node root){
        //     if(root == null){
        //         return 0;
        //     }


        //     int lh = height(root.left);
        //     int rh = height(root.right);

        //     int th = Math.max(lh, rh) + 1; 

        //     return th;

        // }


        public static  class Info {
            int diameter;
            int height;

        public Info(int diameter , int height) {
            this.diameter  = diameter;
            this.height = height;
        }

            
        }



        public static Info Diameter(Node root){

            if(root == null){
                return new Info(0, 0);
            }

            Info lft = Diameter(root.left);

            Info rht = Diameter(root.right);

            int diam  = Math.max(Math.max(lft.diameter, rht.diameter) , lft.height + rht.height + 1);

            int maxHeight = Math.max(lft.height, rht.height) + 1;


            return new Info(diam, maxHeight);

            







            // int ld = Diameter(root.left);
            // int rd = Diameter(root.right);

            // int lh = height(root.left);
            // int rh = height(root.right);

            // int self = (lh  + rh ) + 1;

            // int maxD = Math.max(Math.max(ld , rd  ) , self);

            // return maxD;

        }


        public static int SumofNode(Node root){
            
            if(root == null){
                return 0;
            }


            int ls = SumofNode(root.left);
            int rs = SumofNode(root.right);
            int sum = ls+rs + root.val;
            
            return sum;


        }


        
  
    public static void main(String[] args) {
            Binaryyyy bt = new Binaryyyy();
            int nodearr2[] = {1 , 2, 4 , -1 , -1 , 3 ,-1 ,-1,  4 ,-1 , -1};
            Node root = bt.buildTree(nodearr2);

            PrintPreorder(root);

            System.out.println(CountNode(root));

            System.out.println(SumofNode(root));

            System.out.println(MaxLevelSum(root));

            // int D = Diameter(root);
            // System.out.println(D);

            


        
    }
}
