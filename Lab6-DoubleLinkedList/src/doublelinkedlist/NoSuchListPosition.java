package doublelinkedlist;

/**
 *
 * @author Polis
 */
class NoSuchListPosition extends RuntimeException {
    
    public NoSuchListPosition(String error) {
        super(error);
    }
}
