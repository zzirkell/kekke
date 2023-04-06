import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TUMMapImplementation<K extends Comparable<K>,V> implements TUMMap<K,V>{
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
        if (containsKey(key)) {
            for (int i = 0; i < entries.size(); i++) {
                if (entries.get(i).getKey().equals(key)) {
                    V temp = entries.get(i).getValue();
                    entries.get(i).setValue(value);
                    return temp;
                }
            }
        } else {
            entries.add(new Entry<>(key, value));
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
            for (int i = entries.size()-1; i >= 0; i--) {
                if (entries.get(i).getKey().equals(key)) {
                    V temp = entries.get(i).getValue();
                    entries.get(i).setValue(value);
                    return temp;
                }
            }
        }
        return null;
    }

    public V getValueForLargestKey(){
        if (entries.size() > 0) {
            K maxim = entries.get(0).getKey();
            for (int i = 1; i < entries.size(); i++) {
                if (entries.get(i).getKey().compareTo(maxim) >= 0) {
                    maxim = entries.get(i).getKey();
                }
            }
            return get(maxim);
        } else {
            return null;
        }
    }
    public List<K> getKeysForMatchingValues(){
        List<K> ks = new ArrayList<>();
        Pattern pattern = Pattern.compile("^[a-z]{2}[1-9]{2}[a-z]{3}$");
        for (int i = 0; i <entries.size(); i++) {
            if (entries.get(i).getValue() instanceof String) {
                if (pattern.matcher((String)entries.get(i).getValue()).find()) {
                    ks.add(entries.get(i).getKey());
                }
            }
        }
        return ks;
    }

    @Override
    public String toString() {
        String s = new String("Map");
        for (int i = 0; i < entries.size(); i++) {
            s += "\nkey " + entries.get(i).getKey();
            s+="\nvalue " + entries.get(i).getValue() + "\n";
        }
        return s;
    }
}
