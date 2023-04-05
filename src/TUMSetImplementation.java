import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

public class TUMSetImplementation<V> implements TUMSet<V> {
    private ArrayList<V> values;

    public TUMSetImplementation(ArrayList<V> values) {
        this.values = values;
    }

    public ArrayList<V> getValues() {
        return values;
    }

    public void setValues(ArrayList<V> values) {
        this.values = values;
    }

    @Override
    public void clear() {
        values.clear();
    }

    @Override
    public boolean equals(TUMDataStructure structure) {
        if (values.equals(structure)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return values.size();
    }

    @Override
    public V add(V value) {
        for (int i = 0; i < values.size(); i ++) {
            if (values.get(i).equals(value)) {
                values.add(value);
                return values.get(i);
            }
        }
        values.add(value);
        return null;
    }

    @Override
    public V remove(V value) {
        boolean flag = false;
        Iterator<V> iterator = values.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(value)) {
                iterator.remove();
                flag = true;
            }
        }
        if (flag) {
            return value;
        }
        return null;
    }

    @Override
    public boolean contains(V value) {
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsMultipleTimes(V value) {
        int counter = 0;
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).equals(value)) {
                counter++;
            }
        }
        if (counter > 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object addIfLarger(Object value, Object than) {
        return null;
    }
    public V getLargestValue(){
        return null;
    }

    public List<V> getValuesMatching(){
        return null;
    }
}
