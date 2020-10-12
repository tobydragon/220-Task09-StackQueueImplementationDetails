package edu.ithaca.dragon.datastructures.queue;

public interface Queue {
    
    /**
     * puts an item onto the "end" of the queue
     */
    void enqueue(String item);

    /**
     * removes an item from the "front" of the queue
     * @return the item removed
     * @throws EmptyQueueException if the queue is empty 
     */
    String dequeue();

    /**
     * @return true if the queue has no items, false otherwise
     */
    boolean isEmpty();

    /**
     * all items are removed, after calling this Queue is empty
     */
    void makeEmpty();

    
}
