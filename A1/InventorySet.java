package hw1;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

// TODO:  complete the methods
/**
 * An Inventory implemented using a <code>HashMap&lt;Video,Record&gt;</code>.
 * Keys are Videos; Values are Records.
 *
 * @objecttype Mutable Collection of Records
 * @objectinvariant
 *   Every key and value in the map is non-<code>null</code>.
 * @objectinvariant
 *   Each value <code>r</code> is stored under key <code>r.video</code>.
 */
final class InventorySet {
  /** @invariant <code>_data != null</code> */
  private final Map<VideoObj,Record> _data;

  InventorySet() {
    _data = new HashMap<VideoObj,Record>();
  }

  /**
   * Return the number of Records.
   */
  public int size() {
    // TODO  
    return _data.size();
  }

  /**
   * Return a copy of the record for a given Video.
   */
  public Record get(VideoObj v) {
    // TODO  
    Record details = _data.get(v);
    if(details != null) {
    	return details.copy();
    } else {
    	return null;
    }
  }

  /**
   * Return a copy of the records as a collection.
   * Neither the underlying collection, nor the actual records are returned.
   */
  public Collection toCollection() {
    // Recall that an ArrayList is a Collection.
    // TODO
	ArrayList<Record> myRecordsCopy = new ArrayList<Record> (_data.size());
	for (Record details : _data.values()) {
		myRecordsCopy.add(details.copy());
	}
	
	
	
    return myRecordsCopy;
  }

  /**
   * Add or remove copies of a video from the inventory.
   * If a video record is not already present (and change is
   * positive), a record is created. 
   * If a record is already present, <code>numOwned</code> is
   * modified using <code>change</code>.
   * If <code>change</code> brings the number of copies to be less
   * than one, the record is removed from the inventory.
   * @param video the video to be added.
   * @param change the number of copies to add (or remove if negative).
   * @throws IllegalArgumentException if video null or change is zero
   * @postcondition changes the record for the video
   */
  public void addNumOwned(VideoObj video, int change) {
    // TODO
	VideoObj v = video;
	Record details = _data.get(v);
	if((change == 0 || v == null)) {
		throw new IllegalArgumentException();
	} else {
		if(details == null && change < 1) {
			throw new IllegalArgumentException();
		} else if(details == null) {
			Record newDetails = new Record(v, change, 0, 0);
			_data.put(v, newDetails);
		} else if(details != null) {
			details.numOwned += change;
			if(details.numOut > details.numOwned + change) {
				throw new IllegalArgumentException();
			} else if(details.numOwned + change < 1) {
				_data.remove(v);
			} else {
				Record revised = new Record(v, details.numOwned + change, details.numOut, details.numRentals);
				_data.put(v,  revised);
			}
		}
	 }
  }  

  /**
   * Check out a video.
   * @param video the video to be checked out.
   * @throws IllegalArgumentException if video has no record or numOut
   * equals numOwned.
   * @postcondition changes the record for the video
   */
  public void checkOut(VideoObj video) {
    // TODO
	VideoObj v = video;
	Record details = _data.get(v);
	if((details.numOwned == details.numOut) || details == null) {
		throw new IllegalArgumentException();
	} else {
		details.numRentals += 1;
		details.numOut += 1;
		Record revised = new Record(v, details.numOwned, details.numOut, details.numRentals);
		_data.put(v,  revised);
	}
  }
  
  /**
   * Check in a video.
   * @param video the video to be checked in.
   * @throws IllegalArgumentException if video has no record or numOut
   * non-positive.
   * @postcondition changes the record for the video
   */
  public void checkIn(VideoObj video) {
    // TODO
	VideoObj v = video;
	Record details = _data.get(v);
	if(details.numOut == 0 || details == null) {
		throw new IllegalArgumentException();
	} else {
		details.numOut -= 1;
		Record revised = new Record(v, details.numOwned, details.numOut, details.numRentals);
		_data.put(v, revised);
	}
  }
  
  /**
   * Remove all records from the inventory.
   * @postcondition <code>size() == 0</code>
   */
  public void clear() {
    // TODO
	_data.clear();
  }

  /**
   * Return the contents of the inventory as a string.
   */
  public String toString() {
    StringBuffer buffer = new StringBuffer();
    buffer.append("Database:\n");
    for (Record r : _data.values()) {
      buffer.append("  ");
      buffer.append(r);
      buffer.append("\n");
    }
    return buffer.toString();
  }
}
