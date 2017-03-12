package collections;

import java.util.ArrayList;
import java.util.Iterator;

import collections.Bucket.State;

public class Hashtable<K, V> {
	private Bucket<K, V> table[];
	
	private int size;
	
	public Hashtable(int capacity) {
		table = (Bucket<K, V>[])new Bucket[capacity];
		for(int i = 0; i < table.length; i++) {
			table[i] = new Bucket<K, V>();
		}
	}
	
	public int hashIndex(K key) {
		int hashCode = key.hashCode();
		hashCode = hashCode % table.length;
		return (hashCode < 0) ? -hashCode : hashCode;
	}
	
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
	
	public Iterator<V> values() {
		ArrayList<V> l = new ArrayList<V>();
		for(int i = 0; i < table.length; i++) {
			if(table[i].state == State.OCCUPIED) {
				l.add(table[i].value);
			}
		}
		
		return l.iterator();
	}
	
	public Iterator<K> keys() {
		ArrayList<K> l = new ArrayList<K>();
		for(int i = 0; i < table.length; i++) {
			if(table[i].state == State.OCCUPIED) {
				l.add(table[i].key);
			}
		}
		return l.iterator();
	}
	
	public String toString() {
		String tmp = "{";
		for(int i = 0; i < table.length; i++) {
			tmp += (table[i].key + " - " + table[i].value) + ((i < table.length-1) ? ", " : "");
		}
		return tmp + "}";
	}
}
