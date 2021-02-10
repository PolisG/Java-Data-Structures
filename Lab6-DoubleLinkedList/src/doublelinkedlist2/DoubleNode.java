package doublelinkedlist2;

/**
 *
 * @author Polis
 */
public class DoubleNode extends SLListNode {
    private DoubleNode previous;

    public DoubleNode() {
        this(null,null,null);
    }

    public DoubleNode(DoubleNode previous, Object item, SLListNode next) {
        super(item,next);
        this.previous = previous;
    }

    public Object getItem() {
        return getNodeData();
    }

    public DoubleNode getNext() {
        return (DoubleNode)getNextNode();
    }

    public DoubleNode getPrevious() {
        return previous;
    }

    public void setItem(Object item) {
        setNodeData(item);
    }

    public void setNext(DoubleNode nextNode) {
        setNextNode(nextNode);
    }

    public void setPrevious(DoubleNode previous) {
        this.previous = previous;
    } 
}
