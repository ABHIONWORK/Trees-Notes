/**
 * PreOrderTree
 */
public class InorderTree {

    static  class Node{
        int data;
        Node left ;
        Node right;

        public Node(int data ){
            this.data = data;
            this.left = null;
            this.right = null;
         
        }

    }

     static  class  BinaryTree{
        static int idx = -1;


        public static Node buildTree(int arrnodes[]){
            idx++;

            if(arrnodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(arrnodes[idx]);
            newNode.left = buildTree(arrnodes);
            newNode.right = buildTree(arrnodes);

            return newNode;

        }

        //fn to print the tree in preorder way ;

        // public static void preorder(Node root){
        //     if(root == null) return; // O(N) ---> tc


        //     System.out.print(root.data + " ");

        //     preorder(root.left);
        //     preorder(root.right);
        // }


        public static void inorder( Node root){
            if(root == null) return;
            inorder(root.left);
            System.out.println(root.data + " ");
            inorder(root.right);

        }
    }

    public static void main(String[] args) {
        int arrnodes[] = {1 , 2, 4, -1 , -1 , 5, -1 , -1, 3, -1 ,6, -1, -1};
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(arrnodes);

        // bt.preorder(root);
        bt.inorder(root);


        // System.out.println(root.data);


    }
}

// public class InorderTree {

//     static class Node{
//         int data;
//         Node left;
//         Node right;

//         Node(int data){
//             this.data = data;
//             this.left = null;
//             this.right = null;
//         }
//     }


//     static  class BinaryTree{
//         static int idx = -1;

//         // public static Node buildTree(int nodearr[]){
//         //     idx++;

//         //     Node newNode = new Node(nodearr[idx]);
//         //     newNode.left = buildTree(nodearr);


//         // }


//     }
//     public static void main(String[] args) {
//         int nodearr[] = {1 , 2 ,4 ,-1 ,-1 , 5,-1 ,-1,3,-1 ,6, -1 ,-1};
//         BinaryTree tree = new BinaryTree();
//         tree.buildTree(nodearr);

//     }
// }
