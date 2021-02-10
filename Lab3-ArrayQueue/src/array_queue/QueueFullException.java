package array_queue;

/**
 *
 * @author Polis
 */
public class QueueFullException extends RuntimeException {

    public QueueFullException(String error) {
        super(error);
    }
}
