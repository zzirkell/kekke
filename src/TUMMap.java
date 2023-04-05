public interface TUMMap<K,V> extends TUMDataStructure{
    public V get(K key);
    public V put (K key, V value);
    public boolean containsKey(K key);
    public boolean containsValue(V value);
    public V replace(K key, V value);

}
