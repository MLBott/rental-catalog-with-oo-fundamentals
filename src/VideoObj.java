package hw1;

// TODO:  complete the methods
/**
 * Immutable Data Class for video objects.
 * Comprises a triple: title, year, director.
 *
 * @objecttype Immutable Data Class
 * @objectinvariant
 *   Title is non-null, no leading or final spaces, not empty string.
 * @objectinvariant
 *   Year is greater than 1800, less than 5000.
 * @objectinvariant
 *   Director is non-null, no leading or final spaces, not empty string.
 */
final class VideoObj implements Comparable {
  /** @invariant non-null, no leading or final spaces, not empty string */
  private final String _title;
  /** @invariant greater than 1800, less than 5000 */
  private final int    _year;
  /** @invariant non-null, no leading or final spaces, not empty string */
  private final String _director;
  private volatile int hashCode = 0;
  /**
   * Initialize all object attributes.
   * Title and director are "trimmed" to remove leading and final space.
   * @throws IllegalArgumentException if any object invariant is violated.
   */
  VideoObj(String title, int year, String director) {
    // TODO
	if((year <= 1800 || year >= 5000) || (director == null) || (title == null)
			|| (director.equals("")) || title.equals("") || title.equals(" ")) {
		throw new IllegalArgumentException();
	}
	this._year = year;  
    this._title = title.trim();
    this._director = director.trim();
     
  }

  /**
   * Return the value of the attribute.
   */
  public String director() {
    // TODO  
    return this._director;
  }

  /**
   * Return the value of the attribute.
   */
  public String title() {
    // TODO  
    return this._title;
  }

  /**
   * Return the value of the attribute.
   */
  public int year() {
    // TODO  
    return this._year;
  }

  /**
   * Compare the attributes of this object with those of thatObject.
   * @param thatObject the Object to be compared.
   * @return deep equality test between this and thatObject.
   */
  public boolean equals(Object thatObject) {
    // TODO  
    if(thatObject == null) { return false; }
    if(thatObject == this) {return true; }
    if (!(this.getClass().equals(thatObject.getClass()))) {return false; }
    
    VideoObj thatObj = (VideoObj) thatObject;
    return _title.contentEquals(thatObj._title) && _director.equals(thatObj._director) && _year == thatObj._year;
    
  }

  /**
   * Return a hash code value for this object using the algorithm from Bloch:
   * fields are added in the following order: title, year, director.
   */
  public int hashCode() {
    // TODO  
    if (hashCode == 0) {
    	int result = 17;
    	result = 37 * result + _title.hashCode();
    	result = 37 * result + _year;
    	result = 37 * result + _director.hashCode();
    	hashCode = result;
    }
    return hashCode;
  }

  /**
   * Compares the attributes of this object with those of thatObject, in
   * the following order: title, year, director.
   * @param thatObject the Object to be compared.
   * @return a negative integer, zero, or a positive integer as this
   *  object is less than, equal to, or greater thatObject.
   * @throws ClassCastException if thatObject has an incompatible type.
   */
  public int compareTo(Object thatObject) {
    // TODO
	VideoObj thatObj = (VideoObj) thatObject;
    int compTitle = _title.compareTo(thatObj._title);
    if (compTitle != 0) { 
    	return compTitle;
    } else if(thatObj._year != _year) {
    	return _year - thatObj._year;
    }
    return _director.compareTo(thatObj._director);
    
  }
  /**
   * Return a string representation of the object in the following format:
   * <code>"title (year) : director"</code>.
   */
  public String toString() {
    // TODO  
    return (_title + " (" + _year + ") : " + _director);
  }
}
