public class Diameter2 {

    public static  class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val= val;
            this.left = null;
            this.right = null;

        }
    }

    public static class BinaryTree{
        static int idx = -1;

        public static Node buildTree(int arr[]){
            idx++;
            if(arr[idx] == -1){
                return  null;
            }
            Node newNode = new Node(arr[idx]);
            newNode.left = buildTree(arr);
            newNode.right = buildTree(arr);

            return newNode;
        }
    }


    // public static int heightOfTree(Node root){
    //     if(root == null){
    //         return 0;
    //     }

    //     int lh = heightOfTree(root.left);
    //     int rh  = heightOfTree(root.right);
    //     int th = Math.max(lh  , rh ) + 1;

    //     return th;


    // }


    public static int MaxDiameter(Node root){
        if(root == null){
            return 0;
        }

        int lD = MaxDiameter(root.left);
        int rD = MaxDiameter(root.right);
        // int lH = heightOfTree(root.left);
        // int rH = heightOfTree(root.right);

        int selfD = (lH + rH) + 1;

        int MaxD = Math.max(lD ,rD);
        MaxD = Math.max(MaxD , selfD);

        return MaxD;
    }


    public static void main(String[] args) {
        int arr[] = {1 , 2, 4, -1 ,-1 ,5 ,-1 ,-1, 3 ,-1, 6 ,-1 ,-1};
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(arr);
        int D = MaxDiameter(root);
        System.out.println(D);
        
    }
}
