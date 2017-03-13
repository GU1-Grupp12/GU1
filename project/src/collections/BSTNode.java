package collections;

/**
 * Node for the binary search treee, has a key to be indentfied with, a value and has a node on both sides
 * @author rolf
 *
 * @param <K>
 * @param <V>
 */
class BSTNode<K,V> {
    K key;
    V value;
    BSTNode<K,V> left;
    BSTNode<K,V> right;
    
    /**
     * Create a node with a specific key, value, left and right node
     * @param key the key of the node
     * @param value the value of the node
     * @param left the left node of the node
     * @param right the right node of the node
     */
    public BSTNode( K key, V value, BSTNode<K,V> left, BSTNode<K,V> right ) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
    /**
     * get the height of the tree
     * @return the height of the tree
     */
    public int height() {
        int leftH = -1, rightH = -1;
        if( left != null )
            leftH = left.height();
        if( right != null )
            rightH = right.height();
        return 1 + Math.max( leftH, rightH );
    }
    
    /**
     * Get the size of the tree
     * @return the size of the tree
     */
    public int size() {
        int leftS = 0, rightS = 0;
        if( left != null )
            leftS = left.size();
        if( right != null )
            rightS = right.size();
        return 1 + leftS + rightS;
    }
    
    /**
     * print the contents of the tree
     */
    public void print() {
        if( left != null)
            left.print();
        System.out.println(key + ": " + value);
        if( right != null )
            right.print();
    }
    
    public void showTree() {
       // javax.swing.JOptionPane.showMessageDialog( null, new ShowBST<K,V>( this, 800,600 ), "Show tree", javax.swing.JOptionPane.PLAIN_MESSAGE );
    }
}
