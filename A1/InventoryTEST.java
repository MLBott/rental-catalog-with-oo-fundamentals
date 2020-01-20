package hw1;

//import junit.framework.Assert;
import junit.framework.TestCase;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.HashSet;

// TODO:  complete the tests
public class InventoryTEST extends TestCase {
	public InventoryTEST(String name) {
		super(name);
		

  }
	
  // TODO
  InventorySet testInv = new InventorySet();
  final VideoObj testVid1 = new VideoObj("XY", 1999, "ZZ");
  final VideoObj testVid2 = new VideoObj("AB", 2020, "CC");
	
  @Test
  public void testSize() {
    // TODO
	//assert(_testData.size() >= 0);
	//testInv.addNumOwned(testVid1, 1); 
	assertEquals(testInv.size(), 0);
  }
  @Test
  public void testAddNumOwned() {
    // TODO
  }
  @Test
  public void testCheckOutCheckIn() {
    // TODO
  }
  @Test
  public void testClear() {
    // TODO
	testInv.clear();
	assertTrue(testInv.size() == 0);
  }
  @Test
  public void testGet() {
    // TODO
	//Record newRecord = testInv.get(testVid2);
	assertEquals(0, 0);
  }
  @Test
  public void testToCollection() {
    // Be sure to test that changing records in the returned
    // collection does not change the original records in the
    // inventory.  ToCollection should return a COPY of the records,
    // not the records themselves.
    // TODO 
  }
}
