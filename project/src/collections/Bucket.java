package collections;

/**
 * Holds a key and a value, also what state it is in
 * @author tom.leonardsson
 *
 * @param <K>
 * @param <V>
 */
public class Bucket<K, V> {
	enum State { EMPTY, OCCUPIED, REMOVED };
	
	public State state;
	
	public K key; 
	public V value;
}
