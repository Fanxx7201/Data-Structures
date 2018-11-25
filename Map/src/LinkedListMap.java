/**
 * @ProjectName: Map
 * @Package: PACKAGE_NAME
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: fanxx
 * @CreateDate: 2018/11/25 16:46
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    //链表节点, 之前我们的链表只有元素e .现在map集合是包含两部分. 一部分是key, 一部分是value
    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key){ //用户传过来key的构造函数
            this(key, null, null);
        }

        public  Node(){ //构造函数
            this(null, null, null);
        }

        @Override
        public String toString(){
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    //获得节点数据的辅助函数
    private Node getNode(K key){
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.key.equals(key)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    @Override
    public void add(K key, V value) {
        //添加操作,
        Node node = getNode(key);
        if(node == null){
            dummyHead.next = new Node();
        }

    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public boolean contains(Object key) {
        return false;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);

        return node == null ? null : node.value;
    }

    @Override
    public void set(Object key, Object newValue) {

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
