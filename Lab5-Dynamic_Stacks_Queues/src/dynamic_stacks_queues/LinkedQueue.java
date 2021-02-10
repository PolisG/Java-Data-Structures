package dynamic_stacks_queues;

/**
 *
 * @author Polis
 */
public class LinkedQueue implements iQueue {
    
    private SimpleLinkedList Queue;

    public LinkedQueue() {
        Queue = new SimpleLinkedList();
    }
    
    @Override
    public int size() {
        return Queue.size();
    }

    @Override
    public boolean isEmpty() {
        return Queue.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Object front() throws QueueEmptyException {
        if(Queue.isEmpty()) throw new QueueEmptyException("Queue is empty!");
        
        Object temp;
        temp = Queue.removeFirst();
        Queue.insertFirst(temp);
        return temp;
    }

    @Override
    public void add(Object item) throws QueueFullException {
        Queue.insertLast(item);
    }

    @Override
    public Object remove() throws QueueEmptyException {
        try {
            return Queue.removeFirst();
        }
        catch(ListEmptyException e) {
            throw new StackEmptyException("Stack is empty!");
        }
    }
}
