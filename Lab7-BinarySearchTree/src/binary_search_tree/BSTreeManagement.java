package binary_search_tree;

/**
 *
 * @author Polis
 */
public class BSTreeManagement {
    
    public static void main(String[] args) {
       int matrix[] = {40, 15, 25, 50, 20, 10, 70, 55, 45, 5};
       
       BSTree tree = new BSTree();
       
       for(int i=0; i<matrix.length; i++)
           tree.insertElement(matrix[i]);
       
       tree.inOrderTraversal();
       tree.preOrderTraversal();
       tree.postOrderTraversal();
       
       Inorder_sort tree2 = new Inorder_sort();
       
       for(int i=0; i<matrix.length; i++)
           tree2.insertElement(matrix[i]);
       
       matrix = tree2.inorderSort(matrix.length);
       for (int i=0; i<matrix.length; i++)
            System.out.print(matrix[i]+" ");
       System.out.println();
    }
}
