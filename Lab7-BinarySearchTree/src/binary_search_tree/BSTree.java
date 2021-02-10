package binary_search_tree;

/**
 *
 * @author Polis
 */
public class BSTree {
    private TreeNode root;

    public BSTree() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }
    
    public boolean isEmpty() {
        return (root == null);
    }
    
    public void insertElement(int data) {
        if(isEmpty())
            root = new TreeNode(data);
        else
            insertNode(data,root);
    }

    private void insertNode(int data, TreeNode node) {
        if(data == node.getNodeData())
            return;
        
        if(data < node.getNodeData()) { //left
            if(node.getLeftNode() == null) //exei xwro aristera?
                node.setLeftNode(new TreeNode(data));
            else
                insertNode(data,node.getLeftNode()); //alliws kalei ton eayto ths me data kai to aristero ypodentro
        }else { //right
            if(node.getRightNode() == null) //exei xwro deksia?
                node.setRightNode(new TreeNode(data));
            else
                insertNode(data,node.getRightNode()); //alliws kalei ton eayto ths me data kai to deksi ypodentro
        }
    }
    
    public void inOrder(TreeNode node) { //left,root,right
        if(node == null)
            return;
        inOrder(node.getLeftNode());
        System.out.print(node.getNodeData()+" ");
        inOrder(node.getRightNode());
    }
    
    public void preOrder(TreeNode node) { //root,left,right
        if(node == null)
            return;
        System.out.print(node.getNodeData()+" ");
        preOrder(node.getLeftNode());
        preOrder(node.getRightNode());
    }
    
    public void postOrder(TreeNode node) { //left,right,root
        if(node == null)
            return;
        postOrder(node.getLeftNode());
        postOrder(node.getRightNode());
        System.out.print(node.getNodeData()+" ");
    }
    
    public void inOrderTraversal() {
        System.out.println("INORDER TRAVERSAL");
        inOrder(root);
        System.out.println();
    }
    
    public void preOrderTraversal() {
        System.out.println("PREORDER TRAVERSAL");
        preOrder(root);
        System.out.println();
    }
    
    public void postOrderTraversal() {
        System.out.println("POSTORDER TRAVERSAL");
        postOrder(root);
        System.out.println();
    }
}
