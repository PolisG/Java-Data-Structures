package simple_linked_list;

/**
 *
 * @author Polis
 */
public class SimpleLinkedList implements iList {
    private SLListNode firstNode, lastNode;

    public SimpleLinkedList() {
        firstNode = null;
        lastNode = null;
    }

    public SLListNode getFirstNode() {
        return firstNode;
    }

    public SLListNode getLastNode() {
        return lastNode;
    }

    @Override
    public int size() {
        int size = 0;
        SLListNode position = firstNode; //Thelw na deixnei ston komvo ston opoio einai to firstNode
        
        //for(SLListNode position=firstNode; position!=null; position=position.getNextNode())
        while(position != null) {
            size++;
            position = position.getNextNode();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (firstNode == null);
    }

    @Override
    public void insertFirst(Object data) {
        if(isEmpty())
            firstNode = lastNode = new SLListNode(data,null);
        else
            firstNode = new SLListNode(data,firstNode);
            //SLListNode temp = new SLListNode(data,null); firstNode = temp;
    }

    @Override
    public void insertLast(Object data) {
        if(isEmpty())
            firstNode = lastNode = new SLListNode(data,null);
        else
            lastNode = lastNode.nextNode = new SLListNode(data,null);
            //SLListNode temp = new SLListNode(data,null); lastNode.setNextNode(temp); lastNode = temp;
    }

    @Override
    public Object removeFirst() throws ListEmptyException {
        if(isEmpty())
            throw new ListEmptyException("List is empty!");
        
        Object removeItem = firstNode.data;
        if(firstNode == lastNode) {
            firstNode = lastNode = null;
        }else {
            firstNode = firstNode.nextNode;
        }
        return removeItem;
    }

    @Override
    public Object removeLast() throws ListEmptyException {
        if(isEmpty())
            throw new ListEmptyException("List is empty!");
        
        Object removeItem = lastNode.data;
        if(firstNode == lastNode)
            firstNode = lastNode = null;
        else {
            SLListNode current = firstNode;
            while(current != lastNode) {
                current = current.nextNode;
            }
            lastNode = current;
            current.nextNode = null;
        }
        return removeItem;
    }
    
    public void printList() {
        if(isEmpty())
            System.out.println("List is empty!");
        else {
            SLListNode current = firstNode;
            while(current != null) {
                System.out.println(current.getNodeData().toString()+"");
                current = current.getNextNode();
            }
        }
    }
}
