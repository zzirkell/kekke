import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TUMSet<String> set = new TUMSetImplementation<String>(new ArrayList<>());
        TUMMap<String, String> map = new TUMMapImplementation<String, String>(new ArrayList<>());

        System.out.println("\t[Working with set]\n");
        set.add("dsf");
        set.add("dfsda");
        set.add("asdf");
        set.add("zzz");
        set.add("sdf");
        System.out.println(set.toString());
        set.addIfLarger("a", "z");
        set.addIfLarger("zzz", "D");
        System.out.println(set);
        set.add("dsf");
        System.out.println(set.contains("dsf"));
        System.out.println(set.containsMultipleTimes("dsf"));
        System.out.println(set.containsMultipleTimes("asdf"));
        set.remove("dsf");
        System.out.println(set);
        set.clear();

        System.out.println("\t[Working with map]\n");
        map.put("key1", "sert");
        map.put("key2", "sdfsdfrt");
        map.put("key1", "sersdft");
        map.put("key3", "asdert");
        System.out.println(map);
        map.replace("key4", "Sdfg");
        map.replace("key1", "doggy");
        System.out.println(map);
        System.out.println(map.get("key1"));
        System.out.println(map.get("fe"));
        System.out.println(map.containsKey("asd"));
        System.out.println(map.containsKey("key3"));
        System.out.println(map.containsValue("sdfsdfrt"));
        System.out.println(map.containsValue("asdasdasd"));




    }
}