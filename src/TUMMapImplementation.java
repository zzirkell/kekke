import java.util.ArrayList;
import java.util.List;

public class TUMMapImplementation<K,V> implements TUMMap<K,V>{
    private ArrayList<Entry<K,V>> entries;

    public TUMMapImplementation(ArrayList<Entry<K,V>> entries) {
        this.entries = entries;
    }

    public ArrayList<Entry<K, V>> getEntries() {
        return entries;
    }

    public void setEntries(ArrayList<Entry<K, V>> entries) {
        this.entries = entries;
    }

    @Override
    public void clear() {
        entries.clear();

    }

    @Override
    public boolean equals(TUMDataStructure structure) {
        if (entries.equals(structure)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return entries.size();
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i).getKey().equals(key)) {
                return entries.get(i).getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        entries.add(new Entry<>(key, value));
        for (int i = entries.size()-2; i >= 0; i--) {
            if (entries.get(i).getKey().equals(key)) {
                return entries.get(i).getValue();
            }
        }
        return null;

    }

    @Override
    public boolean containsKey(K key) {
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i).getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i).getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V replace(K key, V value) {
        if (containsKey(key)) {
            for (int i = entries.size()-2; i >= 0; i--) {
                if (entries.get(i).getKey().equals(key)) {
                    V temp = entries.get(i).getValue();
                    entries.get(i).setValue(value);
                    return temp;
                }
            }
        } else {
            put(key,value);
        }
        return null;
    }

    public V getValueForLargestKey(){
        return null;
    }
    public List<K> getKeysForMatchingValues(){
        return null;
    }
}
