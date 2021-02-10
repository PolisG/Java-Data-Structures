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
    
    public void insertElement(Object data) {
        if(isEmpty())
            root = new TreeNode(data);
        else
            insertNode(data,root);
    }

    private void insertNode(Object data, TreeNode node) {
        if(((Student)data).getAM() < ((Student)node.getNodeData()).getAM()) { //left
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
    
    private void inOrder(TreeNode node) { //left,root,right
        if(node == null)
            return;
        inOrder(node.getLeftNode());
        System.out.print(node.getNodeData()+" ");
        inOrder(node.getRightNode());
    }
    
    private void preOrder(TreeNode node) { //root,left,right
        if(node == null)
            return;
        System.out.print(node.getNodeData()+" ");
        preOrder(node.getLeftNode());
        preOrder(node.getRightNode());
    }
    
    private void postOrder(TreeNode node) { //left,right,root
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
    
    public Object[] inOrderSort(int size) {
        System.out.println("INORDER SORT");
        Object matrix[] = new Object[size];
        inOrderSorting(getRoot(), 0, matrix);
        return matrix;
    }
    
    private int inOrderSorting(TreeNode node, int i, Object matrix[]) {
        if (node == null)
            return i;
        
        i = inOrderSorting(node.getLeftNode(), i, matrix);
        matrix[i] = node.getNodeData();
        i++;
        i = inOrderSorting(node.getRightNode(), i, matrix);
        return i;
    }
    
    public int numberOfNodes() {
        return numberOfNodes(root);
    }
    
    private int numberOfNodes(TreeNode node) {
        if(node == null)
            return 0;
        else
            return numberOfNodes(node.getLeftNode())+numberOfNodes(node.getRightNode())+1;
    }
    
    public int treeHeight() {
        return treeHeight(root);
    }
    
    private int treeHeight(TreeNode node) {
        if(node == null)
            return 0;
        else
            return max(treeHeight(node.getLeftNode()),treeHeight(node.getRightNode()))+1;
    }
    
    private int max(int a, int b) {
        if(a > b)
            return a;
        else
            return b;
    }
    
    public boolean isExist(Object data) {
        return isExist(data,root);
    }
    
    private boolean isExist(Object data, TreeNode node) {
        if (node == null)
            return false;
        else if(((Student)node.getNodeData()) == data)
            return true;
        else
            return (isExist(data,node.getLeftNode()) || isExist(data,node.getRightNode()));
    }
    
    public int treeHeight(Object data) {
        return treeHeight(isSearch(data,root));
    }
    
    private TreeNode isSearch(Object data, TreeNode node) {
        if(((Student)node.getNodeData()) == data)
            return node;
        else {
            if(isExist(data,node.getLeftNode()))
                return isSearch(data,node.getLeftNode());
            else
                return isSearch(data,node.getRightNode());
        }
    }
}
