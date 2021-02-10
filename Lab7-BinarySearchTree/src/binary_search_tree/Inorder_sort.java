package binary_search_tree;

/**
 *
 * @author Polis
 */
public class Inorder_sort extends BSTree {

    public Inorder_sort() {}
    
    public int[] inorderSort(int size) {
        System.out.println("INORDER SORT");
        int matrix[] = new int[size];
        int i = 0;
        inorderSorting(getRoot(), 0, matrix);
        return matrix;
    }
    
    private int inorderSorting(TreeNode node, int i, int matrix[]) {
        if (node == null)
            return i;
        
        i = inorderSorting(node.getLeftNode(), i, matrix);
        matrix[i] = node.getNodeData();
        i++;
        i = inorderSorting(node.getRightNode(), i, matrix);
        return i;
    }
}
