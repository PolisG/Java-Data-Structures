package doublelinkedlist;

/**
 *
 * @author Polis
 */
public class DoubleNode {
    private Object item;
    private DoubleNode next, previous;

    public DoubleNode() {
        this(null,null,null);
    }

    public DoubleNode(DoubleNode previous, Object item, DoubleNode next) {
        this.previous = previous;
        this.item = item;
        this.next = next;
    }

    public Object getItem() {
        return item;
    }

    public DoubleNode getNext() {
        return next;
    }

    public DoubleNode getPrevious() {
        return previous;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public void setPrevious(DoubleNode previous) {
        this.previous = previous;
    } 
}
