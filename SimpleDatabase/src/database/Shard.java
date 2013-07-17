package database;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: complexityclass
 * Date: 7/16/13
 * Time: 10:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Shard {


    private Map<String, byte[]> container;


    public Shard() {

        container = new HashMap<String, byte[]>();

    }

    public void create(String key, byte[] value) {
        container.put(key, value);
    }

    public byte[] read(String key) {
        return container.get(key);
    }

    public void update(String key, byte[] value) {

        byte[] swapval = value;
        container.remove(key);
        container.put(key, value);


    }

    public void delete(String key) {
        container.remove(key);
    }

    public void print() {


        for (Map.Entry<String, byte[]> entry : container.entrySet()) {
            String key = entry.getKey();
            byte[] value = entry.getValue();
            System.out.println("key :" + key + "  value :" + value);

        }

    }

}

