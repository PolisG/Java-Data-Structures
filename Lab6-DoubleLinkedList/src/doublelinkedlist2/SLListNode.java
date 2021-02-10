package doublelinkedlist2;

/**
 *
 * @author Polis
 */
public class SLListNode {
    Object data;
    SLListNode nextNode;

    public SLListNode() {
        data = null;
        nextNode = null;
    }

    public SLListNode(Object data, SLListNode nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public Object getNodeData() {
        return data;
    }

    public void setNodeData(Object data) {
        this.data = data;
    }

    public SLListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(SLListNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        String str =""+data ;
        return str;
    }
}
