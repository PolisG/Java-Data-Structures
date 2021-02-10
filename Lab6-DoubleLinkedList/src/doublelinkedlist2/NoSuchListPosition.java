package doublelinkedlist2;

/**
 *
 * @author Polis
 */
class NoSuchListPosition extends RuntimeException {
    
    public NoSuchListPosition(String error) {
        super(error);
    }
}
