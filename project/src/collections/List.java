package collections;

/**
 * List that has a generic array
 * @author tom.leonardsson
 *
 * @param <E>
 */
public class List<E> {
	private E[] elements;
	
	/**
	 * Create an empty list
	 */
	public List() {
		elements = (E[])new Object[0];
	}
	
	/**
	 * Add new element into the list and make it one element bigger
	 * @param e the element to put in
	 * @return the element that has been added
	 */
	public E add(E e) {
		E[] tmp = (E[])new Object[size()+1];
		
		for(int i = 0; i < size(); i++)
			tmp[i] = elements[i];
		tmp[size()] = e;
		elements = tmp;
		return e;
	}
	
	/**
	 * Remove an element from the list
	 * @param index the position of the element in the list
	 * @return the removed element
	 */
	public E remove(int index) {
		E[] tmp = (E[])new Object[size()-1];
		
		int offset = 0;
		
		for(int i = 0; i < size(); i++) {
			if(i != index) {
				tmp[i-offset] = elements[i];
			} else {
				offset += 1;
			}
		}
		
		E removed = elements[index];
		
		elements = tmp;
		
		return removed;
	}
	
	/**
	 * Get the index of the element and remove it based on it's index
	 * @param e the element to look for
	 * @return the removed element
	 */
	public E remove(E e) {
		return remove(getIndex(e));
	}
	
	/**
	 * Remove the first element in the list
	 * @return the removed element
	 */
	public E removeFirst() {
		return remove(0);
	}
	
	/**
	 * Remove everything by removing the first element until it's empty
	 */
	public void clear() {
		while(size() > 0)
			removeFirst();
	}
	
	/**
	 * Get the index of a specifc element
	 * @param e the element to look for
	 * @return the index of the element, -1 if not found
	 */
	public int getIndex(E e) {
		for(int i = 0; i < size(); i++)
			if(elements[i].equals(e)) return i;
		return -1;
	}
	
	/**
	 * Get the element at a specifc index
	 * @param index the index to get
	 * @return the element in the index
	 */
	public E get(int index) {
		return elements[index];
	}
	
	/**
	 * Get the size of the list
	 * @return the size of the list
	 */
	public int size() {
		return elements.length;
	}
	
	/**
	 * Create a structred string that shows the contents of the list
	 * @return the structured string
	 */
	public String toString() {
		String tmp = "{";
		for(int i = 0; i < size(); i++) {
			tmp += elements[i] + ((i < size()-1) ? ", " : "");
		}
		return tmp + "}";
	}
}
