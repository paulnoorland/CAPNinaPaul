package assignment2;

public class Dictionary<K extends Data<K>, V extends Clonable<V>> implements IDictionary<K, V> {

	List<Something> list;
	
	
	private Something implements Data<Something> {
		K key;
		V value;
	}
}


Dictionary<Idenitfier, Set<NN>> = new Dicitonary<>();