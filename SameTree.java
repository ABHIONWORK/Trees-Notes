//8 AUGUST 
public class SameTree {
    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree{

        public int idx = -1; // Changed from static to instance variable
        
        public Node buildTree(int [] nodearr){
            idx++;
            
            if(idx >= nodearr.length || nodearr[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodearr[idx]);
            newNode.left = buildTree(nodearr);
            newNode.right = buildTree(nodearr);

            return newNode;
        }
    }

    public static boolean same(Node main , Node dup){
        if(main == null && dup == null){
            return true;
        }

        if(main != null && dup != null && main.value == dup.value){
            return same(main.left , dup.left) && same(main.right, dup.right);
        }

        else{
            return false;
        }
    }

    public static void main(String[] args) {
        int nodearr[] = {1 , 2, 4 , -1 , -1 , 3 ,-1 ,-1,  5 ,-1 , -1};
        BinaryTree BT = new BinaryTree();
        Node main = BT.buildTree(nodearr);

        int nodearr2[] = {1 , 2, 4 , -1 , -1 , 3 ,-1 ,-1,  4 ,-1 , -1};
        BinaryTree bt2 = new BinaryTree();
        Node dup = bt2.buildTree(nodearr2);

        System.out.println(same(main, dup));
    }
}