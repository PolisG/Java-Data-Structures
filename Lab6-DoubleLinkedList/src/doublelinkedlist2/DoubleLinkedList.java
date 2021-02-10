package doublelinkedlist2;

/**
 *
 * @author Polis
 */
public class DoubleLinkedList implements iList,Comparable {
    private DoubleNode firstNode, lastNode;
    private int size;

    public DoubleLinkedList() {
        firstNode = lastNode = null;
        size = 0;
    }

    public DoubleNode getFirstNode() {
        return firstNode;
    }

    public DoubleNode getLastNode() {
        return lastNode;
    }

    @Override
    public boolean isEmpty() {
        return (firstNode == null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insertFirst(Object data) {
        if(isEmpty())
            firstNode = lastNode = new DoubleNode(null,data,null); //(prev,data,next)
        else {
            DoubleNode db = new DoubleNode(firstNode,data,null); //(prev,data,next)
            firstNode.setPrevious(db);
            firstNode = db;
        }
        size++;
    }

    @Override
    public void insertLast(Object data) {
        if(isEmpty())
            firstNode = lastNode = new DoubleNode(null,data,null);
        else {
            DoubleNode db = new DoubleNode(lastNode,data,null); //(prev,data,next)
            lastNode.setNext(db);
            lastNode = db;
        }
        size++;
    }

    @Override
    public void insert(int position, Object data) throws NoSuchListPosition {
        if((position > size()) || (position < 0))
            throw new NoSuchListPosition("No such position!");
        
        if(position == 0)
            insertFirst(data);
        else if(position == size())
            insertLast(data);
        else {
            DoubleNode pr = firstNode;
            for(int i=1; i<position; i++) {
                pr = pr.getNext();
            }
            DoubleNode ep = pr.getNext();
            DoubleNode newNode = new DoubleNode(pr,data,ep); //(prev,data,next)
            pr.setNext(newNode);
            ep.setPrevious(newNode);
        }
    }

    @Override
    public Object removeFirst() throws ListEmptyException {
        Object removeItem;
        if(isEmpty())
            throw new ListEmptyException("List is empty!");
        
        removeItem = firstNode.getItem();
        if(firstNode == lastNode)
            firstNode = lastNode = null;
        else {
            DoubleNode db = firstNode.getNext();
            //firstNode.setNext(null);
            db.setPrevious(null);
            firstNode = db;
        }
        size--;
        return removeItem;
    }

    @Override
    public Object removeLast() throws ListEmptyException {
        Object removeItem;
        if(isEmpty())
            throw new ListEmptyException("List is empty!");
        
        removeItem = lastNode.getItem();
        if(firstNode == lastNode)
            firstNode = lastNode = null;
        else {
            DoubleNode db = lastNode.getPrevious();
            //lastNode.setPrevious(null);
            db.setNext(null);
            lastNode = db;
        }
        size--;
        return removeItem;
    }

    @Override
    public Object remove(int position) throws ListEmptyException, NoSuchListPosition {
        if(isEmpty())
            throw new ListEmptyException("List is empty!");
        if((position >= size()) || (position < 0))
            throw new NoSuchListPosition("No such position!");
        if(position == 0)
            return removeFirst();
        if(position == size()-1)
            return removeLast();
        
        DoubleNode delNode = firstNode;
        for(int i=0; i<position; i++) {
            delNode = delNode.getNext();
        }
        
        Object returnData = delNode.getItem();
        
        delNode.getPrevious().setNext(delNode.getNext());
        delNode.getNext().setPrevious(delNode.getPrevious());
        /* DoubleNode pr = delNode.getPrevious();
         * DoubleNode ep = delNode.getNext();
         * pr.setNext(ep);
         * ep.setPrevious(pr);
         */
        return returnData;
    }
    
    public void printList() {
        if(isEmpty())
            System.out.println("List is empty!");
        else {
            DoubleNode current = firstNode;
            while(current != null) {
                System.out.println(current.getItem().toString()+"");
                current = current.getNext();
            }
        }
    }
    
    @Override
    public int compareTo(Object obj) {
        DoubleNode obj0 = (DoubleNode)obj;
        Comparable obj1 = (Comparable)obj0;
        Comparable obj2 = (Comparable)obj0.getNext();
        int value = obj1.compareTo(obj2);
        return value;
        /*RETURNS(compareTo)
         *a negative integer, zero, 
         *or a positive integer as this object is less than, equal to, 
         *or greater than the specified object.
         */
    }
    
    public void Sort() {
        DoubleNode dn = firstNode; 
        while(dn!=null) {
            DoubleNode current = dn;
            DoubleNode min = dn;
            while(current!=null) {
                int comp = compareTo(current);
                if(comp < 0) { //to current.getNext einai mikrotero
                    min=current;
                    /*An einai comp>0 tote symainei oti current.getNext().getItem() einai megalytero apo current.getItem()
                    *ara einai idi sti swsti thesi
                    *An einai com==0 tote einai isa kai den allazw kati
                    */
                }
                current=current.getNext();
            }
            Object temp = dn.getItem();
            dn.setItem(min.getItem());
            min.setItem(temp);
            dn = dn.getNext();
        }
    }
    
    public boolean isSorted() {
        boolean b = true;
        if(isEmpty())
            throw new ListEmptyException("List is empty!");
        if(firstNode == lastNode)
            b = true;
        else {
            DoubleNode current = firstNode;
            while(current.getNext()!=null) {
                int point = compareTo(current);
                if(point < 0) {
                    b = false;
                    break;
                }
                else
                    b = true;
                current = current.getNext();
            }
        }
        return b;
    }
    
    public void insert(Object data) {
        DoubleNode newDN = new DoubleNode(null,data,null); //(prev,data,next)
        if(firstNode == lastNode)
            firstNode = lastNode = new DoubleNode(null,data,null); //(prev,data,next)
        
        if(size() > 1) {
            DoubleNode current = firstNode;
            while(current!=lastNode.getNext()) {
                Integer object = (Integer)current.getItem();
                Integer objcetNext = (Integer)current.getNext().getItem();
                Integer objectnew = (Integer)newDN.getItem();
                if(object.intValue()<objectnew.intValue() && objcetNext.intValue()>objectnew.intValue()) {
                    newDN.setNext(current.getNext());
                    newDN.setPrevious(current.getPrevious());
                    current.setNext(newDN);
                    current.getNext().setPrevious(newDN);
                }
            }
        } else {
        }
        size++;
    }
}
