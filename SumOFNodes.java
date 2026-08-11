public class SumOFNodes {

    public static  class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
            this.right = null;
            this.left = null;
        }

    }


    public static  class CreateBinary{
        static  int idx = -1;


        public static  Node buildBT(int arrNode[]){
            idx++;
            if(arrNode[idx] == -1){
                return null;
            }

            Node newNode = new Node(arrNode[idx]);
            newNode.left = buildBT(arrNode);
            newNode.right = buildBT(arrNode);

            return newNode;
        }



    }
    public static int TotalSumOfNode(Node root){
        if(root == null){
            return 0;
        }

        int lsum = TotalSumOfNode(root.left);
        int rsum = TotalSumOfNode(root.right);

        int tc = (lsum+rsum) + root.val; // jis bhi root pe hu uska sum

        return tc;
    }
    
    public static void main(String[] args) {
        CreateBinary bt = new CreateBinary();
        int arr[] =  {1 , 2, 4, -1 ,-1 ,5,-1,-1,3,-1,6,-1,-1};
        Node root = bt.buildBT(arr);
        System.out.println(TotalSumOfNode(root));


        
    }
}
