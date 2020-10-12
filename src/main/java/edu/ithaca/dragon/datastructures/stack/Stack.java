package edu.ithaca.dragon.datastructures.stack;

public interface Stack {

    /**
     * puts an item onto the "top" of the stack
     */
    void push(String item);

    /**
     * removes an item from the "top" of the stack
     * @return the item removed
     * @throws EmptyStackException if the stack is empty
     */
    String pop();

    /**
     * @return true if the stack has no items, false otherwise
     */
    boolean isEmpty();

    /**
     * all items are removed, after calling this Stack is empty
     */
    void makeEmpty();

}
