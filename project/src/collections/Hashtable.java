package collections;

import java.util.ArrayList;
import java.util.Iterator;

import collections.Bucket.State;

/**
 * Table of values that are reached with a hashindex based on the key. O(1) search
 * @author tom.leonardsson
 *
 * @param <K> key
 * @param <V> value
 */
public class Hashtable<K, V> {
	private Bucket<K, V> table[];
	
	private int size;
	
	/**
	 * Create empty hashtable with specifc capacity
	 * @param capacity the specifc start capacity
	 */
	public Hashtable(int capacity) {
		table = (Bucket<K, V>[])new Bucket[capacity*4];
		for(int i = 0; i < table.length; i++) {
			table[i] = new Bucket<K, V>();
		}
	}
	
	
	/**
	 * Create hashIndex based on the keys hashcode
	 * @param key the key to get the index of
	 * @return the index in the table of the key
	 */
	public int hashIndex(K key) {
		int hashCode = key.hashCode();
		hashCode = hashCode % table.length;
		return (hashCode < 0) ? -hashCode : hashCode;
	}
	
	/**
	 * Put a new element with a key and a value into the table
	 * @param key the key of the element
	 * @param value the value of the element
	 */
	public void put(K key, V value) {
		int counter = 0;
		int removed = -1;
		int hashIndex = hashIndex(key);
		
		while(counter < table.length && table[hashIndex].state != State.EMPTY && table[hashIndex].key != key) {
			if(removed == -1 && table[hashIndex].state != State.REMOVED) 
				removed = hashIndex;
			
			counter += 1;
			hashIndex += 1;
			
			hashIndex = (hashIndex == table.length) ? 0 : hashIndex; 
		}
		
		if(removed != -1) hashIndex = removed;

		table[hashIndex].key = key;
		table[hashIndex].value = value;
		table[hashIndex].state = State.OCCUPIED;
		size += 1;
	}
	
	/**
	 * Remove a specifc element from the table with a key
	 * @param key the key to look for
	 * @return the removed element, null if not found
	 */
	public V remove(K key) {
		int counter = 0;
		int hashIndex = hashIndex(key);
		
		if(get(key) != null) {
			while(counter < table.length && !key.equals(table[hashIndex].key)) {
				counter += 1;
				hashIndex += 1;
				hashIndex = (hashIndex == table.length) ? 0 : hashIndex;
			}
		
			Bucket<K, V> tmp = table[hashIndex];
		
			table[hashIndex].key = null;
			table[hashIndex].value = null;
			table[hashIndex].state = State.REMOVED;
			size -= 1;
		
			return tmp.value;
		}
		return null;
	}
	
	/**
	 * get the value of an element with specifc key
	 * @param key the key to look for
	 * @return the value of the element with the key or null if not found
	 */
	public V get(K key) {
		int counter = 0;
    	int hashIndex = hashIndex(key);
    	
    	while(counter < table.length && table[hashIndex].state != State.EMPTY && !key.equals(table[hashIndex ].key)) {
    		counter += 1;
    		hashIndex += 1;
    		hashIndex = (hashIndex == table.length) ? 0 : hashIndex;
    	}
    	
        return key.equals(table[hashIndex].key) ? table[hashIndex].value : null;
	}
	
	/**
	 * Create iterator that iterates over the values in the hashtable
	 * @return the iterator
	 */
	public Iterator<V> values() {
		ArrayList<V> l = new ArrayList<V>();
		for(int i = 0; i < table.length; i++) {
			if(table[i].state == State.OCCUPIED) {
				l.add(table[i].value);
			}
		}
		
		return l.iterator();
	}
	
	/**
	 * Create iterator that iterates over the keys in the hashtable
	 * @return the iterator
	 */
	public Iterator<K> keys() {
		ArrayList<K> l = new ArrayList<K>();
		for(int i = 0; i < table.length; i++) {
			if(table[i].state == State.OCCUPIED) {
				l.add(table[i].key);
			}
		}
		return l.iterator();
	}
	
	/**
	 * Create structured string that shows the contents of the table
	 * @return the structured string
	 */
	public String toString() {
		String tmp = "";
		for(int i = 0; i < table.length; i++) {
			tmp += (table[i].key + " - " + table[i].value) + ((i < table.length-1) ? "\n " : "");
		}
		return tmp;
	}
}
