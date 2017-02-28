package collections;

public class List<E> {
	private E[] elements;
	
	public List() {
		elements = (E[])new Object[0];
	}
	
	public E add(E e) {
		E[] tmp = (E[])new Object[size()+1];
		
		for(int i = 0; i < size(); i++)
			tmp[i] = elements[i];
		tmp[size()] = e;
		elements = tmp;
		return e;
	}
	
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
	
	public E remove(E e) {
		return remove(getIndex(e));
	}
	
	public E removeFirst() {
		return remove(0);
	}
	
	public void clear() {
		while(size() > 0)
			removeFirst();
	}
	
	public int getIndex(E e) {
		for(int i = 0; i < size(); i++)
			if(elements[i].equals(e)) return i;
		return -1;
	}
	
	public E get(int index) {
		return elements[index];
	}
	
	public int size() {
		return elements.length;
	}
	
	public String toString() {
		String tmp = "{";
		for(int i = 0; i < size(); i++) {
			tmp += elements[i] + ((i < size()-1) ? ", " : "");
		}
		return tmp + "}";
	}
}
