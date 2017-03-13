package collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import collections.List;

/**
 * A binary tree that is always sorted so that it is more efficant to search in
 * @author tom.leonardsson & rolf
 *
 * @param <K>
 * @param <V>
 */
public class BinarySearchTree<K,V> {
    private Comparator<K> comparator;
    private BSTNode<K,V> tree;
    private int size;
    
    /**
     * create binary search tree with natrual sorting order
     */
    public BinarySearchTree() {
        comparator = new Comp();
    }
    
    /**
     * create tree with specific sorting order
     * @param comp the specfic sorting order
     */
    public BinarySearchTree( Comparator<K> comp ) {
        comparator = comp;
    }
    
    /**
     * get the root of the tree
     * @return the root-node
     */
    public BSTNode<K,V> root() {
        return tree;
    }
    
    /**
     * get the value of the node with the specific key
     * @param the key to look after
     * @return the value of the found node
     */
    public V get(K key) {
        BSTNode<K,V> node = find( key );
        if(node!=null)
            return node.value;
        return null;
    }
    
    /**
     * add node to tree with specifc value and key
     * @param value the value of the node
     * @param key the key of the node
     */
    public void put(K key, V value) {
        tree = put(tree,key,value);
        size++;
    } 
    
    /**
     * Remove the node with the specific key
     * @param key the key of the node to be removed
     * @return the value of the node that was removed
     */
    public V remove(K key) {
        V value = get( key );
        if(value!=null) {
            tree = remove(tree,key);
            size--;
        }
        return value;
    }
    
    /**
     * check if node with key exists within the tree
     * @param key the key to look with
     * @return if the tree has the node with the key
     */
    public boolean contains( K key ) {
        return find( key ) != null;
    }
    
    /**
     * get the height of the tree
     * @return the height of the tree
     */
    public int height() {
        return height( tree );
    }
    
    /**
     * create an iterator from the private class Iter
     * @return an iterator of the tree
     */
    public Iterator<V> iterator() {
        return new Iter();
    }
    
    private BSTNode<K,V> find(K key) {
        int res;
        BSTNode<K,V> node=tree;
        while( ( node != null ) && ( ( res = comparator.compare( key, node.key ) ) != 0 ) ) {
            if( res < 0 )
                node = node.left;
            else
                node = node.right;
        }
        return node;
    }
    
    private BSTNode<K,V> put(BSTNode<K,V> node, K key, V value) {
        if( node == null ) {
            node = new BSTNode<K,V>( key, value, null, null );
        } else {
            if(comparator.compare(key,node.key)<0) {
                node.left = put(node.left,key,value);
            } else if(comparator.compare(key,node.key)>0) {
                node.right = put(node.right,key,value);
            }
        }
        return node;
    }
    
    private BSTNode<K,V> remove(BSTNode<K,V> node, K key) {
        int compare = comparator.compare(key,node.key);
        if(compare==0) {
            if(node.left==null && node.right==null)
                node = null;
            else if(node.left!=null && node.right==null)
                node = node.left;
            else if(node.left==null && node.right!=null)
                node = node.right;
            else {
                BSTNode<K,V> min = getMin(node.right);
                min.right = remove(node.right,min.key);
                min.left = node.left;
                node = min;
            }
        } else if(compare<0) {
            node.left = remove(node.left,key);
        } else {
            node.right = remove(node.right,key);
        }
        return node;
    }
    
    private BSTNode<K,V> getMin(BSTNode<K,V> node) {
        while(node.left!=null)
            node = node.left;
        return node;
    }
        
    private int height( BSTNode<K,V> node ) {
        if( node == null )
            return -1;
        return 1 + Math.max( height( node.left ), height( node.right ));
    }
    
    /**
     * Get the size of the tree
     * @return the size of the tree
     */
    public int size() {
        return size;
    }
    
    /**
     * get the size of the tree
     * @return the size of the tree
     */
    public int size1() {
    	return (tree != null) ? this.tree.size() : 0;
    }
    
    /**
     * get the size of the tree
     * @return the size of the tree
     */
    public int size2() {
    	return (tree != null) ? 1 + ((tree.right != null) ? tree.right.size() : 0) + ((tree.left != null) ? tree.left.size() : 0) : 0;
    }
    
    /**
     * get the first value in the tree, which will always be on the left since the tree is always sorted
     * @return the first value in the tree
     */
    public V first(){
    	if(tree == null) return null;
    	BSTNode<K, V> node = tree;
    	while(node.left != null)
    		node = node.left;
        return node.value;
    }

    /**
     * get the last value in the tree, which will always be on the right since the tree is always sorted
     * @return the last value in the tree
     */
    public V last(){
    	if(tree == null) return null;
    	BSTNode<K, V> node = tree;
    	while(node.right != null)
    		node = node.right;
        return node.value;
    }
    
    /**
     * print the contents of the tree in preorder
     */
    public void printPreorder() {
    	printPreorder(tree);
    }
    
    private void printPreorder(BSTNode<K,V> node) {
    	if(node != null) {
    		System.out.println("key: " + node.key + " | value: " + node.value);
    		printPreorder(node.left);
    		printPreorder(node.right);
    	}
    }
    
    /**
     * Print out the contents of the tree
     */
    public void print() {
    	print(tree);
    }
    
    private void print(BSTNode<K,V> node) {
    	if(node != null) {
    		print(node.left);
    		System.out.println("key: " + node.key + " | value: " + node.value);
    		print(node.right);
    	}
    }
    
    /**
     * get a list of the keys of the nodes in the tree
     * @return a list of keys
     */
    public ArrayList<K> keys(){
    	ArrayList<K> list = new ArrayList<K>();
    	keys(tree, list);
        return list;
    }
    
    /**
     * Put all the keys into a list recusivly
     * @param node the current nodes key being put in
     * @param list the list that is being filled with keys
     */
    private void keys(BSTNode<K,V> node, ArrayList<K> list){
    	if(node!=null) {
    		keys(node.left, list);
            list.add(node.key);
            keys(node.right, list);
        }
    }
    
    /**
     * get a list filled with the values of all the nodes
     * @return a list with all the values of the trees nodes
     */
    public ArrayList<V> values(){
    	if(tree == null) return null;
    	Iterator elements = iterator();
    	ArrayList<V> tmp = new ArrayList<V>();
    	while(elements.hasNext())
    		tmp.add((V) elements.next());
    	return tmp;
    }
        
    /**
     * Sorting order for the tree
     * @author Rolf Axelsson
     *
     */
    private class Comp implements Comparator<K> {
    	/**
    	 * Get if the key is greater, lesser or equal to the other
    	 * @return if the key is greater, lesser or equal to the other
    	 */
        public int compare( K key1, K key2 ) {
            Comparable<K> k1 = ( Comparable<K> )key1;
            return k1.compareTo( key2 );
        }
    }
    
    /**
     * Iterator for the tree
     * @author Rolf Axelsson
     *
     */
    private class Iter implements Iterator<V> {
        ArrayList<V> list = new ArrayList<V>();
        int index = -1;
        
        /**
         * Create iterator
         */
        public Iter() {
            inOrder(tree);
        }
        
        /**
         * Put all the nodes into a list recursivly 
         * @param node the node that is being put in
         */
        private void inOrder(BSTNode<K,V> node) {
            if(node!=null) {
                inOrder(node.left);
                list.add(node.value);
                inOrder(node.right);
            }
        }
        
        /**
         * the iterator has a next value 
         * @return if there is a next value
         */
        public boolean hasNext() {
            return index<list.size()-1;
        }
        
        /**
         * get the next value in the list
         * @return the next value
         */
        public V next() {
            if(!hasNext())
                throw new NoSuchElementException();
            index++;
            return list.get(index);
        }
        
        /**
         * throws exception
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
