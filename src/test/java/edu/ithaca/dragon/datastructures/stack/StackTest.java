package edu.ithaca.dragon.datastructures.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

public class StackTest {
    
    @Test
    public void testStacks(){
        int stackSize = 5;
        Stack stackToTest = null; //new ArrayStack();
        testPopOnEmpty(stackToTest);
        pushPopTest(stackToTest, stackSize);
        testMakeEmpty(stackToTest,stackSize);
    }

    public void testPopOnEmpty(Stack emptyStack){
        assertTrue(emptyStack.isEmpty());
        assertThrows(EmptyStackException.class, () -> {
            emptyStack.pop();
        });
    }

    public void pushPopTest(Stack myStack, int stackSize){
        assertTrue(myStack.isEmpty());
        
        for (int i=0; i<stackSize; i++){
            myStack.push(Integer.toString(i));
            assertFalse(myStack.isEmpty());
        }
        for (int i=stackSize-1; i>=0; i--){
            assertFalse(myStack.isEmpty());
            assertEquals(Integer.toString(i), myStack.pop());
        }
        assertTrue(myStack.isEmpty());

        myStack.push("a");
        myStack.push("b");
        myStack.push("c");
        assertFalse(myStack.isEmpty());
        assertEquals("c", myStack.pop());
        assertEquals("b", myStack.pop());
        assertFalse(myStack.isEmpty());
        myStack.push("x");
        myStack.push("y");
        assertFalse(myStack.isEmpty());
        assertEquals("y", myStack.pop());
        assertEquals("x", myStack.pop());
        assertEquals("a", myStack.pop());
        assertTrue(myStack.isEmpty());
    }

    public void testMakeEmpty(Stack myStack, int stackSize){
        assertTrue(myStack.isEmpty());
        for (int i=0; i<stackSize; i++){
            myStack.push(Integer.toString(i));
            assertFalse(myStack.isEmpty());
        }
        myStack.makeEmpty();
        testPopOnEmpty(myStack);
        pushPopTest(myStack, stackSize);
    }

}
