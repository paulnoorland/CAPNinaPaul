package assignment2;

public class Dictionary<K extends Data<K>, V extends Clonable<V>> implements IDictionary<K, V> {

	List<DictionaryElement> list;
	
	public Dictionary(){
		list = new List<DictionaryElement>();
	}
	
	public void init(){
		list = new List<DictionaryElement>();
	}
	
	@Override
	public V getValue(K key) throws APException {
		list.goToFirst();
		DictionaryElement d = new DictionaryElement(key, null);		//beter manier?
		
		for(int i = 0; i < list.size(); i++){
			
			if(list.retrieve().compareTo(d) == 0) return list.retrieve().getValue().clone();
			list.goToNext();
		}
		
		throw new APException("Identifier is not initialized.");
	}
	
	
	public int length(){
		return list.size();
	}

	@Override
	public void add(K key, V value) {
		
		DictionaryElement temp = new DictionaryElement(key, value);
		
		if(list.find(temp)) list.remove();
		list.insert(temp);	
	}
	
	public void remove(K key) throws APException{
		list.goToFirst();
		
		for(int i = 0; i < list.size(); i++){
			
			if(list.retrieve().getKey().compareTo(key) == 0){
				list.remove();
				break;
			}
			list.goToNext();
		}
		throw new APException("Key is not in the dictionary");
	}
	
	private class DictionaryElement implements Data<DictionaryElement> {
		private K key;
		private V value;
		
		DictionaryElement(K key, V value){
			this.key = key;
			this.value = value;
		}
		
		public V getValue(){
			return value;
		}
		
		public K getKey(){
			return key;
		}
		
		@Override
		public DictionaryElement clone() {
			K k = this.key;
			V v = this.value;
			return new DictionaryElement(k, v);
		}
		
		@Override
		public int compareTo(DictionaryElement o) {
			return key.compareTo(o.getKey());
		}
	}
}