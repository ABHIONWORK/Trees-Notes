public class CountOfNode {

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
    public static int TotalNode(Node root){
        if(root == null){
            return 0;
        }

        int lcnt = TotalNode(root.left);
        int rcnt = TotalNode(root.right);

        int tc = (lcnt+rcnt) + 1;

        return tc;
    }
    
    public static void main(String[] args) {
        CreateBinary bt = new CreateBinary();
        int arr[] =  {1 , 2, 4, -1 ,-1 ,5,-1,-1,3,-1,6,-1,-1};
        Node root = bt.buildBT(arr);
        System.out.println(TotalNode(root));


        
    }
}
