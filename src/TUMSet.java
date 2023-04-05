public interface TUMSet<V> extends TUMDataStructure {
    public V add(V value);
    public V remove(V value);
    public boolean contains(V value);
    public boolean containsMultipleTimes(V value);
    public V addIfLarger(V value, V than);
}
