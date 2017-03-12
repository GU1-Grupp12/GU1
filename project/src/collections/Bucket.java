package collections;

public class Bucket<K, V> {
	enum State { EMPTY, OCCUPIED, REMOVED };
	
	public State state;
	
	public K key; 
	public V value;
}
