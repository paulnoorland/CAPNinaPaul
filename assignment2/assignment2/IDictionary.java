package assignment2;

/**
 * @author paulnoorland
 *
 */
public interface IDictionary<K extends Data<K>, V extends Clonable<V>> {
	// Key value storage in a linked list
	
	V get(K key);
	
	void set(K key, V value);
	
}
