package database;

/**
 * Created with IntelliJ IDEA.
 * User: complexityclass
 * Date: 7/16/13
 * Time: 10:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShardManager {

    public static final int SHARD_COUNT = 3;

    Shard[] masters;

    ShardManager() {
        masters = new Shard[SHARD_COUNT];
        for(int i = 0; i < masters.length; i++){
            masters[i] = new Shard();
        }
    }

    private int hashFunction(String key) {

        return key.length() % 3;
    }

    public void create(String key, byte[] value) {
        int position = hashFunction(key);
        masters[position].create(key, value);
    }

    public byte[] read(String key) {
        int position = hashFunction(key);
        return masters[position].read(key);
    }

    public void update(String key, byte[] value) {
        int position = hashFunction(key);
        masters[position].update(key, value);
    }

    public void delete(String key){
        int position = hashFunction(key);
        masters[position].delete(key);
    }

    public void print(){
        for(Shard shard : masters){
            shard.print();
        }
    }
}
