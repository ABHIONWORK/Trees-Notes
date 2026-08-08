

public class PostOrderTransver {
    public static class Node{
        int value;
        Node left;
        Node right;

        public  Node(int value){
            this.value= value;
            this.left = null;
            this.right = null;

        }
    }

    public static  class BinaryTree{

        public static int idx = -1;
        public  Node  buildTree(int [] nodearr){
                    idx++;
        
                    if(nodearr[idx] == -1){
                        return null;
                    }
        
                    Node newNode = new Node(nodearr[idx]);
                    newNode.left = buildTree(nodearr);
                    newNode.right = buildTree(nodearr);
        
                    return newNode;
        
                }
            }
        
        
            public static void PrintPostOrder(Node root){
                if(root == null) return;
                PrintPostOrder(root.left);
        
                PrintPostOrder(root.right);
        
                System.out.print(root.value + " ");
            }
        
        
          
            public static void main(String[] args) {
                int nodearr [] = {1 , 2,   4, -1 , -1 ,5, -1 , -1 ,3,-1 ,6 ,-1 , -1};
        
                BinaryTree bt = new BinaryTree();
            
               Node root =  bt.buildTree(nodearr);
        PrintPostOrder(root);

        
    }
}
