package assignment2;

public class Dictionary<K extends Data<K>, V extends Clonable<V>> implements IDictionary<K, V> {

	List<Hello> list;
	
	public Dictionary(){
		
	}
	
	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(K key, V value) {
		// TODO Auto-generated method stub
		
	}
	private class Hello implements Data<Hello> {
		K key;
		V value;
		
		Hello(K key, V Value){
			this.key = key;
			this.value = value;
		}
		
		@Override
		public Hello clone() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public int compareTo(Hello o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}


//Dictionary<Idenitfier, Set<N>> = new Dicitonary<>();