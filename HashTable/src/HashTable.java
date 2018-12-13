import java.util.TreeMap; //哈希表可以看成是treeMap的数组

/**
 * @ProjectName: HashTable
 * @Package: PACKAGE_NAME
 * @Description:
 * @Author: fanxx
 * @CreateDate: 2018/12/5 14:46
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class HashTable<K, V> {  //k不需要可以比较. java所有类型都是Object的子类.就已经实现了hashCode的方法

    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 7;

    private TreeMap<K, V>[] hashtable;
    private int M; //哈希表具体有多少个位置.
    private int size;

    public HashTable(int M){
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M]; //有M个TreeMap
        for(int i = 0; i < M ; i++){
            //对每一个treeMap进行遍历
            hashtable[i] = new TreeMap<>();
        }
    }

    public HashTable(){
        this(97);
    }

    private int hash(K key){ //这就是将key转化成哈希表索引的过程.
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize(){
        return size;
    }

    public void add(K key, V value){
        //暂存
        TreeMap<K, V> map = hashtable[hash(key)];

        if(map.containsKey(key)){ //已经包含key, 就是一个修改的操作
            map.put(key, value);
        }else {
            map.put(key, value);
            size++;

            if(size >= upperTol * M){ //为了避免浮点数, 没有用除法
                resize(2 * M);
            }
        }
    }

    public V remove(K key){ //返回的是remove调的key对应的值
        TreeMap<K, V> map = hashtable[hash(key)];
        V ret = null;
        if(map.containsKey(key)){
            ret = map.remove(key);
            size--;

            if(size < lowerTol * M && M / 2 >= initCapacity){
                resize(M / 2);
            }
        }
        return ret;
    }

    //修改操作
    public void set(K key, V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        if(!map.containsKey(key)){
            throw new IllegalArgumentException(key + "doesn't exist!");
        }
        map.put(key, value);
    }

    //查询是否有某个key
    public boolean contains(K key){
        return hashtable[hash(key)].containsKey(key);
    }

    //查询某个key对应的value值
    public V get(K key){
        return hashtable[hash(key)].get(key);
    }

    private void resize(int newM){
        //创建一个新的map数组
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        //对每一个treeMap进行初始化

        for(int i = 0; i < newM; i++){

            newHashTable[i] = new TreeMap<>();
        }

        int oldM = M;
        this.M = newM; //hash(key)这个方法用到的M的值已经变化了. 如果还用原来的M ,就不对了
        for (int i = 0; i < oldM; i ++){ // 遍历原来的所有treemap
            TreeMap<K, V> map = hashtable[i];
            for (K key: map.keySet()){
                newHashTable[hash(key)].put(key, map.get(key));
            }
            this.hashtable = newHashTable;
        }

    }

}
