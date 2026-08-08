
//8 AUGUST 
public class HeightOfTree {
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
    
    public static int FindHeight(Node node){


        if(node == null){
            return 0;

        }

        int leftheight = FindHeight(node.left);
        int rightheight = FindHeight(node.right);
        int height = Math.max(leftheight , rightheight) + 1;

        return height;
        
    }
    public static void main(String[] args) {
        int nodearr[] = {1 , 2, 4, -1 ,-1 ,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree BT = new BinaryTree();
        Node root = BT.buildTree(nodearr);
        System.out.println(FindHeight(root));
        
    }
}
