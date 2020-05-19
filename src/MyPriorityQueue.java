/*
 * Name: THANH NGUYEN
 * PID:  A15692943
 */

/**
 *
 * @param <T> Generic type
 */
public class MyPriorityQueue<T extends Comparable<? super T>> {

    private dHeap<T> pQueue;

    /**
     * Constructor that creates a new priority queue
     * 
     * @param initialSize the given size
     */
    public MyPriorityQueue(int initialSize) {
        /* TODO */
        pQueue = new dHeap<>(5, initialSize, true);
    }

    /**
     * Inserts an element into the Priority Queue. The element received cannot be
     * null.
     *
     * @param element Element to be inserted.
     * @throws NullPointerException if the element received is null.
     * @return returns true
     */
    public boolean offer(T element) throws NullPointerException {
        /* TODO */
        if (element==null){
            throw new NullPointerException();
        } else {
            pQueue.add(element);
        }
        return true;
    }

    /**
     * Retrieves the head of this Priority Queue (largest element), or null if the
     * queue is empty.
     *
     * @return The head of the queue (largest element), or null if queue is empty.
     */
    public T poll() {
        /* TODO */
        if (pQueue.size()==0) {
            return null;
        } else {
            return pQueue.remove();
        }
    }

    /**
     * Clears the contents of the queue
     */
    public void clear() {
        /* TODO */
        pQueue.clear();
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if
     * this queue is empty.
     * 
     * @return the next item to be removed, null if the queue is empty
     */
    public T peek() {
        /* TODO */
        if (pQueue.size()==0) {
            return null;
        } else {
            return pQueue.element();
        }
    }

    /**
     * Return true is the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        /* TODO */
        return (pQueue.size()==0);
    }

}
