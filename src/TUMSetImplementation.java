import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class TUMSetImplementation<V extends Comparable<V>> implements TUMSet<V> {
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
    public V addIfLarger(V value, V than) {
        if (value.compareTo(than) > 0) {
            values.add(value);
            return value;
        } else {
            return null;
        }
    }
    public V getLargestValue(){
        if (values.size() > 0) {
            V maxim = values.get(0);
            for (int i = 1; i < values.size(); i ++) {
                if (values.get(i).compareTo(maxim) >= 0) {
                    maxim = values.get(i);
                }
            }
            return maxim;
        } else {
            return null;
        }
    }

    public List<V> getValuesMatching(){
        List<V> vs = new ArrayList<>();
        Pattern pattern = Pattern.compile("^[A-Z,a-z,\\.]+@(in.)?tum.de$");
        for (int i = 0; i <values.size(); i++) {
            if (values.get(i) instanceof String) {
                if (pattern.matcher((String)values.get(i)).find()) {
                    vs.add(values.get(i));
                }
            }
        }
        return vs;

    }

    @Override
    public String toString() {
        String s = new String();
        for (int i = 0; i < values.size(); i++) {
            s+=values.get(i) + " , ";
        }
        return s;
    }
}
