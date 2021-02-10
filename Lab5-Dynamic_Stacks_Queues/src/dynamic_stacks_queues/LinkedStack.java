package dynamic_stacks_queues;

/**
 *
 * @author Polis
 */
public class LinkedStack implements iStack {
    
    private SimpleLinkedList Stack;
    
    public LinkedStack() {
        Stack = new SimpleLinkedList();
    }
    
    @Override
    public int size() {
        return Stack.size();
    }

    @Override
    public boolean isEmpty() {
        return Stack.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Object top() throws StackEmptyException {
        if(Stack.isEmpty()) throw new StackEmptyException("Stack is empty!");
        
        Object temp;
        temp = Stack.removeFirst();
        Stack.insertFirst(temp);
        return temp;
    }

    @Override
    public void push(Object item) throws StackFullException {
        Stack.insertFirst(item);
    }

    @Override
    public Object pop() throws StackEmptyException {
        try {
            return Stack.removeFirst();
        }
        catch(ListEmptyException e) {
            throw new StackEmptyException("Stack is empty!");
        }
    } 
}
