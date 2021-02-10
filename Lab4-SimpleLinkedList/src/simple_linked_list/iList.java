package simple_linked_list;

/**
 *
 * @author Polis
 */
public interface iList {
    
    public int size( ); //Returns the size of the Linked list
    
    public boolean isEmpty(); //Returns true if the list is empty
    
    public void insertFirst(Object data);
    
    public void insertLast(Object data);
    
    public Object removeFirst( ) throws ListEmptyException;
    
    public Object removeLast( ) throws ListEmptyException;
}
