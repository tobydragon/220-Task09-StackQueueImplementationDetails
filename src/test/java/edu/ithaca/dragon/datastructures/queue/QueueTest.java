package edu.ithaca.dragon.datastructures.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    public void testQueues(){
        int queueSize=5;
        Queue queueToTest = null; //new ArrayQueue();
        testDequeueOnEmpty(queueToTest);
        enqueueDequeueTest(queueToTest, queueSize);
        testMakeEmpty(queueToTest, queueSize);
    }

    public void testDequeueOnEmpty(Queue emptyQueue){
        assertTrue(emptyQueue.isEmpty());
        assertThrows(EmptyQueueException.class, () -> {
            emptyQueue.dequeue();
        });
    }

    public void enqueueDequeueTest(Queue myQueue, int queueSize){
        assertTrue(myQueue.isEmpty());
        for (int i=0; i<queueSize; i++){
            myQueue.enqueue(Integer.toString(i));
            assertFalse(myQueue.isEmpty());
        }
        for (int i=0; i<queueSize; i++){
            assertFalse(myQueue.isEmpty());
            assertEquals(Integer.toString(i), myQueue.dequeue());
        }
        assertTrue(myQueue.isEmpty());

        myQueue.enqueue("a");
        myQueue.enqueue("b");
        myQueue.enqueue("c");
        assertEquals("a", myQueue.dequeue());
        assertEquals("b", myQueue.dequeue());
        myQueue.enqueue("x");
        myQueue.enqueue("y");
        assertEquals("c", myQueue.dequeue());
        assertEquals("x", myQueue.dequeue());
        assertEquals("y", myQueue.dequeue());
    }

    public void testMakeEmpty(Queue myQueue, int queueSize){
        assertTrue(myQueue.isEmpty());
        for (int i=0; i<queueSize; i++){
            myQueue.enqueue(Integer.toString(i));
            assertFalse(myQueue.isEmpty());
        }
        myQueue.makeEmpty();
        testDequeueOnEmpty(myQueue);
        enqueueDequeueTest(myQueue, queueSize);
    }
}