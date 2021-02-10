package array_stack;

/**
 *
 * @author Polis
 */
public interface iStack {
    
    public int size(); // Returns the size of the Stack
    
    public boolean isEmpty(); // Returns true if the Stack is empty
    
    public boolean isFull(); // Returns true if the Stack is full
    
    public Object top() throws StackEmptyExc; // Returns the top item of the Stack
    
    public void push(Object item) throws StackFullExc; //Adds a new item into the Stack
    
    public Object pop() throws StackEmptyExc; // Removes the top item of the Stack
}
