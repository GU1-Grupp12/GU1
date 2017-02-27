package collections;

import java.util.Iterator;
import java.util.Stack;

public class ArrayStack<E> {
	private int size;
	
	private E[] elements;
	
	public ArrayStack() {
		this(8);
	}
	
	public ArrayStack(int capacity) {
		elements = (E[])new Object[capacity];
	}
	
	public void grow() {
		E[] tmp = (E[])new Object[size + size/2];
		for(int i = 0; i < elements.length; i++)
			tmp[i] = elements[i];
		elements = tmp;
	}
	
	public E push(E e) {
		if(size >= elements.length) grow();
		elements[size] = e;
		size += 1;
		return e;
	}
	
	public E pop() {
		if(size == 0) throw new IndexOutOfBoundsException();
		E tmp = elements[size-1];
		elements[size-1] = null;
		size -= 1;
		return tmp;
	}
	
	public E peek() {
		if(size == 0) throw new IndexOutOfBoundsException();
		return elements[size-1];
	}
	
	public int getSize() {
		return size;
	}
	
	public String toString() {
		String tmp = "{";
		for(int i = 0; i < size; i++) {
			tmp += elements[i] + ((i < size-1) ? ", " : "");
		}
		return tmp + "}";
	}
	
	public Iterator<E> iterator() {
		return new Iter();
	}    
	
	private class Iter implements Iterator<E> {
		public boolean hasNext() {
			return size > 0;
		}

		public E next() {
			return pop();
		}
	}
}
