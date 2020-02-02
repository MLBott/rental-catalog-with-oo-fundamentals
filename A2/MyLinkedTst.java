package hw2;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyLinkedTst extends MyLinked {
	@Test
    private static void testDelete () {
        MyLinked b = new MyLinked ();
        b.add (1);
        assertTrue(b.size() == 1);
        b.delete (0);
        assertTrue(b.isEmpty());
        for (double i = 1; i < 13; i++) {
            b.add (i);
        }
        assertTrue(b.size() == 12);
        b.delete (0);
        assertTrue(b.size() == 11);
        b.delete (10);
        assertTrue(b.size() == 10);
        b.delete (4);
        assertTrue(b.size() == 9);
    }
	
	@Test
    private static void testReverse () {
        MyLinked b = new MyLinked ();
        b.reverse ();
        assertTrue(b.isEmpty());
        b.add (1);
        assertTrue(b.size() == 1);
        b.reverse ();
        assertTrue(b.size() == 1);
        b.add (2);
        assertTrue(b.size() == 2);
        b.reverse ();
        assertTrue(b.size() == 2);
        b.reverse ();
        assertTrue(b.size() == 2);
        for (double i = 3; i < 7; i++) {
            b.add (i);
            b.add (i);
        }
        assert(b.size() == 10);
        b.reverse ();
        assert(b.size() == 10);
    }
	
	@Test
    private static void testRemove () {
        MyLinked b = new MyLinked ();
        b.remove (4);
        assertTrue(b.isEmpty());
        b.add (1);
        b.remove (4);
        assertTrue(b.size() == 1);
        b.remove (1);
        assertTrue(b.isEmpty());
        for (double i = 1; i < 5; i++) {
            b.add (i);
            b.add (i);
        }
        for (double i = 1; i < 5; i++) {
            b.add (i);
            b.add (i);
            b.add (i);
            b.add (i);
            b.add (i);
        }
        assertTrue(b.size() == 18);
        b.remove (9);
        assertTrue(b.size() == 18);
        b.remove (3);
        b.remove (1);
        b.remove (4);
        b.remove (2);
        assertTrue(b.isEmpty());
    }
	
}
